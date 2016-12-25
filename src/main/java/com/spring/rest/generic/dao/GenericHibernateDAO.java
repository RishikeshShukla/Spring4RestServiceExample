package com.spring.rest.generic.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.rest.model.Entity;

@Component
public class GenericHibernateDAO implements GenericDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Entity findById(long id, Class<?> persistentClass) {

		return (Entity) getSession().get(persistentClass, id);
	}

	@Override
	public Entity findByEmail(String email, Class<?> persistentClass) {

		return (Entity) getSession().get(email, persistentClass);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<? extends Entity> findAll(Class<?> persistentClass) {

		Query findAllQuery = getSession().createQuery("select * from " + persistentClass.getSimpleName());
		return findAllQuery.list();
	}

	@Override
	public Entity create(Entity entity) {
		getSession().save(entity);
		return entity;
	}

	@Override
	public void update(Entity entity) {
		getSession().update(entity);

	}

	@Override
	public void delete(Class<?> persistentClass, long id) {
		getSession().delete((findById(id, persistentClass)));

	}

	@Override
	public void delete(Entity entity) {
		getSession().delete(entity);
		
	}

}
