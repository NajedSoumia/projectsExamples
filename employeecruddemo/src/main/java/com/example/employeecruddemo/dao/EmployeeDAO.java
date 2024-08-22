package com.example.employeecruddemo.dao;

import java.util.List;

import com.example.employeecruddemo.entity.Employee;

public interface EmployeeDAO {
	
	List<Employee> findAll();
	
	Employee findById(int id);
	
	Employee save (Employee e);
	
	void deleteById (int id);

}
