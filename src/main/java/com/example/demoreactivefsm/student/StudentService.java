package com.example.demoreactivefsm.student;

//import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
//@RequiredArgsConstructor
public class StudentService {
	private StudentRepository repository;

	@Autowired
	StudentService(StudentRepository repository) {
		this.repository = repository;
	}
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
