package com.niksum.java.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapEx {
	public static void main(String[] args) {
		Map<String, String> myMap = new HashMap<>();
		Map<String, String> myLinkedMap = new LinkedHashMap<>();
		Map<String, String> myConcurrentMap = new ConcurrentHashMap();
		int n = 16;
		
		System.out.println(n | n>>1);
		
		n |= n >>> 1;
		
	}
}
