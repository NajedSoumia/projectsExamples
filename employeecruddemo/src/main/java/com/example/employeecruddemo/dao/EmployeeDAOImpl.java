package com.example.employeecruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.employeecruddemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
	//define field for entity manager
	private EntityManager entityManager;
	
	//inject entity manager using constructor injection
	@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	//implement methods
	//Read all
	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
		List<Employee> EmployeeList = theQuery.getResultList();
		return EmployeeList;
	}

	//Read by id
	@Override
	public Employee findById(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		return employee;
	}

	//Add or Update
	@Override
	public Employee save(Employee e) {
		Employee dbEmployee = entityManager.merge(e);
		return dbEmployee;
	}

	//delete
	@Override
	public void deleteById(int id) {
	Employee theEmployee = entityManager.find(Employee.class, id);
	entityManager.remove(theEmployee);
	}


	


}
