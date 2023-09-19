package com.example.demoreactivefsm;

import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ErrorConfig {

	@Bean
	public ErrorAttributes errorAttributes() {
		return new DefaultErrorAttributes();
	}
}
