package com.example.demo.webflux.app.openapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;

@Configuration
@EnableWebFlux
@OpenAPIDefinition(info = @Info(
				contact = @Contact(name = "AJ Snow", email = "ajsnow2012@gmail.com", url= "https://github.com/AlbertSnows"),
				title = "OpenAPIs Examples",
				version = "1.0",
				license = @License(name = "MPL 2"),
				termsOfService = "blah",
				description = "My implementation of iocumentation APIs v1.0"),
servers = {
				@Server(
								description = "local env",
								url = "http://localhost:8080"),
				@Server(description = "local env but different",
								url = "http://localhost:8080")})

public class OpenApiConfig {
//	@Bean
//	public GroupedOpenApi publicApi() {
//		SpringDocUtils.getConfig()
//						.replaceWithClass(org.springframework.data.domain.Pageable.class, Void.class);
//		return GroupedOpenApi.builder()
//						.group("public-api")
//						.pathsToMatch("/**") // Customize paths as needed
//						.build();
//	}
}
