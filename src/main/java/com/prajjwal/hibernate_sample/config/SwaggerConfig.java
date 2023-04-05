package com.prajjwal.hibernate_sample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@Profile("devouhu")
//@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

	@Autowired
	BuildProperties buildProperties;

	public static final String teacher_description_tag = "Teachers_description_tag";

	@Bean
	public Docket apiDocumentation() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("prajjwal.com").select()
				.apis(RequestHandlerSelectors.basePackage("com.prajjwal.hibernate_sample.rest.person"))
				.paths(PathSelectors.regex("/.*")).build().apiInfo(apiInfo());
	}

	@Bean
	public ApiInfo apiInfo() {
		final ApiInfoBuilder builder = new ApiInfoBuilder();
		builder.title("SwaggerTestApp").version("1.0").license("(C) Copyright Test")
				.description("The API provides a platform to query build test swagger api")
				.version(buildProperties.getVersion());

		return builder.build();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/swagger-ui/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
				.resourceChain(false);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/swagger-ui/").setViewName("forward:/swagger-ui/index.html");
	}

	@Bean
	public Docket teacherApiDocumentation() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("prajjwal2.com").select()
				.apis(RequestHandlerSelectors.basePackage("com.prajjwal.hibernate_sample.rest.teacher"))
				.paths(PathSelectors.regex("/.*")).build().apiInfo(apiInfo())
				.tags(new Tag(teacher_description_tag, "teacher description tag"));
	}
}
