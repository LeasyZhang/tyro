package com.tyro.config.swagger;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket userApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("userApi").apiInfo(apiInfo()).select()
				.paths(userPaths()).build();
	}

	private Predicate<String> userPaths() {
		return regex("/user.*");
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Using Swagger in SpringBoot").description("simple demos")
				.termsOfServiceUrl("https://github.com/BarkZhang/tyro").contact("programmer annonymous").version("1.0")
				.build();
	}
}
