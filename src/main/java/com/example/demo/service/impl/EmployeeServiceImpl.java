package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeRepository employeeRepository;

	

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}
	
	

	@Override
	public Employee update(Employee ef,long id) {
		// TODO Auto-generated method stub
	Employee emp=	employeeRepository.findById(id).orElseThrow(()->
	new ResourceNotFoundException("Employee","id",id));
	emp.setEmail(ef.getEmail());
	emp.setFirst_name(ef.getFirst_name());
	emp.setLast_name(ef.getLast_name());
	employeeRepository.save(emp);
	
	return emp;
	}

	@Override
	public Employee getById(long id) {
		// TODO Auto-generated method stub
		Optional<Employee> e=	employeeRepository.findById(id);
		if(e.isPresent()) {
			return e.get();
			
		}else {
			throw new ResourceNotFoundException("Employee","Id",id);
		}
		
		
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
		employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","id",id));
		employeeRepository.deleteById(id);
		
	}

}
