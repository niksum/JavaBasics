package com.niksum.learn.spring.basicTest.annotation.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("B")
public class B {
	static int counter = 1; 
	B(){
		System.out.println("Con of B");
		System.out.println("Counter value is "+ counter);
		counter++;
	}
	public void processB(){
		System.out.println("Processing B ");
	}
	
	@Override
    public String toString() {
        return "B";
    }
}
