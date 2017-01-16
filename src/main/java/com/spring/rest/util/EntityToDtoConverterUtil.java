package com.spring.rest.util;

import java.util.Collection;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.rest.model.Department;
import com.spring.rest.model.Employee;
import com.spring.rest.model.EmployeeDetailDto;
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

	/*public static <T> Collection<T> convertEntityCollectionToDtoCollection(Collection<T> entityCollection,
			Class<T> classType) {

		if(entityCollection instanceof Employee){
			
			return modelMapper.map(entityCollection,classType);
		}else if(entityCollection instanceof Department){
			return null;
		}else{
			return null;
		}
	
	}*/

}
