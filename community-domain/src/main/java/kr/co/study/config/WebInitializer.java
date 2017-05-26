package kr.co.study.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;

public class WebInitializer implements WebApplicationInitializer {

	private static final String CONFIG_LOCATION = "kr.co.study.config";
	private static final String MAPPING_URL = "/";

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		registerDispatcherServlet(servletContext);
		registerCharacterEncodingFilter(servletContext);
	}

	private void registerDispatcherServlet(ServletContext servletContext) {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.setDisplayName("Community");
		context.setConfigLocation(CONFIG_LOCATION);
		context.register(WebConfig.class);
		servletContext.addListener(new ContextLoaderListener(context));
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping(MAPPING_URL);
	}

	private void registerCharacterEncodingFilter(ServletContext servletContext) {
		FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("characterEncodingFilter", new CharacterEncodingFilter());
		characterEncodingFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
		characterEncodingFilter.setInitParameter("encoding", "UTF-8");
	}


}