package com.spring.rest.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * @author Rishikesh Shukla
 *
 * @param <T>
 */
@XmlRootElement(name = "employees")
@XmlSeeAlso({EmployeeDetailDto.class})
public class DtoResponse<T> {
	//@XmlElement(name = "elist")
	private List<T> listOfEntityObjects ;
	

	public DtoResponse() {
		
	}
	
	public DtoResponse(List<T> list) {
		System.out.println(list.size());
		this.setListOfEntityObjects(list);
	}

	
	public boolean isEmpty(){
		return this.listOfEntityObjects.isEmpty();
	}

	/**
	 * @return the listOfEntityObjects
	 */
	public List<T> getListOfEntityObjects() {
		return listOfEntityObjects;
	}

	/**
	 * @param listOfEntityObjects the listOfEntityObjects to set
	 */
	public void setListOfEntityObjects(List<T> listOfEntityObjects) {
		this.listOfEntityObjects = listOfEntityObjects;
	}

	
}
