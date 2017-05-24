package com.niksum.java.feature8;

@FunctionalInterface
// this interface will have only one method. 
// It can have implicit member of Object class.
// we can also have static method in functional interface
// If we have default methods that will also work.
interface MyFunIn {
	public void funMethod();
	public boolean equals(Object ob);
	default String returnSomething(){
		return "kaya baat";
	}
	
	static void someThing(){
		System.out.println("Doing static things");
	}
}
public class FunctionalInterfaceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
