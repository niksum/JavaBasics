package com.niksum.java.collections;

import java.util.Arrays;
import java.util.List;

public class ArrayToCollect {
	public static void main(String[] args) {
		Object[] objArr = {"A","B","C", "D"};
		List<Object> myList = Arrays.asList(objArr);
		myList.add(23);
		myList.add(new Integer(5));
	}
}
