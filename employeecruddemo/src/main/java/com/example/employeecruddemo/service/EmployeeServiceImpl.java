package com.example.employeecruddemo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.employeecruddemo.dao.EmployeeDAO;
import com.example.employeecruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDAO employeeDAO;
	
	//inject employeeDAO constructor
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		super();
		this.employeeDAO = employeeDAO;
	}
	

	//implement method
	@Override
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}


	@Override
	public Employee findById(int id) {
		Employee employee = employeeDAO.findById(id);
		return employee;
	}


	@Override
	@Transactional
	public Employee save(Employee e) {
		Employee employee = employeeDAO.save(e);
		return employee;
	}


	@Override
	@Transactional
	public void deleteById(int id) {
		employeeDAO.deleteById(id);
		
	}

	

}
