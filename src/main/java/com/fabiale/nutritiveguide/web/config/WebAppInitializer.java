package com.fabiale.nutritiveguide.web.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import com.fabiale.nutritiveguide.web.filter.SiteMeshConfigFilter;

public class WebAppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext context) throws ServletException {
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.setServletContext(context);
		appContext.scan("com.fabiale.nutritiveguide.spring.context");
		appContext.refresh();
		
		// Add context loader listener 
		context.addListener(new ContextLoaderListener(appContext));
		
		this.sitemesh(context);
		
		this.encodingFilter(context);
		
		ServletRegistration.Dynamic dispatcher = context.addServlet("dispatcher", new DispatcherServlet(appContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}
	
	private void sitemesh(ServletContext context) {
		FilterRegistration.Dynamic sitemeshFilter = context.addFilter("sitemesh", new SiteMeshConfigFilter());
		sitemeshFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class),false,"*");
	}
	
	private void encodingFilter(ServletContext context) {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		Dynamic urtf8Filter = context.addFilter("encoding-filter" , characterEncodingFilter);
		urtf8Filter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class),false,"/*");
	}
}