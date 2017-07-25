package com.niksum.java.ExceptionAndErrors;

import java.util.ArrayList;
import java.util.List;

class BadClass{
	private static String badCode = getBad();
	public BadClass(String bad){
		badCode = bad;
	}
	private static String getBad(){
		throw new RuntimeException("BadClass throwing getBad exception");
	}
}


public class NoClassDefFoundErrorExample {
	static class Inner{
		static{
			Integer.parseInt(null);
		}
	}
	
	public static void main(String[] args) {
		
		try{
			new Inner();
		} catch(Throwable th){
			th.printStackTrace();
		}
		new Inner();
		
		List<BadClass> myList = new ArrayList<>(1);
		try{
		myList.add(new BadClass("bad"));
		} catch(Throwable t){
			t.printStackTrace();
		}
		
		myList.add(new BadClass("badass"));
	}
}
