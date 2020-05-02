package com.github.springsecurity.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Configuration to generate API documentation in swagger
 * 
 * @author Sunny Srivastava
 * @since 1.0
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Resource
	private AppProperties app;

	@Bean
	public Docket api() {
		final Contact contact = new Contact(app.getOwnerName(), null, app.getOwnerMail());
		final ApiInfo apiInfo = new ApiInfo(app.getName(), app.getDescription(), app.getVersion(), null, contact, null,
				null, Collections.<VendorExtension>emptyList());
		final Set<String> produces = new HashSet<>(Arrays.asList(MediaType.APPLICATION_JSON_VALUE));
		final Set<String> consumes = new HashSet<>(Arrays.asList(MediaType.APPLICATION_JSON_VALUE));
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo).consumes(consumes).produces(produces).select()
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class)).paths(PathSelectors.any()).build();
	}
}
