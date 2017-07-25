package com.niksum.java.puzzel;
class A{
	public String variable = "wow";
	

}
class B extends A{
//	private String variable = "where";
	String variable = "where";

}
public class OverloadVariableEx {
	public static void main(String[] args) {
		 System.out.println(new B().variable);
		 A a = new B();
		 System.out.println(a.variable);
		 
		 // overriding works only for methods and not for variables
	}
}
