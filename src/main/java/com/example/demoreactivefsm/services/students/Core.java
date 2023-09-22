package com.example.demoreactivefsm.services.students;

import com.example.demoreactivefsm.data.entities.student.Student;
import com.example.demoreactivefsm.data.repo.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class Core {
	private final StudentRepository repository;
	public Mono<Student> save(Student student) {
		return repository.save(student);
	}
	public Flux<Student> findAll() {
		return repository.findAll();
	}

	public Mono<Student> findById(Integer id) {
		return repository.findById(id);
	}
}
