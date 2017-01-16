package com.spring.rest.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name = "department", catalog = "spring_rest_app")
public class Department implements com.spring.rest.model.Entity  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5355618840148981922L;

	private long id;
	private String name;
	private String location;
	private Set<Employee> employees = new HashSet<Employee>(0);

	public Department() {
	}

	public Department(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Department(long id, String name, String location,
			Set<Employee> employees) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.employees = employees;
	}

	@Id
	@Column(name = "id", nullable = false, unique = true)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name= "name", nullable=false, length=45)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="location", nullable=false, length=45)
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(fetch=FetchType.LAZY, mappedBy="department")
	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}
