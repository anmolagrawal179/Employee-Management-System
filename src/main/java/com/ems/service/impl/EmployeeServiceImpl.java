package com.ems.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ems.entity.Employee;
import com.ems.repository.EmployeeRepository;
import com.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees() {
        
	   return employeeRepository.findAll(); 
	}

	@Override
	public Employee addEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}
	
	@Override
	public Employee getEmployeeById(long id) {
		
		return employeeRepository.findById(id).get();
	}

	@Override
	public void deleteEmployee(long id) {
	
		employeeRepository.deleteById(id);
	}

}
