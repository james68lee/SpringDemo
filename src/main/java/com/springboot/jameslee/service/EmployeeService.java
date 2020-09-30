package com.springboot.jameslee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jameslee.entity.Employee;
import com.springboot.jameslee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> findAllEmployee() {
		return employeeRepository.findAll();
	}
	
}
