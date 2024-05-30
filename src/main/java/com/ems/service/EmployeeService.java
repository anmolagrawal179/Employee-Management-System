package com.ems.service;

import java.util.List;
import com.ems.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	
	public Employee addEmployee(Employee employee);
	
	public Employee getEmployeeById(long id);
	
	public void deleteEmployee(long id);
	
}
