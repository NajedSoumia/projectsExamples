package com.example.employeecruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.employeecruddemo.dao.EmployeeRepository;
import com.example.employeecruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	
	//inject employeeDAO constructor

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	

	//implement method
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}


	@Override
	public Employee findById(int id) {
		Optional<Employee> result = employeeRepository.findById(id);
		Employee theEmployee =null;
		if(result.isPresent()) {
			theEmployee = result.get();
		}else {
			throw new RuntimeException("Did not find employee id -" + id);
		}
		return theEmployee;
	}


	@Override
	public Employee save(Employee e) {
		Employee employee = employeeRepository.save(e);
		return employee;
	}


	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
		
	}

	

}
