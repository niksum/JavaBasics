package com.niksum.java.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapLoadFactor {
	public static void main(String[] args) {
		Map<String, Integer> myMap = new HashMap<>();
		myMap.put("RAMESH", 1);
		myMap.put("ARMESH", 1);
		myMap.put("MRAESH", 1);
		myMap.put("MESRAH", 1);
		
		int ab = 12;
		int a = ab >> 1;
		System.out.println(a);
		
		Set<String> mySet = new HashSet<>();
		mySet.add("ldfd");
		mySet.add("ldfsd");
		mySet.add("ldfssd");
		mySet.add("ldssfd");
		
		mySet.stream().forEach(System.out::println);
		MapLoadFactor my = new MapLoadFactor();
		MapLoadFactor myd = new MapLoadFactor("dfd");
	}
	public MapLoadFactor(){
		System.out.println("in const");
	}
	
	public void MapLoadFactor(){
	  System.out.println("In void const");
	}
	
	public MapLoadFactor(String ad){
		System.out.println("in const " + ad);
	}
	
	public void MapLoadFactor(String ad){
		System.out.println("in void const " + ad);
		
	}
}
