package com.employee.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.manager.entity.Employee;

public interface employeeRepo extends JpaRepository<Employee, Integer>{

}
