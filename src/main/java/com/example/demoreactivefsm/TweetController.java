//package com.example.demoreactivefsm;
//
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import reactor.core.publisher.Mono;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * Created by rajeevkumarsingh on 08/09/17.
// */
//@RestController
//public class TweetController {
//	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "get Tweet By Id"),
//					@ApiResponse(responseCode = "404", description = "tweet not found") })
//	@GetMapping("/tweets/{id}")
//	public Mono<String> getTweetById(@PathVariable(value = "id") String tweetId) {
//		return Mono.just("bleap");
//	}
//}