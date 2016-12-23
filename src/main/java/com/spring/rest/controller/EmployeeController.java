package com.spring.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.model.Employee;
import com.spring.rest.service.EmployeeService;

/*
 * Controller which will do all data retrieval/manipulation for Employees
 */

@RestController
public class EmployeeController {

	private static Logger logger = Logger.getLogger(EmployeeController.class);
	// Service which will do all data retrieval/manipulation work
	@Autowired
	EmployeeService employeeService; 

	/**
	 * Method to Retrieve All Employee
	 */
	/*@RequestMapping(value = "/employee/", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> listAllEmployees() {

		List<Employee> employees = employeeService.findAllEmployees();
		if (employees.isEmpty()) {
			// can return HttpStatus.NOT_FOUND
			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);

		}
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}*/

	/**
	 * Method to Retrieve Single Employee
	 * 
	 * @param id employeeId
	 * 
	 * @return employee object
	 */
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") long id) {
		
		Employee employee = employeeService.findById(id);
		if (employee == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	/*
	*//**
	 * Method Create a Employee
	 * 
	 * @param employee Employee Object
	 * @param ucBuilder
	 * 
	 * @return void
	 * *//*

	@RequestMapping(value = "/employee/", method = RequestMethod.POST)
	public ResponseEntity<Void> createEmployee(@RequestBody Employee employee, UriComponentsBuilder ucBuilder) {
		
        logger.info("Creating Employee " + employee.getName());
		if (employeeService.isEmployeeExist(employee)) {
			logger.warn("A Employee with name " + employee.getName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		employeeService.saveEmployee(employee);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/employee/{id}").buildAndExpand(employee.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	
     *//**
      * Method to update Employee
      * 
      * @param id    employee id
      * @param employee   employee object
      * 
      * @return employee 
      *//*
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
	
		logger.info("Updating Employee " + id);
		Employee currentEmployee = employeeService.findById(id);

		if (currentEmployee == null) {
			logger.warn("Employee with id " + id + " not found");
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}

		currentEmployee.setName(employee.getName());
		currentEmployee.setAge(employee.getAge());
		currentEmployee.setSalary(employee.getSalary());

		employeeService.updateEmployee(currentEmployee);
		return new ResponseEntity<Employee>(currentEmployee, HttpStatus.OK);
	}

	
	*//**
	 * Method to Delete a Employee
	 * 
	 * @param id employee id
	 *             
	 * @return employee deleted employee
	 * *//*

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting Employee with id " + id);

		Employee employee = employeeService.findById(id);
		if (employee == null) {
			logger.warn("Unable to delete. Employee with id " + id + " not found");
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}

		employeeService.deletEmployeeById(id);
		return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
	}

	// -------------------  --------------------

	*//**
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
