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
	}
}
