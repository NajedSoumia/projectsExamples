package com.luv2code.springdemo.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springdemo.mvc.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	//no need to write any code
	
	//add a method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();

	
}
