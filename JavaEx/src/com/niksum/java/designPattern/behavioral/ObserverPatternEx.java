package com.niksum.java.designPattern.behavioral;

import java.util.ArrayList;
import java.util.List;

interface Observer {
	public void update(Subject sub);
}

class BillObserver implements Observer{

	@Override
	public void update(Subject sub) {
		System.out.println("BillObserver has been called from " + sub.getName());		
	}
	
}

class TaxObserver implements Observer{

	@Override
	public void update(Subject sub) {
		System.out.println("TaxObserver has been called from " + sub.getName());		
	}
	
}

abstract class Subject {
	private List<Observer> subObser = new ArrayList();
	private String subName;
	
	public String getName (){
		return subName;
	}
	
	public void setName (String name){
		subName = name;
	}
	
	public void registeredObserver(Observer ob){
		subObser.add(ob);
	}
	public void removeObserver(Observer ob){
		subObser.remove(ob);
	}
	public void notifyObserver(){
		for (Observer observer : subObser) {
			observer.update(this);
		}
	}
	
	public abstract void process();
}

class Device extends Subject{

	public Device(){
		setName("Device");
	}
	
	@Override
	public void process() {
		System.out.println("Doing processing of " +getName() +" Subject. After that sending notification to observer");
		this.notifyObserver();		
	}
	
}

class Service extends Subject{

	public Service(){
		setName("Service");
	}
	
	@Override
	public void process() {
		System.out.println("Doing processing of " +getName() +" Subject. After that sending notification to observer");
		this.notifyObserver();		
	}
}
public class ObserverPatternEx {
	public static void main(String[] args) {
		Subject devSub = new Device();
		Subject serSub = new Service();
		
		Observer billOb = new BillObserver();
		Observer taxOb = new TaxObserver();
		
		devSub.registeredObserver(taxOb);
		devSub.registeredObserver(billOb);
		
		serSub.registeredObserver(taxOb);
		
		devSub.process();
		serSub.process();
	}
}
