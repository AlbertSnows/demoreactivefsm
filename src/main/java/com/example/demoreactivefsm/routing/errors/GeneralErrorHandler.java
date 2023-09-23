//package com.example.demoreactivefsm.routing.errors;
//
//import org.jetbrains.annotations.NotNull;
//import org.springframework.boot.autoconfigure.web.WebProperties;
//import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
//import org.springframework.boot.web.error.ErrorAttributeOptions;
//import org.springframework.boot.web.reactive.error.ErrorAttributes;
//import org.springframework.context.ApplicationContext;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.codec.ServerCodecConfigurer;
//import org.springframework.stereotype.Component;
//import org.springframework.web.reactive.function.BodyInserters;
//import org.springframework.web.reactive.function.server.*;
//import reactor.core.publisher.Mono;
//
//
//@Component
//@Order(-2)
//public class GeneralErrorHandler extends AbstractErrorWebExceptionHandler {
//
//	/**
//	 * Create a new {@code AbstractErrorWebExceptionHandler}.
//	 *
//	 * @param errorAttributes    the error attributes
//	 * @param serverCodecConfigurer          the resources configuration properties
//	 * @param applicationContext the application context
//	 * @since 2.4.0
//	 */
//	public GeneralErrorHandler(ErrorAttributes errorAttributes,
//	                           ApplicationContext applicationContext,
//	                           @NotNull ServerCodecConfigurer serverCodecConfigurer) {
//		super(errorAttributes, new WebProperties.Resources(), applicationContext);
//		super.setMessageWriters(serverCodecConfigurer.getWriters());
//		super.setMessageReaders(serverCodecConfigurer.getReaders());
//	}
//
//	@Override
//	protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
//		return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
//	}
//
//	private @NotNull Mono<ServerResponse>
//	renderErrorResponse(ServerRequest serverRequest) {
//		var errorOptions = ErrorAttributeOptions.of(
//						ErrorAttributeOptions.Include.EXCEPTION,
//						ErrorAttributeOptions.Include.MESSAGE,
//						ErrorAttributeOptions.Include.BINDING_ERRORS);
//		var errorAttributes = getErrorAttributes(serverRequest, errorOptions);
//		errorAttributes.put("informal_message", "This is an intentional response. If you're seeing this, then " +
//						"your request caused some sort of error. The rest of this response should hopefully have enough " +
//						"information to help you discern the cause");
//		return ServerResponse.status(HttpStatus.BAD_REQUEST)
//						.contentType(MediaType.APPLICATION_JSON)
//						.body(BodyInserters.fromValue(errorAttributes));
//	}
//}