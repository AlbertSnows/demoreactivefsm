package com.example.demo.webflux.app.openapi.student;

//import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/api/v1/students")
//@RequiredArgsConstructor
public class StudentController {
	private final StudentService service;
	@Autowired
	public StudentController(StudentService service) {
		this.service = service;
	}

	@PostMapping
	Mono<Student> save (@RequestBody Student student) {
		return service.save(student);
	}

	@GetMapping
	Flux<Student> findAll() {
		return service.findAll().delayElements(Duration.ofSeconds(1));
	}

	@GetMapping("/{id}")
	public Mono<Student> findById(@PathVariable("id") Integer id) {
		return service.findById(id);
	}
}
