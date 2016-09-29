package com.crewguru.config;  
  
import java.util.List;

import javax.servlet.MultipartConfigElement;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
  
@Configuration 
@ComponentScan("com.crewguru") 
@EnableWebMvc   

public class AppConfig extends WebMvcConfigurerAdapter{ 
	
	
	 @Override
	    public void configureViewResolvers(ViewResolverRegistry registry) {
	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setViewClass(JstlView.class);
	        viewResolver.setPrefix("/");
	        viewResolver.setSuffix("");
	        registry.viewResolver(viewResolver);
	    }
	 
	    @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	    }
	    
	    /* @Bean
	    public DataSource dataSource() {
	        System.out.println("userDBDatasource :: init");
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://crewgurudb.c4e4cfwvtjkg.us-west-2.rds.amazonaws.com:3306/crewguru");
	        dataSource.setUsername("crewguru_user");
	        dataSource.setPassword("crewguru16");
	        return dataSource;
	    }
	    
	    @Bean
	    public MultipartConfigElement multipartConfigElement() {
	    	MultipartConfigFactory factory = new MultipartConfigFactory();
	        factory.setMaxFileSize("128KB");
	        factory.setMaxRequestSize("128KB");
	        return factory.createMultipartConfig();
	    }*/
	    
	    @Bean(name = "multipartResolver")
	    public CommonsMultipartResolver multiPartResolver(){

	        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
	        return resolver;
	    }
	    
	    /*@Override
	    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
	        configurer.favorPathExtension(false);
	        configurer.defaultContentType(MediaType.APPLICATION_JSON);
	    }
	    
	    @Override
	    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

	        // http
	        HttpMessageConverter converter = new StringHttpMessageConverter();
	        converters.add(converter);
	        //logger.info("HttpMessageConverter added");

	        // string
	        converter = new FormHttpMessageConverter();
	        converters.add(converter);
	       // logger.info("FormHttpMessageConverter added");

	        // json
	        converter = new MappingJackson2HttpMessageConverter();
	        converters.add(converter);
	        //logger.info("MappingJackson2HttpMessageConverter added");

	    }*/
	    
}  
