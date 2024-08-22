package com.example.employeecruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeecruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	//that's it no need to write any code

}
