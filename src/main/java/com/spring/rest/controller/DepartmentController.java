package com.spring.rest.controller;

import java.util.HashSet;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.rest.department.service.DepartmentService;
import com.spring.rest.employee.service.EmployeeService;
import com.spring.rest.model.Department;
import com.spring.rest.model.Employee;
import com.spring.rest.model.EntityList;

/**
 * @author Rishikesh Shukla
 *
 *   controller class to handle department related requests
 */

@RestController
@RequestMapping("/department/")
public class DepartmentController {

	private static Logger logger = Logger.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentService departmentService;
	
	 
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<EntityList<Department>> getAllDepartment() {

		List<Department> departments = departmentService.findAllDepartments();
		
		if (departments.isEmpty()) {
			return new ResponseEntity<EntityList<Department>>(HttpStatus.NO_CONTENT);
		}
		EntityList<Department> depEntityList = new EntityList<Department>(departments);
		return new ResponseEntity<EntityList<Department>>(depEntityList, HttpStatus.OK);
	}

	/**
	 * method to get department by Id
	 *
	 * @param id
	 * @return Department
	 */
	@RequestMapping(value = "{id}/", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Department> getDepartmentById(@PathVariable("id") long id) {
		Department department = departmentService.findById(id);
		if(department != null)
			return new ResponseEntity<Department>(department,HttpStatus.OK);
		else
		 return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);
	}

	/**
	 * 
	 * @param department
	 * @param uriBuilder
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Void> createDepartment(@RequestBody Department department, UriComponentsBuilder ucBuilder) {
		if(departmentService.isDepartmentExist(department)){
			logger.warn("A Department with name : " + department.getName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		departmentService.saveDepartment(department);		

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("{id}/").buildAndExpand(department.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	

	/**
	 * 
	 * @param id
	 * @param department
	 * @return
	 */
	@RequestMapping(value = "{id}/",method = RequestMethod.PUT, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Department> updateDepartment(
			@PathVariable("id") long id, @RequestBody Department department) {

		Department currentDepartment = departmentService.findById(id);
		if(currentDepartment == null){
			logger.warn("No Department found with id : " + id);
			return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);
		}
		currentDepartment.setName(department.getName());
		currentDepartment.setLocation(department.getLocation());
		
		departmentService.updateDepartment(currentDepartment);
		
		return new ResponseEntity<Department>(currentDepartment,HttpStatus.OK);
		
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	
	@RequestMapping(value = "{id}/", method = RequestMethod.DELETE, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public  ResponseEntity<Void> deleteDepartment(@PathVariable("id") long id){
		
		Department department = departmentService.findById(id);
		if(department == null){
			logger.warn("Unable to delete , no department found with id : " + id);
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		departmentService.deleteDepartment(department);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
}
