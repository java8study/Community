package kr.co.study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@ImportResource({ "classpath*:/META-INF/egovframework/spring/com/context-*.xml" })
public class WebApplicationContextConfig
{

    public WebApplicationContextConfig()
    {
        super();
    }

    @Configuration
    @Profile("server")
    @PropertySource("classpath:/META-INF/egovframework/egovProps/globals.properties")
    static class Servers
    {
    }

    @Configuration
    @Profile("test")
    @PropertySource({ "classpath:/META-INF/egovframework/egovProps/globals.properties",
            "classpath:/META-INF/egovframework/egovProps/test-globals.properties" })
    static class Tests
    {
    }

    @Autowired
    private Environment environment;

    @Bean
    public static PropertySourcesPlaceholderConfigurer webMobilePropertySourcesPlaceholderConfigurer()
    {
        return new PropertySourcesPlaceholderConfigurer();
    }
}