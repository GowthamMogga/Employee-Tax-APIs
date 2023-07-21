package com.employee.manager.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.manager.DTO.responseDto;
import com.employee.manager.entity.Employee;
import com.employee.manager.repository.employeeRepo;

@Service
public class employeeService {

	@Autowired
	employeeRepo repo;

	public Employee findEmployeeById(int id) {
		return this.repo.findById(id).get();
	}

	public Employee addEmployee(Employee e) {
		return this.repo.save(e);
	}
	
	public List<Employee> getAllEmployee(){
		return this.repo.findAll();
	}

	public responseDto getEmployeeTaxableAmount(int employeeId) {
		Employee e = findEmployeeById(employeeId);
		responseDto resp = new responseDto();
		final float loss_of_pay_per_day = e.getSalary() / 30;
		float taxAmount = 0;
		float cessAmount = 0;
		float yearlySalary = 0;
		float loss_of_pay = 0;
		LocalDate fiscalStart = null;
		LocalDate fiscalEnd = null;
		LocalDate currentdate = LocalDate.now();
		if (currentdate.getMonth().getValue() >= 4) {
			if (currentdate.getMonth().getValue() <= 12) {
				fiscalStart = LocalDate.of(currentdate.getYear(), 04, 01);
				fiscalEnd = LocalDate.of(currentdate.getYear() + 1, 03, 31);
			}
		} else if (currentdate.getMonth().getValue() <= 3) {
			fiscalStart = LocalDate.of(currentdate.getYear() - 1, 04, 01);
			fiscalEnd = LocalDate.of(currentdate.getYear(), 03, 31);
		}

		int compare = e.getJoiningDate().compareTo(fiscalStart);
		if (compare <= 0) {
			yearlySalary = e.getSalary() * 12;
		} else if (compare > 0) {
			if (e.getJoiningDate().compareTo(fiscalEnd) < 0) {
				Period period = Period.between(fiscalStart, e.getJoiningDate());
				loss_of_pay = e.getSalary() * period.getMonths();
				loss_of_pay += loss_of_pay_per_day * period.getDays();
				yearlySalary = e.getSalary() * 12;
				yearlySalary -= loss_of_pay;
			}
		}

		if (yearlySalary > 250000) {

			if (yearlySalary <= 500000) {
				float temp = yearlySalary - 250000;
				taxAmount = temp * (5f / 100);
			} else {

				taxAmount = (500000 - 250000) * (5f / 100);

			}
		}
		if (yearlySalary > 500000) {
			if (yearlySalary <= 1000000) {
				float temp = yearlySalary - 500000;
				taxAmount += temp * (10f / 100);
			} else {
				taxAmount += (1000000 - 500000) * (10f / 100);
			}
		}
		if (yearlySalary > 1000000) {
			float temp = yearlySalary - 1000000;
			taxAmount += temp * (20f / 100);
		}

		if (yearlySalary > 2500000) {
			float temp = yearlySalary - 2500000;
			cessAmount = temp * (2f / 100);
		}

		resp.setEmployeeId(e.getEmployeeId());
		resp.setFirstName(e.getFirstName());
		resp.setLastName(e.getLastName());
		resp.setTaxAmount(taxAmount);
		resp.setYearlySalary(yearlySalary);
		resp.setCessAmount(cessAmount);
		resp.setFiscalYear(fiscalStart.toString() + " to " + fiscalEnd.toString());

		return resp;
	}

}
