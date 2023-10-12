package com.example.employeerestapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.employeerestapi.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


@Repository
public class EmployeeDaoImplementation implements EmployeeDAO{

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDaoImplementation(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		
		// create query
		TypedQuery<Employee> thQuery = entityManager.createQuery("FROM Employee",Employee.class);
		
		// execute query and get result
		List<Employee> thList = thQuery.getResultList();
		
		// return result
		return thList;
	}

	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		Employee theEmployee = entityManager.merge(employee);
		
		return theEmployee;
	}

	@Override
	public void deletebyId(int id) {
		// TODO Auto-generated method stub
		
		// find the employee by using the id
		Employee thEmployee = entityManager.find(Employee.class, id);
		
		// remove the employee from table
		entityManager.remove(thEmployee);
	}

	@Override
	public Employee findbyId(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Employee.class, id);
	}

}
