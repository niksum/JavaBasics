package com.nikhil.test.springRest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nikhil.test.springRest.dao.DataDao;
import com.nikhil.test.springRest.model.Employee;

public class DataServicesImpl implements DataServices {

	@Autowired
	DataDao dataDao;

	@Override
	public boolean addEntity(Employee employee) throws Exception {
		return dataDao.addEntity(employee);
	}

	@Override
	@org.springframework.transaction.annotation.Transactional(propagation=Propagation.MANDATORY,isolation=Isolation.DEFAULT)
	public Employee getEntityById(long id) throws Exception {
		return dataDao.getEntityById(id);
	}

	@Override
	public List<Employee> getEntityList() throws Exception {
		return dataDao.getEntityList();
	}

	@Override
	public boolean deleteEntity(long id) throws Exception {
		return dataDao.deleteEntity(id);
	}

}