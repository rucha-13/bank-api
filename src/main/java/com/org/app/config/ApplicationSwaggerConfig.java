package com.org.app.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan(basePackages="com.org.app.api")
public class ApplicationSwaggerConfig {
	
	@Bean
	   public Docket customDocket(){
	      return new Docket(DocumentationType.SWAGGER_2)
	    		  .select()
	              .apis(RequestHandlerSelectors.any())
	              .paths(PathSelectors.any())
	              .build()
	              .apiInfo(getApiInfo());
	   }

	   private ApiInfo getApiInfo() {
		   return new ApiInfo(
			"REST Bank backend Api Documentation",
			"This is REST API documentation of the Spring Bank backend api.",
			"1.0",
			"Free to use",
			new Contact(
					"Rucha Sanap",
					"https://github.com/rucha-13",
					"sanaprucha@gmail.com"),
			"API Licence",
			"http://localhost:8090/", Collections.emptyList());
	   }

}
