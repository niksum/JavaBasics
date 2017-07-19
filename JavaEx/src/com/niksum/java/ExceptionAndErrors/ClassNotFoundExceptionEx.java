package com.niksum.java.ExceptionAndErrors;

public class ClassNotFoundExceptionEx {
	public static void main(String[] args) {
		System.out.println("Class loader for this class is " + ClassNotFoundExceptionEx.class.getClassLoader());
		// Now if i wll try to load is using it's parent it will throw exception
		
		try {
			Class.forName("com.niksum.java.ClassNotFoundExceptionEx", 
					true, 
					ClassNotFoundExceptionEx.class.getClassLoader().getParent());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
