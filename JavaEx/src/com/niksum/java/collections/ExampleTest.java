package com.niksum.java.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ExampleTest {
	public static void main(String[] args) {
		Collection<String> coll = new ArrayList<>();
		coll.add("acb"); coll.add("bca"); coll.add("cba");
		System.out.println(coll);
		coll.remove(0);
		System.out.println(coll);
		
		List<Integer> intList = new ArrayList<>();
		intList.add(2);
		intList.add(5);
		intList.add(10);
		intList.add(9);
		System.out.println(intList);
		intList.remove(10);
		System.out.println(intList);
	}
}
