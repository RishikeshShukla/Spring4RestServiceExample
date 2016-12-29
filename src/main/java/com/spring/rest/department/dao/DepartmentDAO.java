package com.spring.rest.department.dao;

import java.util.List;

import com.spring.rest.model.Department;
/**
 * 
 * @author Rishikesh Shukla
 *
 */
public interface DepartmentDAO {

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
	 * @param currentDepartment
	 */
	void update(Department currentDepartment);

	/**
	 * 
	 * @param department
	 */
	void remove(Department department);

}
