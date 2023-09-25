package com.example.demoreactivefsm.customer;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Predicate;

@Service
public class CustomerHandler {

    public Mono<ServerResponse> loadCustomers(ServerRequest request) {
        return ServerResponse.ok().body(List.of(1, 2, 3), Integer.class);
    }
}
