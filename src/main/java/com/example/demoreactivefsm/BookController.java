package com.example.demoreactivefsm;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;

/**
 * REST controller for managing {@link com.example.springreactiveopenapicodegen.dto.BookDTO}.
 */
@Validated
@Tag(name = "Book", description = "Book controller")
@RestController
@RequestMapping("/api/v1")
public class BookController implements com.example.springreactiveopenapicodegen.api.v1.BookApi
{

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Mono<ResponseEntity<com.example.springreactiveopenapicodegen.dto.SuccessResponseDTO>> _createBook(
					@Parameter(name = "BookDTO", description = "", required = true, schema = @Schema(description = ""))
					@Valid @RequestBody @NotNull Mono<com.example.springreactiveopenapicodegen.dto.BookDTO> bookDTO,
					@Parameter(hidden = true) final ServerWebExchange exchange) {
		return bookDTO
						.map(b -> ResponseEntity.created(URI.create("/api/v1/book/" + b.getId()))
										.body(new com.example.springreactiveopenapicodegen.dto.SuccessResponseDTO(b, "book created Successfully")));
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Mono<ResponseEntity<com.example.springreactiveopenapicodegen.dto.SuccessResponseDTO>> _deleteBook(
					@Parameter(name = "id", description = "", required = true, schema = @Schema(description = "")) @PathVariable("id") String id,
					@Parameter(hidden = true) final ServerWebExchange exchange
	) {
		return Mono.just(ResponseEntity
						.ok()
						.body(new com.example.springreactiveopenapicodegen.dto.SuccessResponseDTO(null, "Book deleted Successfully")));
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Mono<ResponseEntity<com.example.springreactiveopenapicodegen.dto.SuccessResponseDTO>> _getAllBook(
					@Parameter(hidden = true) final ServerWebExchange exchange
	) {
		return Mono.just(ResponseEntity
						.ok()
						.body(new com.example.springreactiveopenapicodegen.dto.SuccessResponseDTO(Collections.emptyList(), "result found")));
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Mono<ResponseEntity<com.example.springreactiveopenapicodegen.dto.SuccessResponseDTO>> _getOneBook(
					@Parameter(name = "id", description = "", required = true, schema = @Schema(description = "")) @PathVariable("id") String id,
					@Parameter(hidden = true) final ServerWebExchange exchange
	) {
		return Mono.just(ResponseEntity
						.ok()
						.body(new com.example.springreactiveopenapicodegen.dto.SuccessResponseDTO(com.example.springreactiveopenapicodegen.dto.BookDTO.builder().id(id).build(), "result found")));
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Mono<ResponseEntity<com.example.springreactiveopenapicodegen.dto.SuccessResponseDTO>> _updateBook(
					@Parameter(name = "id", description = "", required = true, schema = @Schema(description = "")) @PathVariable("id") String id,
					@Parameter(name = "BookDTO", description = "", required = true, schema = @Schema(description = ""))
					@Valid @RequestBody Mono<com.example.springreactiveopenapicodegen.dto.BookDTO> bookDTO,
					@Parameter(hidden = true) final ServerWebExchange exchange
	) {
		return updateBook(id, bookDTO, exchange);
	}

}