package com.spring.rest.util;

import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.rest.model.Department;
import com.spring.rest.model.Employee;
import com.spring.rest.model.Entity;

/**
 * @author Rishikesh Shukla
 *
 */
@Component
public class EntityToDtoConverterUtil {

	private static ModelMapper modelMapper;

	@Autowired
	public EntityToDtoConverterUtil(ModelMapper modelMapper) {
		EntityToDtoConverterUtil.modelMapper = modelMapper;
	}

	public static <T> Object convertEntityToDto(Entity entity, Class<T> classType) {

		if (entity instanceof Employee) {
			return modelMapper.map((Employee) entity, classType);

		} else if (entity instanceof Department) {
			return modelMapper.map((Department) entity, classType);
		} else {
			return null;
		}
	}

	/*
	 * @SuppressWarnings("unchecked") public static <T> List<T>
	 * convertEntityCollectionToDtoCollection(List<Entity> entityCollection,
	 * Class<T> classType) {
	 * 
	 * java.lang.reflect.Type targetListType = new TypeToken<List<T>>() {
	 * }.getType();
	 * 
	 * if (!entityCollection.isEmpty()) { Entity entity =
	 * entityCollection.get(Constants.ZERO_INDEX);
	 * 
	 * if (entity instanceof Employee) { return
	 * modelMapper.map(entityCollection, targetListType); } else if (entity
	 * instanceof Department) { return modelMapper.map(entityCollection,
	 * targetListType); } else { return Collections.EMPTY_LIST; } } else {
	 * 
	 * return Collections.EMPTY_LIST; } }
	 */

	@SuppressWarnings("unchecked")
	public static <T> List<T> convertEmployeeEntityCollectionToDtoCollection(List<Employee> entityCollection,
			Class<T> classType) {

		java.lang.reflect.Type targetListType = new TypeToken<List<T>>() {}.getType();

		if (!entityCollection.isEmpty()) {
			return modelMapper.map(entityCollection, targetListType);
		} else {
			return Collections.EMPTY_LIST;
		}
	}

	
	@SuppressWarnings("unchecked")
	public static <T> List<T> convertDepartmentEntityCollectionToDtoCollection(List<Department> entityCollection,
			Class<T> classType) {

		java.lang.reflect.Type targetListType = new TypeToken<List<T>>() {}.getType();

		if (!entityCollection.isEmpty()) {
			return modelMapper.map(entityCollection, targetListType);
		} else {
			return Collections.EMPTY_LIST;
		}
	}
}
