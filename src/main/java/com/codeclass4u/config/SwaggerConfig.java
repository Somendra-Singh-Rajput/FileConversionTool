package com.codeclass4u.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Contact;

@Configuration
@EnableSwagger2
@ConfigurationProperties("app.api")
@ConditionalOnProperty(name="app.api.swagger.enable", havingValue = "true", matchIfMissing = false)
public class SwaggerConfig{

	@Value("app.api.version")
	private String version;

	@Value("app.api.title")
 	private String title;

	@Value("app.api.description")
 	private String description;

	@Value("app.api.base-package")
	private String basePackage;

	@Value("app.api.contact-name")
	private String contactName;

	@Value("app.api.contact-email")
	private String contactEmail;

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.codeclass4u.controller"))
				.paths(PathSelectors.ant("/api/v1/*")).build();
	}

	private ApiInfo metaData() {
		return new ApiInfoBuilder()
				.title(title)
				.description(description)
				.version(version)
				.contact(new Contact(contactName, "https://codeclass4u.com", contactEmail))
				.build();
	}
}
