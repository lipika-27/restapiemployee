package com.example.employeerestapi.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.employeerestapi.dao.EmployeeDAO;
import com.example.employeerestapi.entity.Employee;

@Service
public class EmplyoeeServiceImplement implements EmployeeService {

	private EmployeeDAO employeeDAO;
	
	
	public EmplyoeeServiceImplement(EmployeeDAO employeeDAO) {
		super();
		this.employeeDAO = employeeDAO;
	}


	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDAO.findAll();
	}


	@Override
	@Transactional
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDAO.save(employee);
	}


	@Override
	public Employee getbyId(int id) {
		// TODO Auto-generated method stub
		return employeeDAO.findbyId(id);
	}


	@Override
	@Transactional
	public void deleteEmpById(int id) {
		// TODO Auto-generated method stub
		employeeDAO.deletebyId(id);
	}

}
