package com.spring.rest.employee.service;

import java.util.List;

import com.spring.rest.model.Employee;

public interface EmployeeService {

	Employee findById(long id);

	Employee findByEmail(String email);

	void saveEmployee(Employee employee);

	void updateEmployee(Employee employee);

	void deletEmployeeById(long id);

	List<Employee> findAllEmployees();

	public boolean isEmployeeExist(Employee employee);

}
