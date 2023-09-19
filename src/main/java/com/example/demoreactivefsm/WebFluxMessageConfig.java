package com.example.demoreactivefsm;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
public class WebFluxMessageConfig implements WebFluxConfigurer {
	@Override
	public void configureHttpMessageCodecs(@NotNull ServerCodecConfigurer configurer) {
		configurer.defaultCodecs().jackson2JsonEncoder(new Jackson2JsonEncoder());
		configurer.defaultCodecs().jackson2JsonDecoder(new Jackson2JsonDecoder());
	}
}