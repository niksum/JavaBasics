package com.niksum.java.puzzel.javapuzzelbook;
class Creature{
	private static long counter = 0;
	public Creature(){
		counter++;
	}
	
	public static long getCount(){
		return counter;
	}
}
public class Puzzel55 {
	public static void main(String[] args) {
		
		//below creature will not work and give compile issue.
//		for (int i = 0; i < 100; i++) 
//			Creature cre = new Creature();
		//	A local variable declaration can appear only as a statement directly within a block.
		// below creation of creature will work and produce result
		for (int i = 0; i < 100; i++) 
			new Creature();
	}
}


