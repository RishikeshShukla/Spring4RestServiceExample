/**
 * 
 */
package com.spring.rest.employee.dao;

import java.util.List;

import com.spring.rest.model.Employee;

/**
 * @author Rishikesh Shukla
 *
 */
public interface EmployeeDAO {

	List<Employee> findAllEmployees();

	Employee findById();

}
