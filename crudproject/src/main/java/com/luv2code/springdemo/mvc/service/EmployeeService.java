package com.luv2code.springdemo.mvc.service;

import java.util.List;

import com.luv2code.springdemo.mvc.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	
	Employee findById (int id);
	
	Employee save (Employee e);
	
	void deleteById (int id);
}
