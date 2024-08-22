package com.luv2code.springdemo.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.mvc.entity.Employee;
import com.luv2code.springdemo.mvc.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		//get the employees from db
		List<Employee> theEmployees = employeeService.findAll();
		//add to the spring model
		theModel.addAttribute("employees", theEmployees);
		return "employees/list-employees";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd (Model theModel) {
		Employee employee = new Employee();
		theModel.addAttribute("employee", employee);
		return "employees/employee-form";
		
	}
	
	@PostMapping("/save")
	public String saveEmployee (@ModelAttribute("employee")Employee theEmployee) {
		//save the employee
		employeeService.save(theEmployee);
		//use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int id, Model theModel) {
		//get the employee from the service
		Employee theEmployee = employeeService.findById(id);
		//set employee in the model to prepopulate the form
		theModel.addAttribute("employee", theEmployee);
		//send over to our form
		return "employees/employee-form";
		
	}
	
	@GetMapping("/delete")
	public String deleteEmployee (@RequestParam("employeeId") int id) {
		//delete the employee
		employeeService.deleteById(id);
		//redirect to 
		return "redirect:/employees/list";
	}
	

}
