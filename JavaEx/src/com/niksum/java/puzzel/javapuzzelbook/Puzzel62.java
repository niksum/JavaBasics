package com.niksum.java.puzzel.javapuzzelbook;

import java.util.IdentityHashMap;
import java.util.Map;

public class Puzzel62 {
	
	public Puzzel62(){
		
	}

	public static void main(String[] args) {
		Map<String, String> myMap = new IdentityHashMap<>();
		myMap.put("a", "abc");
		myMap.put(new String("a"), "dfd");
		myMap.put("a", "dfd");
	
		System.out.println(myMap.size());
	}
}
