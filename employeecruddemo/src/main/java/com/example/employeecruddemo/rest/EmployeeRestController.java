package com.example.employeecruddemo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.employeecruddemo.entity.Employee;
import com.example.employeecruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;
	//quick and dirty : inject employee dap

	public EmployeeRestController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	
	//expose "/employess" and return a list of employess
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
		
	}
	
	//expose "/employees/{employeeId}
	@GetMapping("/employees/{employeeId}")
	public Employee getById(@PathVariable int employeeId) {
		 Employee theEmployee = employeeService.findById(employeeId);
		 if (theEmployee == null) {
			 throw new RuntimeException("Employee id not found -"+employeeId);
		 }
		return theEmployee;
		
	}
	
	//expose "/employess
	@PostMapping("/employees")
	public Employee addEmployee (@RequestBody Employee employee) {
		//just in case they pass an id in JSON .. set id to 0
		//this is to force a save of a new item ... instead of update
		employee.setId(0);
		//
		Employee dbEmployee = employeeService.save(employee);
		return dbEmployee;
		
	}
	
	//expose "/employees
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		Employee dbEmployee = employeeService.save(employee);
		return dbEmployee;
	}

	//expose "/employees/{employeeId}
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee tempEmployee = employeeService.findById(employeeId);
		if (tempEmployee == null) {
			throw new RuntimeException("Employee id not found -" + employeeId);
		}
		employeeService.deleteById(employeeId);
		return "Deleted employee id - "+ employeeId;
	}




}
