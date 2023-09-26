package com.example.demo.webflux.app.openapi.employee;

import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jdk.jfr.Description;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "my example employee controller")
public class EmployeeController {

	private final List<Employee> employees = createList();

	@GetMapping(
					value = "/employees",
					produces = "application/json")
	@Description("Get list of employees")
	@Operation(summary = "Example endpoint summary",
	responses = {
					@ApiResponse(
									description = "success",
									responseCode = "200"),
					@ApiResponse(description = "Unauth",
									responseCode = "403")})
	public List<Employee> firstPage() {
		return employees;
	}

	@PostMapping
	public Employee create(@RequestBody Employee user) {
		employees.add(user);
		System.out.println(employees);
		return user;
	}

	@Hidden
	private static List<Employee> createList() {
		List<Employee> tempEmployees = new ArrayList<>();
		Employee emp1 = new Employee();
		emp1.setName("emp1");
		emp1.setDesignation("manager");
		emp1.setEmpId("1");
		emp1.setSalary(3000);

		Employee emp2 = new Employee();
		emp2.setName("emp2");
		emp2.setDesignation("developer");
		emp2.setEmpId("2");
		emp2.setSalary(3000);
		tempEmployees.add(emp1);
		tempEmployees.add(emp2);
		return tempEmployees;
	}
}
