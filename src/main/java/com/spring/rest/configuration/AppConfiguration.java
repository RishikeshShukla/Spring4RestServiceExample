package com.spring.rest.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Rishikesh Shukla
 * 
 * Replacement of spring dispatcher servlet
 *
 */
@Configuration
@EnableAspectJAutoProxy
@EnableWebMvc
@ComponentScan(basePackages = "com.spring.rest")
public class AppConfiguration extends WebMvcConfigurerAdapter {

	/**
	 * @param configurer
	 * 
	 * Settings for content negotiation for the application, default is set to
	 * JSON
	 * The order of checking is always path extension, parameter, Accept header.
	 */
	@Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(true).
        favorParameter(false).
        parameterName("mediaType").
        ignoreAcceptHeader(false).
        useJaf(false).
        defaultContentType(MediaType.APPLICATION_JSON).
        mediaType("xml", MediaType.APPLICATION_XML).
        mediaType("json", MediaType.APPLICATION_JSON);
    }
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}
