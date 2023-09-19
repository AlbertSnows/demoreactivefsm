package com.example.demoreactivefsm;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@ControllerAdvice
class GeneralErrorHandler extends ResponseEntityExceptionHandler {

	@Override
	protected Mono<ResponseEntity<Object>> handleResponseStatusException(
					ResponseStatusException ex, HttpHeaders headers, HttpStatusCode status,
					ServerWebExchange exchange) {
		// do what you need/like:
		HttpStatusCode myNewStatus;
        /*

        switch (status.value()) { // alternatively: if (status.isXXX()) [else if .. else ..]
           ...
        }*/
		return /*super.*/handleExceptionInternal(ex, null, headers, HttpStatus.INTERNAL_SERVER_ERROR, exchange);
	}
}