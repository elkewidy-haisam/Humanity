package com.humanity.config;

import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@WebAppConfiguration
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	protected String[] getServletMappings() {
		
		return new String[] { "/" };
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class<?>[] { };
		
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class<?>[] { WebConfig.class };
		
	}

}