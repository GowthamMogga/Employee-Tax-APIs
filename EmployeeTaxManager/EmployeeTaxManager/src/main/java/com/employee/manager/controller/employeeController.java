package com.employee.manager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.manager.DTO.responseDto;
import com.employee.manager.entity.Employee;
import com.employee.manager.service.employeeService;

@RestController
@RequestMapping("api/employee")
public class employeeController {

	@Autowired
	employeeService service;

	@GetMapping("/handshake")
	public String handshake() {
		return "Hello";
	}

	@PostMapping("/addEmployee")
	public ResponseEntity<Map<String, String>> addEmployee(@RequestBody Employee e) {
		Map<String, String> status = new HashMap<>();
		try {
			Employee t = this.service.addEmployee(e);
			status.put("status", "Success");
			return new ResponseEntity<>(status, HttpStatus.ACCEPTED);
		} catch (Exception exp) {
			System.out.println(exp);
			return new ResponseEntity<>(status, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/allEmployees")
	public List<Employee> getAllEmployee() {
		return this.service.getAllEmployee();
	}

	@GetMapping("/taxDeduction")
	public ResponseEntity<responseDto> getTaxDeduction(@RequestParam(name = "empId") int empId) {
		try {
			responseDto res = this.service.getEmployeeTaxableAmount(empId);
			return new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
}
