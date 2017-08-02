package com.niksum.java.basic.abstracts;
abstract class AbsCls{
	public void method(){
		System.out.println("AbsCls :- Method");
	}
	
	public static void method2(){
		System.out.println("AbsCls :- Method2");
	}
	
	public final void method3(){
		System.out.println("AbsCls :- Method3");
	}
	
	public static final void method4(){
		System.out.println("AbsCls :- Method4");
	}
	
	public abstract void method5();
	
}

class AbsClsClient extends AbsCls{
	public void method(){
		System.out.println("AbsClsClient :- method");
	}
	
	public static void method2(){
		System.out.println("AbsClsClient :- method2");
	}

	@Override
	public void method5() {
		System.out.println("AbsClsClient :- method5");
	}
}
public class AbstractRules {
	public static void main(String[] args) {
		AbsCls abs = new AbsClsClient();
		
	}
}
