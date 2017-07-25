package com.niksum.java.puzzel;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MiddleOfLinkedListEx {
	public static void main(String[] args) {
		String[] strArr = {"A","B","C","D","E","F","G","H"};
		LinkedList<String> myList =
				new LinkedList<>(Arrays.asList(strArr));
		
		System.out.println(myList.get(myList.size()/2));
	}
}
