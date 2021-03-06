package com.employeeapi.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.employeeapi.service.EmployeeServices;
import com.employeeapi.model.Employee;
import com.employeeapi.model.Employees;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

	@Autowired
	private EmployeeServices employeeServices;

	@GetMapping("/getEmployeesList")
	public Employees getEmployeesList() {
		Employees response = new Employees();
		List<Employee> list = new ArrayList<>();
		list = employeeServices.retrieveAllEmployee();
		response.setEmployeeList(list);
		return response;
	}

	@GetMapping("/getEmployeeById/{id}")
	public Employee getEmployeeById(@PathVariable long id) {
		Optional<Employee>  employee = employeeServices.retrieveEmployee(id);
		return employee.get();
	}

	@PostMapping("/deleteEmployee/{id}")
	public void deleteEmployee(@PathVariable long id) {
		employeeServices.deleteEmployee(id);
	}

	@PostMapping("/createEmployee")
	public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
		employeeServices.createEmployee(employee);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PostMapping("/updateEmployee/{id}")
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee, @PathVariable long id) {
		Optional<Employee> updateEmployee = employeeServices.retrieveEmployee(id);

		if (!updateEmployee.isPresent())
			return ResponseEntity.notFound().build();

		employeeServices.updateEmployee(employee, id);

		return ResponseEntity.noContent().build();
	}

}
