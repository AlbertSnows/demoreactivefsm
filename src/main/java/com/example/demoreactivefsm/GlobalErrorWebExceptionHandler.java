package com.example.demoreactivefsm;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Map;

@ControllerAdvice
class GeneralErrorHandler extends ResponseEntityExceptionHandler {

	@Override
	protected @NotNull Mono<ResponseEntity<Object>>
	handleResponseStatusException(@NotNull ResponseStatusException ex,
	                              @NotNull HttpHeaders headers,
	                              @NotNull HttpStatusCode status,
	                              @NotNull ServerWebExchange exchange) {
		var message = Map.of("message", "This is an intentional response." +
						"There was an error with your request. Additional context should be provided with the" +
						"rest of the message.");
		return /*super.*/handleExceptionInternal(ex, message, headers, status, exchange);
	}
}