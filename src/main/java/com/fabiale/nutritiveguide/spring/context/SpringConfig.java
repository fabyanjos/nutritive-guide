package com.fabiale.nutritiveguide.spring.context;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;

import com.fabiale.nutritiveguide.spring.RepositoryConfig;
import com.fabiale.nutritiveguide.spring.RestTemplateConfig;
import com.fabiale.nutritiveguide.spring.WebConfig;

@Configuration
@ComponentScan(value = "com.fabiale.nutritiveguide", excludeFilters = @ComponentScan.Filter(Configuration.class))
@Import({ WebConfig.class, RepositoryConfig.class, RestTemplateConfig.class })
public class SpringConfig {

	@Bean
	public PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		ppc.setLocation(new ClassPathResource("application.properties"));
		ppc.setIgnoreUnresolvablePlaceholders(true);
		return ppc;
	}
}
