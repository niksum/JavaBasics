package com.niksum.learn.spring.basicTest.cirularDIIssue.bean;

public class ForkLeft {
	private ForkRight forkRight;
	
	public ForkLeft(ForkRight right){
		this.forkRight = right;
		System.out.println("Con of ForkLeft");
	}
	
	public void callingLeft(){
		System.out.println("ForkLeft.callingLeft");
		forkRight.callingRight();
	}
	
}
