package com.example.demoreactivefsm.services.greetings;

import com.example.demoreactivefsm.data.entities.greeting.Greeting;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class Core {

	public Mono<ServerResponse> hello(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
						.body(BodyInserters.fromValue(new Greeting("Hello, Spring!")));
	}
}