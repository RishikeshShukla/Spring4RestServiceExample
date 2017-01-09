package com.spring.rest.generic.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.rest.exception.CreateObjectException;
import com.spring.rest.exception.DeleteObjectException;
import com.spring.rest.exception.ObjectNotFoundException;
import com.spring.rest.exception.UpdateObjectException;
import com.spring.rest.model.Entity;
import com.spring.rest.util.Constants;

/**
 * @author Rishikesh Shukla
 * 
 *         class to give body to GenericDAO methods
 */

@Component
public class GenericHibernateDAO implements GenericDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.openSession();
	}

	@Override
	public Entity findById(long id, Class<?> persistentClass) {
		try {
			return (Entity) getSession().get(persistentClass, id);

		} catch (HibernateException ex) {
			throw new ObjectNotFoundException(Constants.UNABLE_TO_PERFORM_OPERATION, ex);
		}
	}

	@Override
	public Entity findByEmail(String email, Class<?> persistentClass) {
		try {
			Query findByEmailQry = getSession().createQuery(
					"from " + persistentClass.getSimpleName()
							+ " where emailId = :email");
			findByEmailQry.setString("email", email);
			return (Entity) findByEmailQry.uniqueResult();

		} catch (HibernateException ex) {
			throw new ObjectNotFoundException(Constants.UNABLE_TO_PERFORM_OPERATION, ex);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<? extends Entity> findAll(Class<?> persistentClass) {
		try {
			Query findAllQuery = getSession().createQuery(
					"from " + persistentClass.getSimpleName());
			return findAllQuery.list();
		} catch (HibernateException ex) {
			throw new ObjectNotFoundException(Constants.UNABLE_TO_PERFORM_OPERATION, ex);
		}
	}

	@Override
	public Entity create(Entity entity) {
		try {
			getSession().save(entity);
			return entity;
		} catch (HibernateException ex) {
			throw new CreateObjectException(Constants.UNABLE_TO_PERFORM_OPERATION, ex);
		}

	}

	@Override
	public void update(Entity entity) {
		try {
			getSession().update(entity);
		} catch (HibernateException ex) {
			throw new UpdateObjectException(Constants.UNABLE_TO_PERFORM_OPERATION, ex);
		}
		

	}

	@Override
	public void delete(Class<?> persistentClass, long id) {
		try {
			getSession().delete(findById(id, persistentClass));
		} catch (HibernateException ex) {
			throw new DeleteObjectException(Constants.UNABLE_TO_PERFORM_OPERATION, ex);
		}
		

	}

	@Override
	public void delete(Entity entity) {
		try {
			getSession().delete(entity);
		} catch (HibernateException ex) {
			throw new DeleteObjectException(Constants.UNABLE_TO_PERFORM_OPERATION, ex);
		}

	}

}
