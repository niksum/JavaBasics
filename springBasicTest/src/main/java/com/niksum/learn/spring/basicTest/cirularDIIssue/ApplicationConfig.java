package com.niksum.learn.spring.basicTest.cirularDIIssue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.niksum.learn.spring.basicTest.cirularDIIssue.bean.ForkLeft;
import com.niksum.learn.spring.basicTest.cirularDIIssue.bean.ForkRight;
import com.niksum.learn.spring.basicTest.cirularDIIssue.bean.LeftHandFork;
import com.niksum.learn.spring.basicTest.cirularDIIssue.bean.RightHandFork;

public class ApplicationConfig {

	private static ApplicationContext factory;

	public static void main(String[] args) {
		factory = new ClassPathXmlApplicationContext("com/niksum/learn/spring/basicTest/cirularDIIssue/config.xml");
	// below circular DI created using Setter method will work as this way of DI is optional
		circularDepenInSetter();
		// below C DI created using constructor approach will not work as this is Mandatory approach
		circularDepenInCons();
	}
	public static void circularDepenInCons(){
		ForkLeft left = factory.getBean("left", ForkLeft.class);
		ForkRight right = factory.getBean("right", ForkRight.class);
		
		right.process();
	}
	
	public static void circularDepenInSetter(){
		LeftHandFork leftHandFork = factory.getBean("leftHandFork", LeftHandFork.class);
		RightHandFork rightHandFork = factory.getBean("rightHandFork", RightHandFork.class);
		
		rightHandFork.process();
	}
}