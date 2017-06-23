package com.niksum.java.designPattern.structural;

interface Charger{
	public void charge();
}
class MobileCharger implements Charger{
	@Override
	public void charge(){
		System.out.println("Charging for mobile ");
	}
}

class LaptopCharger implements Charger{
	@Override
	public void charge(){
		System.out.println("Charging for laptop");
	}
}

class LightCharger implements Charger{
	@Override
	public void charge(){
		System.out.println("Charging for Light");
	}
}
interface Converter{
	public void convert();
}

class ChargerAdapter {
	private Charger charger;
	private Converter converter;
	
	public ChargerAdapter(Charger charger, Converter converter){
		this.charger = charger;
		this.converter = converter;
	}
		
	public void adapt(){
		System.out.println("Adapting process started");
		System.out.println("step.1 >>>> Converting <<<<<<");
		converter.convert();
		System.out.println("step.2 >>>> Charging <<<<<<");		
		charger.charge();		
		System.out.println("step.3 >>>> Done <<<<<<");
	}	
}

class USToUKConverter implements Converter {
	
	@Override
	public void convert(){
		System.out.println("Converting US to UK voltage");		
	}
}

class UKToUSConverter implements Converter {
	
	@Override
	public void convert(){
		System.out.println("Converting UK to US voltage");		
	}
}


public class AdapterExample {
	public static void main(String[] args) {
		Charger lightCharge = new LightCharger();
		Converter usConvert = new USToUKConverter();
		
		Charger laptopCharge = new LaptopCharger();
		Converter ukConvert = new UKToUSConverter();
		
		ChargerAdapter adapt1 = new ChargerAdapter(laptopCharge, ukConvert);
		ChargerAdapter adapt2 = new ChargerAdapter(laptopCharge, usConvert);
		ChargerAdapter adapt3 = new ChargerAdapter(lightCharge, ukConvert);
		
		adapt1.adapt();
		adapt2.adapt();
		adapt3.adapt();
	}
}
