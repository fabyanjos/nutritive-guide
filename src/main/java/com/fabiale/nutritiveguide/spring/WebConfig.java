package com.fabiale.nutritiveguide.spring;

import java.util.List;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fabiale.nutritiveguide.gson.GSONHttpMessageConverter;

@Configuration
@EnableWebMvc
@ComponentScan("com.fabiale.nutritiveguide")
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("WEB-INF/css/**");
		registry.addResourceHandler("/js/**").addResourceLocations("WEB-INF/js/**");
		registry.addResourceHandler("/images/**").addResourceLocations("WEB-INF/images/**");
		registry.addResourceHandler("/fonts/**").addResourceLocations("WEB-INF/fonts/**");
		super.addResourceHandlers(registry);
	}
	
	@Bean
    public ViewResolver getViewResolver() {

        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("WEB-INF/pages/");
        resolver.setSuffix(".jsp");

        return resolver;
	}
	
	@Bean public GSONHttpMessageConverter jsonConverter() {
		return new GSONHttpMessageConverter();
	}
	
	@Bean public Jaxb2RootElementHttpMessageConverter xmlConverter() {
		return new Jaxb2RootElementHttpMessageConverter();
	}
	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(jsonConverter());
		converters.add(xmlConverter());
		super.configureMessageConverters(converters);
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver result = new SessionLocaleResolver();
		result.setDefaultLocale(new Locale("pt","BR"));

		return result;
	}
}
