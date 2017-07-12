package com.niksum.java.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Employee implements Serializable {
	public String lastName;
	static String companyName;
	transient String address;
	static transient String companyCE;
}

class Boss extends Employee {
	public String firstName;
	private static final long serialVersionUID = 6607781557119785769L;

}


class EmpSerialize{
	public  void serialize() {
		Boss emp = new Boss();
		emp.firstName = "Nikhil";
		emp.lastName = "Summi";
		emp.companyCE = "GPd";
		emp.address = "Indirapdduram";
		emp.companyName = "CTL";
		FileOutputStream fOstream = null;
		ObjectOutputStream oOStream = null;
		try {
			fOstream = new FileOutputStream("./boss.txt");
			oOStream = new ObjectOutputStream(fOstream);
			oOStream.writeObject(emp);
		} catch (IOException i) {
			i.printStackTrace();
		} finally {
			try {
				oOStream.close();
				fOstream.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		emp = null;
	}
}

class EmpDeserialize{
	public  void deSerialize() {
		FileInputStream fIS = null;
		ObjectInputStream oIS = null;
		Boss obj = null;
		try {
			fIS = new FileInputStream("./boss.txt");
			oIS = new ObjectInputStream(fIS);
			obj = (Boss)oIS.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				oIS.close();
				fIS.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		
		System.out.println("First Name " + obj.firstName);
		System.out.println("Last Name " + obj.lastName);
		System.out.println("Company Name " + obj.companyName);
		System.out.println("CEO Name " + obj.companyCE);
		System.out.println("Address " + obj.address);
	}
}
public class SerializeEx {
	public static void main(String[] args) {
		// below things need to be done in two separet call... otherwise you will see that value will be present for static
//		System.out.println("Calling serializeing method");
//		new EmpSerialize().serialize();
		System.out.println("Calling DeSerializeing method");
		new EmpDeserialize().deSerialize();
	}

	
}
