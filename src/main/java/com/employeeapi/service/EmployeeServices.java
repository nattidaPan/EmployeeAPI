package com.employeeapi.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employeeapi.model.Employee;
import com.employeeapi.repository.EmployeeRepository;

@Service
public class EmployeeServices  implements Serializable {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	private static final long serialVersionUID = 651276559861471826L;
	
	public List<Employee> retrieveAllEmployee() {
		return employeeRepository.findAll();
	}

	public Optional<Employee> retrieveEmployee(long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		return employee;
	}
	
	public void deleteEmployee(long id) {
		employeeRepository.deleteById(id);
	}
	
	public void createEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public void updateEmployee(Employee employee,long id) {
		employee.setId(id);
		employeeRepository.save(employee);
	}
	
}
