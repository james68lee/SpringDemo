package com.springboot.jameslee.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.springboot.jameslee.entity.Employee;

class EmployeeControllerTest {
	@InjectMocks
	EmployeeController employeeController;
	@Mock
	Employee employee;
	@Test
	void testFindAllEmployee() {
		
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
//        when(employeeDAO.addEmployee(any(Employee.class))).thenReturn(true);
        
        Employee employee = new Employee("Lokesh", "Gupta", "howtodoinjava@gmail.com");
//        ResponseEntity<Object> responseEntity = employeeController.addEmployee(employee);
         
        
//        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
//        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
	}

}
