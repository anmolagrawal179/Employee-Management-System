package com.ems.service;

import java.util.List;

import com.ems.entity.Employee;

public interface EmployeeService {

	  List<Employee> getAllEmployees();
	  
	  Employee addEmployee(Employee employee);
	  
	  Employee getEmployeeById(Long id);
	  
	  void deleteEmployee(Long id);
	
	
}
