package com.spring.rest.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
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

import com.spring.rest.employee.service.EmployeeService;
import com.spring.rest.model.DtoResponse;
import com.spring.rest.model.Employee;
import com.spring.rest.model.EmployeeDetailDto;

/*
 * Controller which will do all data retrieval/manipulation for Employees
 */

@RestController
public class EmployeeController {

	private static Logger logger = Logger.getLogger(EmployeeController.class);
	// Service which will do all data retrieval/manipulation work
	
	@Autowired
	EmployeeService employeeService; 
	
	@Autowired
	ModelMapper modelMapper;

	/**
	 * Method to Retrieve All Employee
	 */
	
	@RequestMapping(value = "/employee/", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<DtoResponse> listAllEmployees() {

		List<EmployeeDetailDto> employeeList = employeeService.findAllEmployees();
		System.out.println("controller" + employeeList.size());
		DtoResponse employees = new DtoResponse(employeeList);
		
		if (employees.isEmpty()) {
			// can return HttpStatus.NOT_FOUND
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		//List<EmployeeDetailDto> empEntityList = new List<EmployeeDetailDto>(employees);
		
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	/**
	 * Method to Retrieve Single Employee
	 * 
	 * @param id employeeId
	 * 
	 * @return employee object
	 */
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<EmployeeDetailDto> getEmployee(@PathVariable("id") long id) {
		
		EmployeeDetailDto employeeDtlDto = employeeService.findById(id);
		if (employeeDtlDto == null) {
			return new ResponseEntity<EmployeeDetailDto>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<EmployeeDetailDto>(employeeDtlDto, HttpStatus.OK);
	}

	
	/**
	 * Method Create a Employee
	 * 
	 * @param employee Employee Object
	 * @param ucBuilder
	 * 
	 * @return void
	 */

	@RequestMapping(value = "/employee/", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Void> createEmployee(@RequestBody Employee employee, UriComponentsBuilder ucBuilder) {
		
        logger.info("Creating Employee " + employee.getFirstName());
		if (employeeService.isEmployeeExist(employee)) {
			logger.warn("A Employee with name : " + employee.getFirstName() + " and email : " + employee.getEmailId()
					+ " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		employeeService.saveEmployee(employee);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/employee/{id}").buildAndExpand(employee.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	
     /**
      * Method to update Employee
      * 
      * @param id    employee id
      * @param employee   employee object
      * 
      * @return employee 
      */
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<EmployeeDetailDto> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
	
		logger.info("Updating Employee " + id);
		EmployeeDetailDto currentEmployee = employeeService.findById(id);

		if (currentEmployee == null) {
			logger.warn("Employee with id " + id + " not found");
			return new ResponseEntity<EmployeeDetailDto>(HttpStatus.NOT_FOUND);
		}

		currentEmployee.setFirstName(employee.getFirstName());
		currentEmployee.setLastName(employee.getLastName());
		currentEmployee.setEmailId(employee.getEmailId());
		currentEmployee.setAge(employee.getAge());
		currentEmployee.setSalary(employee.getSalary());
		
		Employee  updatedEmployee = modelMapper.map(currentEmployee, Employee.class); 
		
		employeeService.updateEmployee(updatedEmployee);
		
		return new ResponseEntity<EmployeeDetailDto>(currentEmployee, HttpStatus.OK);
	}

	
	/**
	 * Method to Delete a Employee
	 * 
	 * @param id employee id
	 *             
	 * @return employee deleted employee
	 * */

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting Employee with id " + id);

		EmployeeDetailDto employee = employeeService.findById(id);
	
		if (employee == null) {
			logger.warn("Unable to delete. Employee with id " + id + " not found");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		employeeService.deletEmployeeById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	// -------------------  --------------------

	/**
	 * Delete All Employee
	 * 
	 *//*
	@RequestMapping(value = "/employee/", method = RequestMethod.DELETE)
	public ResponseEntity<Employee> deleteAllEmployees() {
		logger.info("Deleting All Employees");
		
		employeeService.deleteAllEmployees();
		return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
	}
*/
}
