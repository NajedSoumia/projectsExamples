package com.luv2code.springdemo.mvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springdemo.mvc.entity.Employee;
import com.luv2code.springdemo.mvc.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	//define field for employee repository
	private EmployeeRepository employeeRepository;
	
	//inject employee repository using constructor injection
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	

	//implement methods
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAllByOrderByLastNameAsc();
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
		Employee theEmployee = employeeRepository.save(e);
		return theEmployee;
	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
		
	}

}
