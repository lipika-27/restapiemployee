package com.example.employeerestapi.dao;

import java.util.List;

import com.example.employeerestapi.entity.Employee;

public interface EmployeeDAO {

	
	// get list of employees
	List<Employee> findAll();
	
	
	// save a new employee
	Employee save(Employee employee);
	
	
	// delete an employee by the id
	void deletebyId(int id);
	
	
	// find the employee by id
	Employee findbyId(int id);
}
