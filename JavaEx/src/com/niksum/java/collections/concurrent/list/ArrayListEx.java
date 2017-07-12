package com.niksum.java.collections.concurrent.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//To Avoid ConcurrentModificationException in multi-threaded environment

//You can convert the list to an array and then iterate on the array. 
//This approach works well for small or medium size list but if the list is large then it will affect the performance a lot.
//You can lock the list while iterating by putting it in a synchronized block. 
//This approach is not recommended because it will cease the benefits of multithreading.
//If you are using JDK1.5 or higher then you can use ConcurrentHashMap and CopyOnWriteArrayList classes. 
//This is the recommended approach to avoid concurrent modification exception.
public class ArrayListEx {
	public static void main(String[] args) {
		//concurrentExc();
		conCurrExc2();
	}
	
	private static void conCurrExc2(){
		List<String> myList = new ArrayList<>();
		myList.add("A");
		myList.add("B");
		myList.add("C");
		myList.add("D");
		
		for (Iterator iterator = myList.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
			if(string.equalsIgnoreCase("C")){
				// this modification will not throw exception because it is mantaing the variable with proper value
				iterator.remove();
			}
		}
		
		for (String string : myList) {
			System.out.println(string);
			if("B".equalsIgnoreCase(string)){
				myList.set(0, "DD");
			}
		}
		
		myList.stream()
		.forEach(System.out::println);
		
		
		for (String string : myList) {
			System.out.println(string);
			if("B".equalsIgnoreCase(string)){
				myList.add("LLL");
			}
		}
		
		myList.stream()
		.forEach(System.out::println);
	}
	
	public static void concurrentExc(){
		List<String> myList = new ArrayList<>();
		myList.add("A");
		myList.add("B");
		myList.add("C");
		myList.add("D");
		
		for (Iterator iterator = myList.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
			if(string.equalsIgnoreCase("C")){
				// below operation will result in to change the modCount value and after that if we are iterating over the list
				// it will throw exception because if compare its value with another integer it is maintaing. and those are not in 
				// sync
				myList.add("E"); 
				myList.remove("D");
			}
		}
	}
}
