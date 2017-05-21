package com.nikhil.test.annotation;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_DATA")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="EMP_TYPE", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="EMPLOYEE")
@SecondaryTable(name="EMP_PERSONAL_INFO",pkJoinColumns=@PrimaryKeyJoinColumn(name="EMP_ID"))
public class Employee {


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empDetail=" + empDetail + ", empDOJ=" + empDOJ
				+ ", empGender=" + empGender + ", empHeight=" + empHeight + ", skillSet=" + skillSet + ", proj=" + proj
				+ "]";
	}

	@Id
	@Column(name = "EMP_ID")	
	private int empId;
	
	@Embedded
	private EmpName empName;
		
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="EMP_DETAIL_ID")
	private EmployeeDetails empDetail;
	
	// Given below field has been added for SecondaryTables 
	
	@Column(name="EMP_DOJ", table="EMP_PERSONAL_INFO")
	private Date empDOJ;
	@Column(name="EMP_GENDER", table="EMP_PERSONAL_INFO")
	private String empGender;
	@Column(name="EMP_HEIGHT", table="EMP_PERSONAL_INFO")
	private int empHeight;
	
	@OneToMany(fetch=FetchType.LAZY)
	private Set<EmpSkillSet> skillSet = new HashSet<EmpSkillSet>();
	
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(
			name="PROJECT_EMPLOYEE_MAPPING",
			joinColumns={
					@JoinColumn(
							name="EMP_ID", 
							nullable=false, 
							updatable=false)
					},
			inverseJoinColumns={
					@JoinColumn(
							name="PROJ_ID", 
							nullable=false, 
							updatable=false)
					}
	)
	private Set<Project> proj= new HashSet<Project>();
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public EmpName getEmpName() {
		return empName;
	}

	public void setEmpName(EmpName empName) {
		this.empName = empName;
	}


	public EmployeeDetails getEmpDetail() {
		return empDetail;
	}

	public void setEmpDetail(EmployeeDetails empDetail) {
		this.empDetail = empDetail;
	}

	public Date getEmpDOJ() {
		return empDOJ;
	}

	public void setEmpDOJ(Date empDOJ) {
		this.empDOJ = empDOJ;
	}

	public String getEmpGender() {
		return empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}

	public int getEmpHeight() {
		return empHeight;
	}

	public void setEmpHeight(int empHeight) {
		this.empHeight = empHeight;
	}

	public Set<EmpSkillSet> getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(Set<EmpSkillSet> skillSet) {
		this.skillSet = skillSet;
	}

	public Set<Project> getProj() {
		return proj;
	}

	public void setProj(Set<Project> proj) {
		this.proj = proj;
	}

}
