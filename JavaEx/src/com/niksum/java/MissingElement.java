package com.niksum.java;

import java.util.Arrays;
import java.util.List;

class Parent{
	public void method() throws RuntimeException{
		System.out.println("abc");
	}
}

class Child extends Parent{
	@Override
	public void method() throws RuntimeException{
		System.out.println("ac");
	}
	
}
public class MissingElement {
	public static void main(String[] args) {
		Integer[] arr = {3,5,6,8,9,11,13,16};
		List<Integer> myList = Arrays.asList(arr);
		int first  = myList.get(0);
		int last = myList.get(myList.size()-1);
		
		for(int i = first+1; i<last; i++){
			if(!myList.contains(i))
				System.out.println("No is missing in list " + i);
		}
		
		
	}
}
