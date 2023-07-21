package com.employee.manager.DTO;

public class responseDto {
	int employeeId;
	String firstName;
	String lastName;
	float yearlySalary;
	float taxAmount;
	float cessAmount;
	String fiscalYear;
	
	public responseDto() {
		// TODO Auto-generated constructor stub
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public float getYearlySalary() {
		return yearlySalary;
	}

	public void setYearlySalary(float yearlySalary) {
		this.yearlySalary = yearlySalary;
	}

	public float getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(float taxAmount) {
		this.taxAmount = taxAmount;
	}

	public float getCessAmount() {
		return cessAmount;
	}

	public void setCessAmount(float cessAmount) {
		this.cessAmount = cessAmount;
	}

	public String getFiscalYear() {
		return fiscalYear;
	}

	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}

	@Override
	public String toString() {
		return "responseDto [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", yearlySalary=" + yearlySalary + ", taxAmount=" + taxAmount + ", cessAmount=" + cessAmount
				+ ", fiscalYear=" + fiscalYear + "]";
	}
	
	
}
