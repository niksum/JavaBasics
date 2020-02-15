package com.niksum.java;

import java.util.HashMap;
import java.util.Map;

class ABC{
	@Override
	public boolean equals(Object obj) {
		
		return this.name.equals(((ABC)obj).name);
	}
	String name;
	ABC(String nm){
		name = nm;
	}
	@Override
	public int hashCode() {
		if(name.equals("ABC") || name.equals("AAC") || name.equals("CCC"))
			return 5;
		else
			return name.hashCode();
	}	
	
}

public class Test1 {
	static void update(int num){num=11;}
	static void update(int [] nums){nums[0]=11;}
	
	public static void main(String[] args) {
//		int num=0; 
//		update(num);
//		int []nums = {1,3,5,7};
//		update(nums);
//		System.out.println(num);
//		for (int i : nums) {
//			System.out.println(i + ", ");
//		}
		
		
		
		Map<ABC, Integer> myMap = new HashMap<ABC, Integer>();
		myMap.put(new ABC("ABC"), 2);
		myMap.put(new ABC("AAC"), 5);
		myMap.put(new ABC("AAC"), 25);
		myMap.put(new ABC("CCC"), 25);
		myMap.put(new ABC("dddC"), 67);
		myMap.put(new ABC("ABCere"), 211);
		
		System.out.println(myMap);
	}
}
