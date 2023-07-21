package com.employee.manager;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.employee.manager.service.employeeService;

@SpringBootApplication
public class EmployeeTaxManagerApplication{

	@Autowired
	employeeService service;
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeTaxManagerApplication.class, args);
	}

	

	
	

}
