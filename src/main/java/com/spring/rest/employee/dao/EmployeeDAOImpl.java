package com.spring.rest.employee.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.rest.generic.dao.HibernateDAO;
import com.spring.rest.model.Employee;

@Repository("employeeDAO")
public class EmployeeDAOImpl extends HibernateDAO implements EmployeeDAO{

	@Override
	public List<Employee> findAllEmployees() {
		if(getSession()!=null)
			System.out.println("session created!!");
		return null;
	}

	@Override
	public Employee findById() {
		if(getSession()!=null)
			System.out.println("session created!!");
		return null;
	}

}
