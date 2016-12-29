package com.spring.rest.department.service;

import java.util.List;

import com.spring.rest.model.Department;

/**
 * @author Rishikesh Shukla
 *
 */
public interface DepartmentService {

	/**
	 * 
	 * @return
	 */
	List<Department> findAllDepartments();

	/**
	 * 
	 * @param id
	 * @return
	 */
	Department findById(long id);

	/**
	 * 
	 * @param department
	 */
	void saveDepartment(Department department);

	/**
	 * 
	 * @param department
	 * @return
	 */
	boolean isDepartmentExist(Department department);

	/**
	 * 
	 * @param currentDepartment
	 */
	void updateDepartment(Department currentDepartment);

	/**
	 * 
	 * @param department
	 */
	void deleteDepartment(Department department);

}

