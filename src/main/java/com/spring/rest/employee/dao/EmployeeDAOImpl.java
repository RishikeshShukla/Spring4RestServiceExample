package com.spring.rest.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.rest.generic.dao.GenericHibernateDAO;
import com.spring.rest.model.Employee;

@Repository("employeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private GenericHibernateDAO hibernateDAO;

	@Override
	public Employee findById(long id) {

		return (Employee) hibernateDAO.findById(id, Employee.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAllEmployees() {

		return (List<Employee>) hibernateDAO.findAll(Employee.class);
	}

	@Override
	public Employee findByEmail(String email) {

		return (Employee) hibernateDAO.findByEmail(email, Employee.class);
	}

	@Override
	public Employee save(Employee employee) {

		return (Employee) hibernateDAO.create(employee);
	}

	@Override
	public void update(Employee employee) {
		hibernateDAO.update(employee);

	}

	@Override
	public void remove(Employee employee) {
		hibernateDAO.delete(employee);

	}
}
