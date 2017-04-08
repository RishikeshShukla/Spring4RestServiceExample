package com.spring.rest.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Rishikesh Shukla
 *
 * @param <T>
 */
@XmlRootElement(name = "employees")
public class DtoResponse_1<T> {
	@XmlElement(name = "elist")
	private List<T> list ;
	

	public DtoResponse_1() {
		
	}
	
	public DtoResponse_1(List<T> list) {
		this.list = list;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	public boolean isEmpty(){
		return this.list.isEmpty();
	}
}
