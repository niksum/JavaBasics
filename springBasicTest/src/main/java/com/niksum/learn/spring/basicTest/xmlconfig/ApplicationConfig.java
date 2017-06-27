package com.niksum.learn.spring.basicTest.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.niksum.learn.spring.basicTest.xmlconfig.bean.ABean;
import com.niksum.learn.spring.basicTest.xmlconfig.bean.ASingletonBean;
import com.niksum.learn.spring.basicTest.xmlconfig.bean.BBean;
import com.niksum.learn.spring.basicTest.xmlconfig.bean.BProtoHavingSingBean;
import com.niksum.learn.spring.basicTest.xmlconfig.bean.BPrototypeBean;
import com.niksum.learn.spring.basicTest.xmlconfig.bean.RequestManager;
import com.niksum.learn.spring.basicTest.xmlconfig.bean.RequestManagerAoPProxy;
import com.niksum.learn.spring.basicTest.xmlconfig.bean.RequestManagerLookUpMethod;

public class ApplicationConfig {
	
	private static ApplicationContext factory;
	
	public static void main(String[] args) {
		factory = new ClassPathXmlApplicationContext("com/niksum/learn/spring/basicTest/xmlconfig/config.xml");
//		basicBeanPopulation();
		
		
//		depenInjectionIssue();
		// in above case we are adding Prot bean in Singleton bean.. and getting bean object from Spring container it 
		// is going to give same instance for prototype bean also.
		// to solve this issue we can provide 3 solution
		// a) implementing ApplicationContextAware Interface. 
		//Make sure you are using Application Context and not Beanfactory in this case.
		// BeanFactory do lazy loading, but ApplicationContext follow pre-loading methodology
//		diIssueApplCon();
		// b) Lookup method injection :- in this case we create a proxy of singleton bean
		// it is done using CGLIB.
//		Note that the bean which is defined with the look up method will be dynamically subclassed by the Spring 
//		framework (using CGLIB library) and this subclass will override and provide implementation 
//		for the methods which are configured as look-up method.
//		Since look-up method has to be implemented so it has to be either defined as abstract method or you can provide some dummy implementation.
//		diIssueLookUp();
		// c) aop:scoped-proxy :- in this case we create proxy of prototype bean
//		diIssueAoPScoped();
		
		
		// Prototype bean having singleton bean in it
		diIssueProtoHavingSing();
	}
	
	public static void diIssueProtoHavingSing(){
		
		System.out.println(" >>>>>>>>>>>>>>>  diIssueProtoHavingSing  <<<<<<<<<<<<<<<<<<< \n\n");
		
		BProtoHavingSingBean bProt = (BProtoHavingSingBean) factory.getBean("bProtoHavingSingBean");
		bProt.methodOfBBean();
		bProt.methodOfBBean();
		
		BProtoHavingSingBean bProt2 = (BProtoHavingSingBean) factory.getBean("bProtoHavingSingBean");
		bProt2.methodOfBBean();
	}
	
	
	public static void depenInjectionIssue(){
		
		ASingletonBean aSingletonBean = (ASingletonBean)factory.getBean("asBean");
		ASingletonBean aSingletonBean2 = (ASingletonBean)factory.getBean("asBean");
		
		BPrototypeBean bPrototypeBean = (BPrototypeBean)factory.getBean("bpBean");
			
	}
	
	public static void diIssueLookUp(){
		
		 RequestManagerLookUpMethod bean = (RequestManagerLookUpMethod) factory.getBean("reqMgrLookUp");

	        bean.handleRequest();
	        bean.handleRequest();
	        bean.handleRequest();
	       
	}
	
	public static void diIssueAoPScoped(){
		
		 RequestManagerAoPProxy bean = (RequestManagerAoPProxy) factory.getBean("reqMgrAoP");

	        bean.handleRequest();
	        bean.handleRequest();
	        bean.handleRequest();
	       
	}
	
	public static void diIssueApplCon(){
		
		 RequestManager bean = (RequestManager) factory.getBean("reqMgr");

	        bean.handleRequest();
	        bean.handleRequest();
	        bean.handleRequest();
	       
	}
	public static void basicBeanPopulation(){
		ABean aBean = (ABean)factory.getBean("aBean");
		aBean.methodOfABean();
		ABean aBeanDuplicate = (ABean)factory.getBean("aBean");
		aBeanDuplicate.methodOfABean();
		ABean aBeanSecond = (ABean)factory.getBean("aBeanSecond");
		aBeanSecond.methodOfABean();
		
		System.out.println(">>>><<<<<< ");
		
		BBean bBean = (BBean)factory.getBean("bBean");
		bBean.methodOfBBean();
		BBean bBeanDuplicate = (BBean)factory.getBean("bBean");
		bBeanDuplicate.methodOfBBean();
		BBean bBeanSecond = (BBean)factory.getBean("bBeanSecond");
		bBeanSecond.methodOfBBean();
		BBean bBeanSecond2 = (BBean)factory.getBean("bBeanSecond");
		bBeanSecond2.methodOfBBean();
		
	}
}
