package com.example.demoreactivefsm.data.repo;

import com.example.demoreactivefsm.data.entities.student.Student;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface StudentRepository extends ReactiveCrudRepository<Student, Integer> {
	Flux<Student> findAllByFirstnameIgnoreCase(String firstname);
}
