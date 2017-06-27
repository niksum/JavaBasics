package com.niksum.learn.spring.basicTest.annotation.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("A")
public class A {
		
	private B b;
	
	@Autowired
	public void setB(B b){
		this.b = b;
	}
	
	static int counter = 1; 
	
	A(){
		System.out.println("Con of A");
		System.out.println("Counter value is "+ counter);
//		System.out.println(b.toString());
		counter++;
	}
	public void processA(){
		b.processB();
	}
	@Override
    public String toString() {
        return "A";
    }
}
