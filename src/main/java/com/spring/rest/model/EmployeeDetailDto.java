package com.spring.rest.model;

import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
public class EmployeeDetailDto {

	private long id;
	private Department department;
	private String emailId;
	private String firstName;
	private String lastName;
	private Integer age;
	private Long salary; 	 	
	private Set<Address> addresses;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public Set<Address> getAddresses() {
		return addresses;
	}
	
	@XmlElementWrapper(name = "addresses")
	@XmlElement(name = "address")
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	
	
	
}
