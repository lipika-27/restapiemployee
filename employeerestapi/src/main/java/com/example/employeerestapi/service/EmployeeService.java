package com.example.employeerestapi.service;

import java.util.List;

import com.example.employeerestapi.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	
	Employee save(Employee employee);
	
	Employee getbyId(int id);
	
	void deleteEmpById(int id);
}
