package com.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.ems.entity.Employee;
import com.ems.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public String getAllEmployees(Model model)
	{
		model.addAttribute("employees",employeeService.getAllEmployees());
		return "employees";
	}
	
	@GetMapping("/employees/new")
	public String createEmployeeForm(Model model)
	{
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		return "create_employee";
	}

	@PostMapping("/employees")
	public String addEmployee(@ModelAttribute("employee")Employee employee)
	{
		employeeService.addEmployee(employee);
		return "redirect:/employees";
	}
	
	@GetMapping("/employees/edit/{id}")
	public String updateEmployeeForm(@PathVariable long id,Model model)
	{  
		Employee employee=employeeService.getEmployeeById(id);
		model.addAttribute("employee",employee);
		return "update_employee";
	}
	
	
	  @PostMapping("/employees/{id}")
	  public String updateEmployee(@ModelAttribute("employee")Employee employee, @PathVariable long id,Model model)
	  { 
	     Employee updateEmployee=employeeService.getEmployeeById(id);
	     
	     updateEmployee.setName(employee.getName());
	     updateEmployee.setEmail(employee.getEmail());
	     updateEmployee.setDesignation(employee.getDesignation());
	  
	     employeeService.addEmployee(updateEmployee); 
	     return "redirect:/employees";
	  }
	 
	
	@GetMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable long id)
	{
		 employeeService.deleteEmployee(id);
		 return "redirect:/employees";
	}
}

