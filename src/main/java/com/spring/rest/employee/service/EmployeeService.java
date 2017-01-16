package com.spring.rest.employee.service;

import java.util.List;

import com.spring.rest.model.Employee;
import com.spring.rest.model.EmployeeDetailDto;

public interface EmployeeService {

	EmployeeDetailDto findById(long id);

	EmployeeDetailDto findByEmail(String email);

	void saveEmployee(Employee employee);

	void updateEmployee(Employee employee);

	void deletEmployeeById(long id);

	List<EmployeeDetailDto> findAllEmployees();

	public boolean isEmployeeExist(Employee employee);

}
