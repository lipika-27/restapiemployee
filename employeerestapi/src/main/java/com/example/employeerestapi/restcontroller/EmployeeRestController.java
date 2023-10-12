package com.example.employeerestapi.restcontroller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeerestapi.dao.EmployeeDAO;
import com.example.employeerestapi.entity.Employee;
import com.example.employeerestapi.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
/*	private EmployeeDAO employeeDAO;

	public EmployeeRestController(EmployeeDAO employeeDAO) {
		super();
		this.employeeDAO = employeeDAO;
	}
	
	
	// create endpoint to get list of employee
	@GetMapping("/employee")
	public List<Employee> getAllEmployee(){
		return employeeDAO.findAll();
	}
	*/
	
	
	private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
	    super();
	    this.employeeService = employeeService;
    }
	
    
    // get the list of all employee
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		return employeeService.findAll();
	}
	
	
	// find an employee by using the id
	@GetMapping("/findemployee/{theid}")
	public Employee findempbyId(@PathVariable int theid)
	{
		Employee thEmployee = employeeService.getbyId(theid);
		
		if(thEmployee== null)
			throw new RuntimeException("emplioyee id not found  "+ theid);
		
		return thEmployee;
	}
	
	
	// delete an employee
	@DeleteMapping("/removeEmployee/{theid}")
	public void removeEmpbyId(@PathVariable int theid)
	{
		employeeService.deleteEmpById(theid);
	}
	
	
	
	// add an employee
	@PostMapping("/saveEmployee")
	public Employee savEmployee(@RequestBody Employee employee)
	{
		// if the user pass id in the json set id to 0 this is force to save a new item instead of update
		employee.setId(0);
		
		Employee thEmployee = employeeService.save(employee);
		
		return thEmployee;
	}
	
	// update an employee
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee employee)
	{
		Employee thEmployee = employeeService.save(employee);
		
		return thEmployee;
	}
	
	
	
	
	

}
