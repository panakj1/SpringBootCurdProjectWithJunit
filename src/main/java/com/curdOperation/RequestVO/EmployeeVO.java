package com.curdOperation.RequestVO;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeVO {

	
	private Long empId;
	@NotNull(message="Name should not be blank")
	private String empName;
	@NotNull(message="Department should not be blank")
	private String department;
	@NotNull(message="Age should not be blank")
	private int age;
	@NotNull(message="Salary should not be blank")
	private double salary;
	
	private CompanyVO comp;

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public CompanyVO getComp() {
		return comp;
	}

	public void setComp(CompanyVO comp) {
		this.comp = comp;
	}

	
}
