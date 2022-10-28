package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee update(Employee emp,long id);
	Employee getById(long id);
	void deleteById(long id);

}
