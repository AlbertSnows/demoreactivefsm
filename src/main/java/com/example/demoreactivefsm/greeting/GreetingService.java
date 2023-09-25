package com.example.demoreactivefsm.greeting;

import com.example.demoreactivefsm.greeting.Greeting;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Service
public class GreetingService {

	public Mono<ServerResponse> hello(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
						.body(BodyInserters.fromValue(new Greeting("Hello, Spring!")));
	}
}