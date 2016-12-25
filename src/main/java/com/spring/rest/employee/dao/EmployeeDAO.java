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

	Employee findById(long id);

	Employee findByEmail(String email);

	Employee save(Employee employee);

	void update(Employee employee);

	void remove(Employee employee);

}
