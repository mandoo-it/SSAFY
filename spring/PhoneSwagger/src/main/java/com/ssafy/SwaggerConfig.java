package com.ssafy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	//http://localhost:9090/phoneswagger/swagger-ui.html
	
	@Bean
	public Docket api() {
		System.out.println("api");
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("pms")	// select a spec
				.apiInfo(info())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ssafy.pms.controller"))
				.paths(PathSelectors.any())
				//.paths(PathSelectors.ant("/phone/**"))
				.build();

	}

	private ApiInfo info() {
		return new ApiInfoBuilder().title("Phone Management API")
				.description("헨드폰 관리를 위한 <b>CRUD 제공</b>")
				.license("그냥 써요")
				.version("2.0")
				.build();
	}
}
