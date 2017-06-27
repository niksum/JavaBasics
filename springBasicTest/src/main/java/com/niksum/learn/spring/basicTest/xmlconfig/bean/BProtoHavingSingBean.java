package com.niksum.learn.spring.basicTest.xmlconfig.bean;

public class BProtoHavingSingBean {
	private static int counter =  0;
	private ASingBean singBean;
	public void setSingBean(ASingBean bean){
		this.singBean = bean;
	}
	BProtoHavingSingBean(){
		System.out.println("construtor BProtoHavingSingBean");
		System.out.println("counter "+ ++counter);
	}
	public void methodOfBBean(){
		System.out.println("BProtoHavingSingBean method calling");
		this.singBean.methodOfABean();
	}
}
