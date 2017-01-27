package com.spring.rest.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.rest.employee.dao.EmployeeDAO;
import com.spring.rest.model.Employee;
import com.spring.rest.model.EmployeeDetailDto;
import com.spring.rest.util.EntityToDtoConverterUtil;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	public EmployeeDetailDto findById(long id) {

		Employee employee = employeeDAO.findById(id);
		EmployeeDetailDto employeeDetailDto = (EmployeeDetailDto) EntityToDtoConverterUtil.convertEntityToDto(employee,
				EmployeeDetailDto.class);
		return employeeDetailDto;

	}

	/*public List<EmployeeDetailDto> findAllEmployees() {
		List<Employee> employees = employeeDAO.findAllEmployees();

		List<EmployeeDetailDto> employeeDetailDtos = EntityToDtoConverterUtil
				.convertEntityCollectionToDtoCollection(employees, EmployeeDetailDto.class);
		return employeeDetailDtos;
	}*/
	
	public List<EmployeeDetailDto> findAllEmployees() {
		List<Employee> employees = employeeDAO.findAllEmployees();

		List<EmployeeDetailDto> employeeDetailDtos = EntityToDtoConverterUtil
				.convertEmployeeEntityCollectionToDtoCollection(employees, EmployeeDetailDto.class);
		return employeeDetailDtos;
	}

	public EmployeeDetailDto findByEmail(String email) {

		Employee employee = employeeDAO.findByEmail(email);
		EmployeeDetailDto employeeDetailDto = (EmployeeDetailDto) EntityToDtoConverterUtil.convertEntityToDto(employee,
				EmployeeDetailDto.class);
		return employeeDetailDto;

	}

	public void saveEmployee(Employee employee) {

		employeeDAO.save(employee);
	}

	public void updateEmployee(Employee employee) {

		employeeDAO.update(employee);
	}

	public void deletEmployeeById(long id) {

		employeeDAO.remove(employeeDAO.findById(id));
	}

	public boolean isEmployeeExist(Employee employee) {

		return findByEmail(employee.getEmailId()) != null;
	}

}
