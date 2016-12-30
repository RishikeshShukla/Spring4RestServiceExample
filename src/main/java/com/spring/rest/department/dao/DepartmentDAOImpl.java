package com.spring.rest.department.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.rest.generic.dao.GenericHibernateDAO;
import com.spring.rest.model.Department;

/**
 * @author Rishikesh Shukla
 *
 */
@Repository("departmentDAO")
public class DepartmentDAOImpl implements DepartmentDAO {

	@Autowired
	private GenericHibernateDAO hibernateDAO;

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findAllDepartments() {

		return (List<Department>) hibernateDAO.findAll(Department.class);
	}

	@Override
	public Department findById(long id) {

		return (Department) hibernateDAO.findById(id, Department.class);
	}

	@Override
	public void saveDepartment(Department department) {

		hibernateDAO.create(department);
	}

	@Override
	public void update(Department currentDepartment) {

		hibernateDAO.update(currentDepartment);
	}

	@Override
	public void remove(Department department) {
		
		hibernateDAO.delete(department);
	}

}
