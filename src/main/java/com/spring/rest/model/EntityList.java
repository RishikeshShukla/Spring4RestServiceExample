package com.spring.rest.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * @author Rishikesh Shukla
 *
 * @param <T>
 */
@XmlRootElement(name = "company")
@XmlSeeAlso({Department.class,Employee.class,Address.class})
public class EntityList<T> {

	private List<T> listOfEntityObjects;

	
	public EntityList() {
		listOfEntityObjects = new ArrayList<T>();
	}

	/**
	 * 
	 * @param listOfEntityObjects
	 */
	public EntityList(List<T> listOfEntityObjects) {
		this.listOfEntityObjects = listOfEntityObjects;
	}

	@XmlAnyElement
	public List<T> getItems() {
		return listOfEntityObjects;
	}
}
