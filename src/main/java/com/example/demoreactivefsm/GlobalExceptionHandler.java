package com.example.demoreactivefsm;

import org.jetbrains.annotations.NotNull;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.util.Map;


@Component
@Order(-2)
public class GlobalExceptionHandler extends AbstractErrorWebExceptionHandler {

	/**
	 * Create a new {@code AbstractErrorWebExceptionHandler}.
	 *
	 * @param errorAttributes    the error attributes
	 * @param resources          the resources configuration properties
	 * @param applicationContext the application context
	 * @since 2.4.0
	 */
	public GlobalExceptionHandler(ErrorAttributes errorAttributes,
	                              WebProperties.Resources resources,
	                              ApplicationContext applicationContext) {
		super(errorAttributes, resources, applicationContext);
	}

	@Override
	protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
		return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
	}

	private @NotNull Mono<ServerResponse>
	renderErrorResponse(ServerRequest serverRequest) {
		var errorOptions = ErrorAttributeOptions.of(
						ErrorAttributeOptions.Include.EXCEPTION,
						ErrorAttributeOptions.Include.MESSAGE,
						ErrorAttributeOptions.Include.BINDING_ERRORS);
		var errorAttributes = getErrorAttributes(serverRequest, errorOptions);
		errorAttributes.put("informal_message", "This is an intentional response. If you're seeing this, then " +
						"your request caused some sort of error. The rest of this response should hopefully have enough" +
						"information to help you discern the cause");
		return ServerResponse.status(HttpStatus.BAD_REQUEST)
						.contentType(MediaType.APPLICATION_JSON)
						.body(BodyInserters.fromValue(errorAttributes));
	}
}