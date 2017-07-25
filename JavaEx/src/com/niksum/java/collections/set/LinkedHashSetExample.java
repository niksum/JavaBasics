package com.niksum.java.collections.set;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

class SetData{

	
	public String field1,field2;
	
	public SetData(String f1, String f2){
		this.field1 = f1;
		this.field2 = f2;
	}
	
	@Override
	public String toString(){
		return "SetDataObject Field1 = "+field1 + " and Field2 = "+ field2;
	}

	@Override
	public int hashCode() {		
		return this.field1.hashCode();
	}

	@Override
	public boolean equals(Object arg){
		if (arg == null || ! (arg instanceof SetData))
			return false;
		SetData obj = (SetData) arg;
		if(this.field1 == obj.field1)
			return true;
		else 
			return false;
	}
}
public class LinkedHashSetExample {
	public static void main(String[] args) {
		SetData obj1 = new SetData("A", "A");
		SetData obj2 = new SetData("B", "Aiopv");
		SetData obj3 = new SetData("C", "CC");
		SetData obj4 = new SetData("D", "A");
		SetData obj5 = new SetData("E", "A");
		SetData obj6 = new SetData("F", "FF");
		SetData obj7 = new SetData("G", "GG");
		SetData obj8 = new SetData("H", "HH");
		SetData obj9 = new SetData("I", "II");
		SetData obj10 = new SetData("C", "CCC");
		
		Set<SetData> mySet = new LinkedHashSet<>();
		mySet.add(obj1);
		mySet.add(obj2);
		mySet.add(obj3);
		mySet.add(obj4);
		mySet.add(obj5);
		mySet.add(obj6);
		mySet.add(obj7);
		mySet.add(obj8);
		mySet.add(obj9);
		mySet.add(obj10);
		
		mySet.stream()
		.forEach(System.out::println);
		
		System.out.println(mySet.stream()
		.filter(x -> ("A".equals(x.field1) || "B".equals(x.field1)))
		.map(x -> x.field2)
		.collect(Collectors.toList())
		);
				
		
	}
}
