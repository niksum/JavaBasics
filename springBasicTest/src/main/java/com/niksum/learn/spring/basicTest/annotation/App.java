package com.niksum.learn.spring.basicTest.annotation;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niksum.learn.spring.basicTest.annotation.bean.A;

/**
 * Hello world!
 *
 */


public class App 
{
    public static void main( String[] args )
    {
       BeanFactory beanFactory = new AnnotationConfigApplicationContext(AppConfig.class);
       A a = (A)beanFactory.getBean("A");
//       System.out.println(a.toString());
       a.processA();
//       B b = (B)beanFactory.getBean("B");
//       b.toString();
    }
}
