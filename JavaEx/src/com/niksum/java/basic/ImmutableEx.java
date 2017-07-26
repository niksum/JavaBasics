package com.niksum.java.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;

final class ImmutableObject {
	private final String name;
	private final Date dob;
	private final List<String> strLst;

	public ImmutableObject(final String nm, final Date dt, final List<String> lit) {
		name = nm;
		dob = new Date(dt.getTime());
		strLst = new ArrayList<String>(lit);
	}

	public String getName() {
		String tmpNm = name;
		return tmpNm;
	}

	public Date getDob() {
		return new Date(dob.getTime());
	}

	public List<String> getStrLst() {
		return Collections.unmodifiableList(strLst);
	}

	@Override
	public String toString() {
		return ("ImmutableObject state is " 
					+ "\n \t Name = " + getName() 
					+ " \n \t DOB = " + getDob() 
					+ " \n\t List = " + getStrLst());
	}
}

public final class ImmutableEx {
	public static void main(String[] args) {
		List<String> lit = new ArrayList<String>();
		lit.add("a"); lit.add("b");lit.add("c");
		String nm = "nikhil";
		Date dt = new Date();
		ImmutableObject obj = new ImmutableObject(nm, dt, lit);
		System.out.println(obj.toString());
		
		nm = "Kumar";
		lit.add("d");
		dt = new Date();
		
		System.out.println(obj.toString());
		
		List<String> tmp = obj.getStrLst();
//		tmp.add("f");
		System.out.println(obj.toString());
		
		Date tmpD = obj.getDob();
		tmpD.setMonth(8);
		
		System.out.println(obj.toString());
	}
}
