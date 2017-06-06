package com.nikhil.test.annotation;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE_DETAILS")
public class EmployeeDetails implements Serializable{
	
	private static final long serialVersionUID = 3637829924329811601L;
	
	@Id
	@Column(name="EMP_DETAIL_ID")
	private int empDetailsId;
	
	@Column(name="EMP_DEPART", length=50, nullable=false)
	private String empDepartment;
	
	@Column(name="EMP_DESIG", length=20, nullable=true)
	private String empDesignation;
	
	public EmployeeDetails(){
		super();
	}

	public EmployeeDetails(String depar, String desi){
		setEmpDepartment(depar);
		setEmpDesignation(desi);
	}
	
	public int getEmpDetailsId() {
		return empDetailsId;
	}

	public void setEmpDetailsId(int empDetailsId) {
		this.empDetailsId = empDetailsId;
	}

	public String getEmpDepartment() {
		return empDepartment;
	}

	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	/**
	 * 
	 */


	@Override
	public String toString() {
		return "EmployeeDetails [ \n \t \t empDepartment=" + empDepartment + ", \n \t \t empDesignation=" + empDesignation + "]";
	}
}
