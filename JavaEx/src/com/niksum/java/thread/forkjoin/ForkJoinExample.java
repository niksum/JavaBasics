package com.niksum.java.thread.forkjoin;

import java.io.File;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExample {
	private final File file;
	public ForkJoinExample(){
		System.out.println("Constructor");
		file = new File("C:\\Users\\ab36552\\Desktop\\input.txt");
	}
	public static void main(String[] args) {
		
	}
	
	private static class LenghtOfLineTask extends RecursiveTask<Long>{
		@Override
		protected Long compute(){
			return null;
		}
	}
	
}
