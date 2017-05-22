package com.niksum.java.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Test {

	String info() default "";
}

class Annotated {
	@Test(info = "Awe")
	public void foo(String my) {
		System.out.println("This is " + my);
	}
}

class TestAnnotationParser {
	public void parse(Class<?> clazz) throws Exception {
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			if (method.isAnnotationPresent(Test.class)) {
				Test test = method.getAnnotation(Test.class);
				String info = test.info();
				if ("Awe".equals(info)) {
					System.out.println("Default Awesome value has been added");
					method.invoke(Annotated.class.newInstance(), info);
				}
			}
		}
	}
}

public class TestCustomAnnotation {
	


	public static void main(String[] args) {
		System.out.println("This is TestCustomAnnotation");

		TestAnnotationParser parse = new TestAnnotationParser();
		try {
			parse.parse(Annotated.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
