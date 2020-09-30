package com.springboot.jameslee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jameslee.entity.Employee;
import com.springboot.jameslee.service.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee")
	public List<Employee> findAllEmployee() {
		return employeeService.findAllEmployee();
	}

}
