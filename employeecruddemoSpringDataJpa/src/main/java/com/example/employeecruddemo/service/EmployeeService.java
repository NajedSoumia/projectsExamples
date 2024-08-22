package com.example.employeecruddemo.service;

import java.util.List;

import com.example.employeecruddemo.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	
	Employee findById(int id);
	

	Employee save (Employee e);
	
	void deleteById (int id);
}
