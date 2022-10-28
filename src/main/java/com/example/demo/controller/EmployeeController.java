package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
EmployeeService employeeService;

	
	
	


@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee ){
		return new ResponseEntity<Employee> (employeeService.saveEmployee(employee),
				HttpStatus.CREATED);
		
	}

@GetMapping
public List<Employee> getAllEmployees(){
	return employeeService.getAllEmployees();
}

@GetMapping("{id}")
public ResponseEntity<Employee> getById(@PathVariable("id") long id ){
	return new  ResponseEntity<Employee>(employeeService.getById(id),HttpStatus.OK);
	
}

@PutMapping("{id}")
public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,@RequestBody Employee emp){
	return new ResponseEntity<Employee>(employeeService.update(emp, id),HttpStatus.OK);
}

@DeleteMapping("{id}")
public ResponseEntity<Map<String,String>> delete(@PathVariable("id") long id){
	Map<String,String> res=new HashMap<>();
	res.put("status", "0");
	res.put("message", "resource deleted successfully");
	employeeService.deleteById(id);
	return new ResponseEntity<Map<String,String>>(res,HttpStatus.OK);
}
}
