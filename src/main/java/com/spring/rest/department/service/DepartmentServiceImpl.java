package com.spring.rest.department.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rest.department.dao.DepartmentDAO;
import com.spring.rest.model.Department;

/**
 * 
 * @author Rishikesh Shukla
 *
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDAO departmentDAO;

	@Override
	public List<Department> findAllDepartments() {
		return departmentDAO.findAllDepartments();
	}

	@Override
	public Department findById(long id) {
		return departmentDAO.findById(id);
	}

	@Override
	public void saveDepartment(Department department) {
		departmentDAO.saveDepartment(department);
	}

	@Override
	public boolean isDepartmentExist(Department department) {
		return findById(department.getId()) != null;
	}

	@Override
	public void updateDepartment(Department currentDepartment) {
		departmentDAO.update(currentDepartment);
	}

	@Override
	public void deleteDepartment(Department department) {
		departmentDAO.remove(department);
	}

}
