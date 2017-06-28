package com.niksum.learn.spring.basicTest.cirularDIIssue.bean;

public class LeftHandFork {
	private RightHandFork rightHandFork;
	
	
	public void setRightHandFork(RightHandFork rightHandFork) {
		this.rightHandFork = rightHandFork;
	}


	public LeftHandFork(){
		System.out.println("Con of LeftHandFork");
	}
	
	public void callingLeftHandHelper(){
		System.out.println("LeftHandFork.callingLeftHandHelper");
		rightHandFork.callingRightHandHelper();
	}
	
}
