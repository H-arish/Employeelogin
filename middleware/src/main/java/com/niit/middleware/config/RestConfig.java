package com.niit.middleware.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configurable
@EnableWebMvc
@ComponentScan(basePackages="com.niit")
public class RestConfig 
{

	@Bean(name="viewResolver")
	public ViewResolver getViewResolver()
	{
		System.out.println("REST__config");

		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views");
		viewResolver.setSuffix(".jsp");
		
		System.out.println("REST__config---ENded");
		
		return viewResolver;
		
		


		
	}
	
}
