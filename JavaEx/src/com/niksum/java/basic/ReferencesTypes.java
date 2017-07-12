package com.niksum.java.basic;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

class Abc {
	Integer a = new Integer(45);
	String ad = "sdfas";
}
public class ReferencesTypes {
	public static void main(String[] args) throws Exception {
		strongRefEx();
		weakRefEx();
		anotherWeakRefEx();
//		softRefEx();
		phantomRefEx();
	}
	
	private static void phantomRefEx() throws InterruptedException{
		HashMap<Abc, String> myMap = new HashMap<>();
		
		Abc obj = new Abc();
		myMap.put(obj, "adf");
		ReferenceQueue<HashMap<Abc, String>> myQu = new ReferenceQueue<>();
		Reference<HashMap<Abc, String>> phantomRef = new PhantomReference(myMap,myQu);
		
		System.out.println("Size of map --"+myMap.size());
		
		myMap = null;
		int count = 0;
		while (null != phantomRef.get()) {
			phantomRef.get().put(new Abc(),("Programmer"));
            System.out.println("Size of aMap of softRef " + phantomRef.get().size());
            ++count;
            System.gc();
        }
        System.out.println("Its garbage collected in " + count);
	}
	
	private static void softRefEx() throws InterruptedException{
		HashMap<Abc, String> myMap = new HashMap<>();
		
		Abc obj = new Abc();
		myMap.put(obj, "adf");
		
		Reference<HashMap<Abc, String>> softRef = new SoftReference<HashMap<Abc,String>>(myMap);
		
		System.out.println("Size of map --"+myMap.size());
		
		myMap = null;
		int count = 0;
		while (null != softRef.get()) {
			softRef.get().put(new Abc(),("Programmer"));
            System.out.println("Size of aMap of softRef " + softRef.get().size());
            ++count;
            System.gc();
        }
        System.out.println("Its garbage collected in " + count);
	}
	
	private static void anotherWeakRefEx() throws InterruptedException{
		HashMap<Abc, String> myMap = new HashMap<>();
		
		Abc obj = new Abc();
		myMap.put(obj, "adf");
		
		WeakReference<HashMap<Abc, String>> weakRef = new WeakReference<HashMap<Abc,String>>(myMap);
		
		System.out.println("Size of map --"+myMap.size());
		
		myMap = null;
		int count = 0;
		while (null != weakRef.get()) {
			weakRef.get().put(new Abc(),("Programmer"));
            System.out.println("Size of aMap weakRef " + weakRef.get().size());
            ++count;
            System.gc();
        }
        System.out.println("Its garbage collected in " + count);
	}
	
	private static void strongRefEx() throws InterruptedException{
		HashMap<Abc, String> myMap = new HashMap<>();
		
		Abc obj = new Abc();
		myMap.put(obj, "adf");
		
		
		System.out.println("Size of map "+myMap.size());
		obj = null;
		System.gc();
		Thread.sleep(2000);
		System.out.println("Size of map "+myMap.size());
	}
	
	
	private static void weakRefEx() throws InterruptedException{
		Map<Abc, String> myMap = new WeakHashMap<>();
		
		Abc obj = new Abc();
		myMap.put(obj, "adf");
		
		System.out.println("Size of map "+myMap.size());
		obj = null;

		int count = 0;
		while(0!=myMap.size()){
			++count;
			System.gc();
		}
		System.out.println("Took to clean for weakhashmap" + count);
	}
}
