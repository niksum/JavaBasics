package com.niksum.java.basic;
class A{
	public static void method(){
		System.out.println("A.method");
	}
}

class B extends A{
	public static void method(){
		System.out.println("B.method");
	}
	
	// you can't override a static method with a instance method in java. it will give compile issue
//	public void method(){
//		System.out.println("B.instance method ");
//	}
	
	public static void method2(){
		System.out.println("B.method2");
	}
	
	// given below will not work.. in overloading it does not look at the access type
//	
//	public void method2(){
//		System.out.println("b.method2 instance");
//	}
}
public class StaticMethodOverrideEx {

}
