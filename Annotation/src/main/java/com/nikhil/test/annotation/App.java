package com.nikhil.test.annotation;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 *
 */
public class App {
	static SessionFactory sf = null;
	static ServiceRegistry sr = null;

	public static void main(String[] args) {
		Configuration cfg = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(EmpName.class)
				.addAnnotatedClass(EmployeeDetails.class)
				.addAnnotatedClass(Contractor.class)
				.addAnnotatedClass(EmpSkillSet.class)
				.addAnnotatedClass(Project.class);

		// Given below approach is not recommended by hibernate.
		// sf = cfg.buildSessionFactory();

		sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		sf = cfg.buildSessionFactory(sr);

//		createingData();
		
//		updateData();
//		mergeData();
//		sessionLevelCaching();
//		criteriaUsage();
//		criteriaWithRestrictionUsage();
//		criteriaProjectionUsage();
		sqlQueryUsage();
		sf.close();
	}
	
	public static void sqlQueryUsage(){
		System.out.println("****sqlQueryUsage*****");
		Session ses = sf.openSession();
		System.out.println("--> Basic Entiry query");
		String projSql = "Select * from PROJECT";
		SQLQuery query = ses.createSQLQuery(projSql);
		//Adding entity is must in case you are doing entity queries
		query.addEntity(Project.class);
		List<Project> list = query.list();
		for (Project project : list) {
			System.out.println(project);
		}
		
		System.out.println("--> Scalar and named sql query");
		String projSql1 = "Select PROJ_ID,PROJ_CLIENT from PROJECT where PROJ_NAME = :PROJ_NAME";
		SQLQuery query1 = ses.createSQLQuery(projSql1);
		query1.setParameter("PROJ_NAME", "eflow");
		query1.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List<Project> list1 = query1.list();
		System.out.println(list1);
	}
	public static void criteriaProjectionUsage(){
		System.out.println("****criteriaProjectionUsage*****");
		Session ses = sf.openSession();
		Criteria criteria = ses.createCriteria(Employee.class);
		criteria.setProjection(Projections.property("empId"));
		List result = criteria.list();
		System.out.println(result);
		
		Criteria criteria1 = ses.createCriteria(Employee.class);
		criteria1.setProjection(Projections.projectionList()
				.add(Projections.property("empId"))
				.add(Projections.property("empGender")));
		
		List result1 = criteria1.list();
		for (Object object : result1) {
			System.out.println(object.toString());
		}
	}
	
	public static void criteriaWithRestrictionUsage(){
		System.out.println("****criteriaWithRestrictionUsage*****");
		Session ses = sf.openSession();
		Criteria criteria = ses.createCriteria(Employee.class);
		Criterion nameCriterion = Restrictions.eq("empId",678);
		criteria.add(nameCriterion);
		List<Employee> list = criteria.list();
		for (Employee employee : list) {
			System.out.println(employee);
		}
		
		Criteria criteria1 = ses.createCriteria(Employee.class)
				.createCriteria("empDetail")
				.add(Restrictions.eq("empDepartment","IT"));

		Criteria criteria2 = ses.createCriteria(Employee.class)
				.createCriteria("skillSet")
				.add(Restrictions.eq("skillName","java"));
		
		List<Employee> list1 = criteria1.list();
		for (Employee employee : list1) {
			System.out.println(employee);
		}
		
		List<Employee> list2 = criteria2.list();
		for (Employee employee : list2) {
			System.out.println(employee);
		}
	}
	public static void criteriaUsage(){
		Session ses = sf.openSession();
		System.out.println("**** Criteria Usage ****");
		Criteria criteria = ses.createCriteria("com.nikhil.test.annotation.Employee");
		List<Employee> list = criteria.list();
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}
	public static void sessionLevelCaching(){
		Session ses = sf.openSession();
		Employee emp2 = (Employee)ses.get(Employee.class, 333);
		
		System.out.println(emp2);
		Employee emp3 = (Employee)ses.get(Employee.class, 333);
		
		System.out.println(emp3);
		
		ses.close();
		
		Session ses2 = sf.openSession();
		
		Employee emp4 = (Employee)ses2.get(Employee.class, 333);
		
		System.out.println(emp4);
		
		
	}
	public static void mergeData(){
		Session ses = sf.openSession();
		
		 Employee emp2 = (Employee)ses.get(Employee.class, 333);
		 System.out.println(emp2);
		
//		Transaction tx = ses.beginTransaction();
		ses.close();
		
		emp2.setEmpGender("male");
		
		Session ses1 = sf.openSession();
		Employee emp3 = (Employee) ses1.get(Employee.class, 333);
		
//		ses1.merge(emp2);
		ses1.update(emp2);
		System.out.println(emp3);
		System.out.println(emp2);
		
	}
	
	public static void updateData(){
		Session ses = sf.openSession();
		Transaction tx = ses.beginTransaction();

		Query query = ses.createQuery("From Employee");
		List<Employee> empList = query.list();

		for (Employee employee : empList) {
			System.out.println(employee);
		}

		Query updateQuery = ses.createQuery("update Employee set empGender = :name where empId = :id");
		updateQuery.setParameter("name", "oow454o");
		updateQuery.setParameter("id", 678);
		int status = updateQuery.executeUpdate();
		System.out.println(status);
		tx.commit();
		ses.close();
	}

	public static void createingData() {
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
		EmpSkillSet skillSet = new EmpSkillSet("java", 7);
		EmpSkillSet skillSet2 = new EmpSkillSet("avaa", 3);
		// skillSet.setEmp(emp);
		skillSet.setRecordId(1);
		skillSet2.setRecordId(2);
		// skillSet2.setEmp(emp);
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

		// Employee emp2 = (Employee)ses.get(Employee.class, 3);
		// System.out.println(emp2);
		// EmployeeDetails empDe = emp2.getEmpDetail();
		// System.out.println(empDe);
		//
		// Employee emp5 = (Employee)ses.get(Employee.class, 6);
		// System.out.println(emp5);
		// EmployeeDetails empDe3 = emp5.getEmpDetail();
		// System.out.println(empDe3);

		tx.commit();
		ses.close();
	}

}
