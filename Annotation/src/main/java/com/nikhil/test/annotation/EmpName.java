package com.nikhil.test.annotation;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmpName {
	@Column(name = "EMP_FIRST_NAME")
	private String firstName;
	@Column(name = "EMP_LAST_NAME")
	private String lastName;
	
	public EmpName(){
		super();
	}
	
	public EmpName(String name, String lastNm){
		setFirstName(name);
		setLastName(lastNm);
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

	@Override
	public String toString() {
		return "EmpName [\n \t \t firstName=" + firstName + ", \n \t \t lastName=" + lastName + "]";
	}

}
