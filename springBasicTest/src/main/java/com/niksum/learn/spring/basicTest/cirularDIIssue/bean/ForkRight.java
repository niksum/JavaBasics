package com.niksum.learn.spring.basicTest.cirularDIIssue.bean;

public class ForkRight {
	private ForkLeft forkLeft;

	public ForkRight(ForkLeft left){
		this.forkLeft = left;
		System.out.println("Con of ForkRight");
	}
	
	public void process(){
		this.callingRight();
		forkLeft.callingLeft();
	}
	
	public void callingRight(){
		System.out.println("ForkRight.callingRight");
	}
	
	
}
