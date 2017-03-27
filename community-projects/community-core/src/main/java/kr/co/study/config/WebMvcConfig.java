package kr.co.study.config;

import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.PathExtensionContentNegotiationStrategy;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import egovframework.com.ext.jstree.support.manager.viewResolver.CustomInternalResourceViewResolver;
import egovframework.com.ext.jstree.support.manager.viewResolver.SpecialPurposeViewResolver;

/**
 * Class Name : WebMvcConfig.java Description : 스프링 서블릿 웹 애플리케이션 컨텍스트 설정을 위한 자바
 * 클래스
 * 
 * @author Dongmin.Lee
 * @since 2014.07.02
 * @version 1.0
 * @see
 *
 *      <pre>
 *  << 개정이력(Modification Information) >>
 *  
 *  수정일         수정자             수정내용
 *  -------      ------------   -----------------------
 *  2014.07.02    Dongmin.Lee      최초 생성
 *  2014.07.29	  류강하		   표준 프레임워크 내 urlfilename-servlet.xml 파일 변경에 따른 백업 파일 생성 및 바로보드 프로젝트 패키지로 이동에 따른 수정
 * 
 *  Copyright (C) 2007 by 313 DeveloperGroup  All right reserved.
 * </pre>
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "egovframework, standard.mvc", excludeFilters = @Filter(Configuration.class))
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ImportResource({ "classpath:/META-INF/egovframework/spring/config/*.xml" })
public class WebMvcConfig extends WebMvcConfigurerAdapter
{
    @Value("#{systemProperties['spring.profiles.active']}")
    private String springProfilesActive;
    
    @Autowired
    private ApplicationContext applicationContext;
    
    @Autowired
    private ExceptionHandlerExceptionResolver exceptionHandlerExceptionResolver;
    
    @Autowired
    private SpecialPurposeViewResolver specialPurpose;
    
    @Autowired
    private UrlBasedViewResolver urlBasedViewResolver;
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        // registry.addResourceHandler("/resources/**").addResourceLocations("/public-resources/");
        super.addResourceHandlers(registry);
    }
    
    @Bean
    public ContentNegotiatingViewResolver contentNegotiatingViewResolver()
    {
        ContentNegotiatingViewResolver viewResolver = new ContentNegotiatingViewResolver();
        viewResolver.setContentNegotiationManager(contentNegotiationManager());
        
        List<ViewResolver> viewResolvers = new ArrayList<>();
        
        viewResolvers.add(specialPurpose);
        viewResolvers.add(urlBasedViewResolver);
        viewResolvers.add(internalResourceViewResolver());
        viewResolver.setViewResolvers(viewResolvers);
        List<View> defaultViews = new ArrayList<>();
        
        MappingJackson2JsonView mappingJackson2JsonView = new MappingJackson2JsonView();
        mappingJackson2JsonView.setExtractValueFromSingleKeyModel(true);
        mappingJackson2JsonView.setModelKey("result");
        defaultViews.add(mappingJackson2JsonView);
        viewResolver.setDefaultViews(defaultViews);
        return viewResolver;
    }
    
    @Bean
    public ContentNegotiationManager contentNegotiationManager()
    {
        Map<String, MediaType> mediaTypes = new HashMap<>();
        mediaTypes.put("html", MediaType.TEXT_HTML);
        mediaTypes.put("json", MediaType.APPLICATION_JSON);
        ContentNegotiationStrategy contentNegotiationStrategy = new PathExtensionContentNegotiationStrategy(mediaTypes);
        return new ContentNegotiationManager(contentNegotiationStrategy);
    }
    
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver()
    {
        InternalResourceViewResolver internalResourceViewResolver = new CustomInternalResourceViewResolver();
        internalResourceViewResolver.setViewClass(JstlView.class);
        internalResourceViewResolver.setPrefix("/WEB-INF");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }
    
    @Bean
    public MessageSource messageSource()
    {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource
                .setBasenames("public-resources/message/message",
                              MessageFormat.format("public-resources/message/clientenv-{0}", springProfilesActive));
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
        if (!Arrays.asList(applicationContext.getEnvironment().getActiveProfiles()).contains("live"))
        {
            messageSource.setCacheSeconds(0);
        }
        return messageSource;
    }
    
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
    {
        configurer.enable();
    }
}
