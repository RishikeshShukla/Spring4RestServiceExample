package com.spring.rest.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.rest.model.Employee;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	private static final AtomicLong counter = new AtomicLong();

	private static List<Employee> employees;

	static {
		employees = populateDummyEmployees();
	}

	public List<Employee> findAllEmployees() {
		return employees;
	}

	public Employee findById(long id) {
		for (Employee employee : employees) {
			if (employee.getId() == id) {
				return employee;
			}
		}
		return null;
	}

	public Employee findByName(String name) {
		for (Employee employee : employees) {
			if (employee.getName().equalsIgnoreCase(name)) {
				return employee;
			}
		}
		return null;
	}

	public void saveEmployee(Employee employee) {
		employee.setId(counter.incrementAndGet());
		employees.add(employee);
	}

	public void updateEmployee(Employee employee) {
		int index = employees.indexOf(employee);
		employees.set(index, employee);
	}

	public void deletEmployeeById(long id) {

		for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext();) {
			Employee employee = iterator.next();
			if (employee.getId() == id) {
				iterator.remove();
			}
		}
	}

	public boolean isEmployeeExist(Employee employee) {
		return findByName(employee.getName()) != null;
	}

	private static List<Employee> populateDummyEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(counter.incrementAndGet(), "Sam", 30, 70000));
		employees.add(new Employee(counter.incrementAndGet(), "Tom", 40, 50000));
		employees.add(new Employee(counter.incrementAndGet(), "Jerome", 45, 30000));
		employees.add(new Employee(counter.incrementAndGet(), "Silvia", 50, 40000));
		return employees;
	}

	public void deleteAllEmployees() {
		employees.clear();
	}

}
