package com.niksum.java.collections;

import java.util.HashMap;
import java.util.Map;

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
	}
}
