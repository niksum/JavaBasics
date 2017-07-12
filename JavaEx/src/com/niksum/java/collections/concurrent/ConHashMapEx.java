package com.niksum.java.collections.concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class ConHashMapEx {
	public static void main(String[] args) {
		ConcurrentHashMap<String, Integer> myMap = new ConcurrentHashMap<String, Integer>(24,.50F,10);
		for (int i = 0; i < 30; i++) {
			myMap.put(i+"", i);
		}
		
		Stream.of(myMap)
		.forEach(System.out::println);
		
		ConcurrentHashMap<String, Integer> myMap1 = new ConcurrentHashMap<String, Integer>(24,.50F,10);
		myMap1.put(1+"", 1);
	}
}
