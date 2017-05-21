package com.nikhil.test.annotation;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="CONTRACTOR")
public class Contractor extends Employee implements Serializable{

	private static final long serialVersionUID = -4288516856162458738L;
	
	public Contractor(){
		super();
	}

	@Column(name="EMP_PPH")
	private float payPerHour;
}
