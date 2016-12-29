package com.spring.rest.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.rest.employee.dao.EmployeeDAO;
import com.spring.rest.model.Employee;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	public Employee findById(long id) {
		return employeeDAO.findById(id);

	}

	public List<Employee> findAllEmployees() {
		return employeeDAO.findAllEmployees();
	}

	public Employee findByEmail(String email) {
		return employeeDAO.findByEmail(email);

	}

	public void saveEmployee(Employee employee) {
		employeeDAO.save(employee);
	}

	public void updateEmployee(Employee employee) {
		employeeDAO.update(employee);
	}

	public void deletEmployeeById(long id) {

		employeeDAO.remove(findById(id));
	}

	public boolean isEmployeeExist(Employee employee) {
		return findByEmail(employee.getEmailId()) != null;
	}


}
