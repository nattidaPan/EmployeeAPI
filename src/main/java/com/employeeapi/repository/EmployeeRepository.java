package com.employeeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeapi.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
