package com.nikhil.test.springRest;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;

import com.nikhil.test.springRest.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //BeanNameAware
//        BeanFactoryAware
//        BeanPostProcessors
//        InitializingBean
//        DisposableBean
        
        
        Employee myclass = new Employee();
      //populate myclass here

      JAXBContext context;
	try {
		context = JAXBContext.newInstance(Employee.class);
		Marshaller m = context.createMarshaller();
	      StringWriter w = new StringWriter();

	      m.marshal(myclass, w);
	      System.out.println(w);
	} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

      
    }
}
