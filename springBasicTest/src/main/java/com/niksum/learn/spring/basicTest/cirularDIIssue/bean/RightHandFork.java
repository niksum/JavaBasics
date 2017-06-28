package com.niksum.learn.spring.basicTest.cirularDIIssue.bean;

public class RightHandFork {
	private LeftHandFork leftHandFork;
	
	
	public void setLeftHandFork(LeftHandFork leftHandFork) {
		this.leftHandFork = leftHandFork;
	}


	public RightHandFork(){
		System.out.println("Con of RightHandFork");
	}
	
	public void process(){
		this.callingRightHandHelper();
		leftHandFork.callingLeftHandHelper();
	}
	
	public void callingRightHandHelper(){
		System.out.println("RightHandFork.callingRightHandHelper");
	}
	
	
}
