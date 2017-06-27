package com.niksum.learn.spring.basicTest.xmlconfig.bean;

public class ASingletonBean {
	private BPrototypeBean bpBean;
	public void setBpBean(BPrototypeBean bpBean) {
		System.out.println("In setter of BPBean");
		this.bpBean = bpBean;
	}
	
	private static int counter = 0;
	ASingletonBean(){
		System.out.println("ASingletonBean con");
		System.out.println("ASingleton counter "+ ++counter);
	}
}
