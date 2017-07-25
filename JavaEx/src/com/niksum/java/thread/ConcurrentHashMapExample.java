package com.niksum.java.thread;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
	public static void main(String[] args) {
		ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
		map.put(12, "absac");
		map.put(112, "ngsabcadf");
		map.put(122, "agsfgbdc");
		map.put(132, "aerebc");
		map.put(142, "aberec");
		map.put(412, "fabc");
		map.put(412, "adfabc");
		
		map.forEach((k, v) -> System.out.println(k + ", " +v));
		map.forEach((key, value) -> value = value.toUpperCase());
		 System.out.println("\n After done \n");
		 map.forEach((k, v) -> System.out.println(k + ", " +v));
	}
}
