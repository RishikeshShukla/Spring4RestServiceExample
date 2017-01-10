package com.spring.rest.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@XmlRootElement(name = "employee")
@Entity
@Table(name = "employee", catalog = "spring_rest_app", uniqueConstraints = @UniqueConstraint(columnNames = "email_id"))
public class Employee implements com.spring.rest.model.Entity  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4703854654923119723L;

	private long id;
	private Department department;
	private String emailId;
	private String firstName;
	private String lastName;
	private Integer age;
	private Long salary;
	private Set<Address> addresses = new HashSet<Address>(0);

	public Employee() {
	}

	public Employee(long id, int age , String emailId,
			String firstName) {
		this.id = id;
		this.age = age;
		this.emailId = emailId;
		this.firstName = firstName;
	}

	public Employee(long id, Department department, String emailId,
			String firstName, String lastName, Integer age, Long salary,
			Set<Address> addresses) {
		this.id = id;
		this.department = department;
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.salary = salary;
		this.addresses = addresses;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id", nullable = true)
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Column(name = "email_id", unique = true, nullable = false, length = 45)
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name = "first_name", nullable = false, length = 45)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", length = 45)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "age")
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "salary", precision = 10, scale = 0)
	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	@XmlElement(name = "address")
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

}
