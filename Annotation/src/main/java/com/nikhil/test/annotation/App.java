package com.nikhil.test.annotation;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(EmpName.class)
				.addAnnotatedClass(EmployeeDetails.class)
				.addAnnotatedClass(Contractor.class)
				.addAnnotatedClass(EmpSkillSet.class)
				.addAnnotatedClass(Project.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session ses = sf.openSession();
		Transaction tx = ses.beginTransaction();
		
		Employee emp = new Employee();
		EmpName ename = new EmpName();
		EmployeeDetails detail = new EmployeeDetails("IT", "SSE");
		ename.setFirstName("nikhil");
		ename.setLastName("kumar");
		detail.setEmpDetailsId(2);
		emp.setEmpName(ename);
		emp.setEmpDetail(detail);
		emp.setEmpId(333);
		emp.setEmpDOJ(new Date(2015, 03, 20));
		emp.setEmpGender("M");
		emp.setEmpHeight(120);
		ses.save(emp);
		
		System.out.println("Checking");
		EmpSkillSet skillSet = new EmpSkillSet("java",7);
		EmpSkillSet skillSet2 = new EmpSkillSet("avaa",3);
//		skillSet.setEmp(emp);
		skillSet.setRecordId(1);
		skillSet2.setRecordId(2);
//		skillSet2.setEmp(emp);
		emp.getSkillSet().add(skillSet);
		emp.getSkillSet().add(skillSet2);
		
		ses.save(skillSet);
		ses.save(skillSet2);
		

		Employee empC = new Contractor();
		EmpName enameW = new EmpName();
		EmployeeDetails detailC = new EmployeeDetails("IIT", "SE");
		enameW.setFirstName("Kumar");
		enameW.setLastName("Summi");
		detailC.setEmpDetailsId(4);
		empC.setEmpName(enameW);
		empC.setEmpDetail(detailC);
		empC.setEmpId(678);
		empC.setEmpDOJ(new Date(2015, 03, 8));
		empC.setEmpGender("f");
		empC.setEmpHeight(140);
		
		
		ses.persist(empC);
		
		Set<Employee> assPr = new HashSet<Employee>();
		assPr.add(emp);
		assPr.add(empC);
		
		Set<Employee> assPr2 = new HashSet<Employee>();
		assPr2.add(empC);
		
		Project proj1 = new Project(109, "eflow", "CTL");
		Project proj2 = new Project(209, "fwher", "CTL");
		
		empC.getProj().add(proj1);
		empC.getProj().add(proj2);
		
		emp.getProj().add(proj2);
		
//		Employee emp2 = (Employee)ses.get(Employee.class, 3);
//		System.out.println(emp2);
//		EmployeeDetails empDe = emp2.getEmpDetail();
//		System.out.println(empDe);
//		
//		Employee emp5 = (Employee)ses.get(Employee.class, 6);
//		System.out.println(emp5);
//		EmployeeDetails empDe3 = emp5.getEmpDetail();
//		System.out.println(empDe3);
		
		tx.commit();
		
		
		Query query = ses.createQuery("From Employee");
		List<Employee> empList = query.list();
		
		for (Employee employee : empList) {
			System.out.println(employee);
		}
		
		Query updateQuery = ses.createQuery("update Employee set empGender = :name where empId = :id");
		updateQuery.setParameter("name", "ooo");
		updateQuery.setParameter("id", 333);
		int status = updateQuery.executeUpdate();
		System.out.println(status);
		ses.close();
		sf.close();
		System.out.println("Hello World!");
		
	}
	
	
	public void testMethod(){
		
	}
	
	
}
