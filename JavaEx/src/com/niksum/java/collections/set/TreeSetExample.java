package com.niksum.java.collections.set;

import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

class SetDataObject implements Comparable<SetDataObject>{

	@Override
	public int compareTo(SetDataObject o) {
		return this.field2.compareToIgnoreCase(o.field2);
	}
	
	private String field1,field2;
	
	public SetDataObject(String f1, String f2){
		this.field1 = f1;
		this.field2 = f2;
	}
	
	@Override
	public String toString(){
		return "SetDataObject Field1 = "+field1 + " and Field2 = "+ field2;
	}
	
	@Override
	public boolean equals(Object arg){
		if (arg == null || ! (arg instanceof SetDataObject))
			return false;
		SetDataObject obj = (SetDataObject) arg;
		if(this.field1 == obj.field1)
			return true;
		else 
			return false;
	}
}
public class TreeSetExample {
	public static void main(String[] args) {
		SetDataObject obj1 = new SetDataObject("ikhil", "Kumar");
		SetDataObject obj2 = new SetDataObject("KUMAR", "Summi");
		SetDataObject obj3 = new SetDataObject("Summi", "KUMAR");
		SetDataObject obj4 = new SetDataObject("Nikhil", "Kumar");
		SetDataObject obj5 = new SetDataObject("KUMAR", "SUMMI");
		SetDataObject obj6 = new SetDataObject("Summi", "Nikhil");
		
		Set<SetDataObject> mySet = new TreeSet<>();
		mySet.add(obj1);
		mySet.add(obj2);
		mySet.add(obj3);
		mySet.add(obj4);
		mySet.add(obj5);
		mySet.add(obj6);
		
		mySet.stream()
		.forEach(System.out::println);
		

		
		
	}
}
