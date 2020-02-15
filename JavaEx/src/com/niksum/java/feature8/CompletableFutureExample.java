package com.niksum.java.feature8;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
abstract class a{
	abstract void main();
}
public class CompletableFutureExample {
	public static void main(String[] args) {
		//completedCFEx();
		cfAsyEx();
	}
	static void completedCFEx(){
		CompletableFuture cf= CompletableFuture.completedFuture("Hello");
		System.out.println(cf.isDone());
		System.out.println(cf.getNow(null));
		Map<String, List<Double>> map = new ConcurrentHashMap();
	
	
	}
	
	
	void method (String sy, double dou){
		Map<String, List<Double>> map = new ConcurrentHashMap();
		if (map.containsKey(sy)){
			map.get(sy).add(dou);
		}
		map.get(sy).stream().mapToDouble(a -> a).average();
	}
	static void cfNextStage(){
//		CompletableFuture cf = CompletableFuture.completedFuture("Hllo").thenAcc(fn)
	}
	
	static void cfAsyEx(){
		CompletableFuture cf = CompletableFuture.runAsync(()->{
			System.out.println("Is Current thread is Daemon "+Thread.currentThread().isDaemon());
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Getting out of sleep");
		});
		
		System.out.println("CF is done "+cf.isDone());
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("CF is done "+cf.isDone());
	}
}
