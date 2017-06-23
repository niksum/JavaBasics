package com.nikhil.test.springRest.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.filter.ServletContextRequestLoggingFilter;

import com.nikhil.test.springRest.model.Employee;
import com.nikhil.test.springRest.model.Status;
import com.nikhil.test.springRest.services.DataServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;



@Controller
@RequestMapping("/employee")
@Api(value="Employee")
public class RestController {

	@Autowired
	DataServices dataServices;

	@RequestMapping(value = "/create", 
			method = RequestMethod.POST)
	public @ResponseBody Status addEmployee(@RequestBody Employee employee) {
		try{
		dataServices.addEntity(employee);
		return new Status(1, "Employee added Successfully !");
	}catch(
			
	Exception e)

	{
		// e.printStackTrace();
		return new Status(0, e.toString());
	}

	}

	/* Ger a single objct in Json form in Spring Rest Services */
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.GET)
	@ApiOperation(value="Get a employee on id", notes="give only one result", response=Employee.class)
	@ApiParam(required=true, example="2", name="Employee ID")
	public @ResponseBody Employee getEmployee(@PathVariable("id") long id) {
		Employee employee = null;
		try {
			employee = dataServices.getEntityById(id);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

	/* Getting List of objects in Json format in Spring Restful Services */
	@RequestMapping(value = "/list", 
			method = RequestMethod.GET)
	@ApiOperation(value="Return a list of employees", notes="List of employees", response=List.class)
	public @ResponseBody List<Employee> getEmployee() {
		System.out.println("list");
		List<Employee> employeeList = null;
		try {
			employeeList = dataServices.getEntityList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return employeeList;
	}
	
	// Not working.....
	/* Getting List of objects in Json format in Spring Restful Services */
	@RequestMapping(value = "/employees", 
			method = RequestMethod.GET,produces = (MediaType.APPLICATION_XML_VALUE))
	public @ResponseBody List<Employee> getEmployees() {
		System.out.println("list5");
		List<Employee> employeeList = null;
		try {
			employeeList = dataServices.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return employeeList;
	}


	/* Delete an object from DB in Spring Restful Services */
	@RequestMapping(value = "delete/{id}",
			method = RequestMethod.DELETE)
	@ApiOperation(value="to delete an employee", notes="Id shoud be present in list of emp", response=Status.class)
	@ApiParam(required=true, name="Emp Id")
	public @ResponseBody Status deleteEmployee(@PathVariable("id") long id) {

		try {
			dataServices.deleteEntity(id);
			return new Status(1, "Employee deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}