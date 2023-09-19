package com.example.demoreactivefsm;

import org.jetbrains.annotations.NotNull;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

@Component
@Order(-2)
class RestWebExceptionHandler implements WebExceptionHandler {

	@Override
	public @NotNull Mono<Void> handle(@NotNull ServerWebExchange exchange,
	                                  @NotNull Throwable ex) {
		var data = ex.getMessage();
		return Mono.error(ex);
	}
}