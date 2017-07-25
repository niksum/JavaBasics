package com.niksum.java.thread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

class MapperHelper implements Runnable{
	Map<Integer, String> myMap;
	public MapperHelper(Map<Integer,String> _map){
		myMap = _map;
	}
	
	@Override
	public void run(){
		myMap.put(3, "one");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myMap.put(4, "one");
	}
}
public class MapperEx {
	public static void main(String[] args) {
		Map<Integer,String> map = Collections.synchronizedMap(new HashMap<>());
		for (int i = 0; i < 6; i++) {
			Thread a = new Thread(new MapperHelper(map));
			a.start();
			
		}
		
		
	}
}
