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
	
	@GetMapping({"/","/employee-list"})
	public String getAllEmployees(Model model) {
		
		model.addAttribute("employees",employeeService.getAllEmployees());
		
		return "employee-list";
	}
	
	@GetMapping("/add-employee")
	public String addEmployeeForm(Model model) {
		
		Employee employee=new Employee();
		
		model.addAttribute("employee", employee);
		
		return "add-employee";
	}
	
	@PostMapping("/add-employee")
	public String addEmployee(@ModelAttribute Employee employee) {
		
		employeeService.addEmployee(employee);
		
		return "redirect:/employee-list";
	}
	
	@GetMapping("/update-employee/{id}")
	public String updateEmployeeForm(@PathVariable Long id,Model model) {
		
		Employee employee=employeeService.getEmployeeById(id);
		
		model.addAttribute("employee", employee);
		
		return "update-employee";
	}
	
	@PostMapping("/update-employee/{id}")
	public String updateEmployeeForm(@PathVariable Long id, @ModelAttribute Employee employee) {
		
		Employee savedEmployee= employeeService.getEmployeeById(id);
		
		savedEmployee.setName(employee.getName());
		savedEmployee.setEmail(employee.getEmail());
		savedEmployee.setDesignation(employee.getDesignation());
		
		employeeService.addEmployee(savedEmployee);
		
		return "redirect:/employee-list";
		
	}
	
	@GetMapping("/delete-employee/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		
		employeeService.deleteEmployee(id);
		
		return "redirect:/employee-list";
	}
}
