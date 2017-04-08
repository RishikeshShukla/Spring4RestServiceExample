package com.spring.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address", catalog = "spring_rest_app")
public class Address implements com.spring.rest.model.Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7365367940137577453L;
	private long id;
	private Employee employee;
	private String countryName;
	private String cityName;
	private String street;
	private String pincode;
	private String addressType;

	public Address() {
	}

	public Address(long id, Employee employee, String countryName,
			String cityName, String street, String pincode, String addressType) {
		this.id = id;
		this.employee = employee;
		this.countryName = countryName;
		this.cityName = cityName;
		this.street = street;
		this.pincode = pincode;
		this.addressType = addressType;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id", nullable = false)
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Column(name = "country_name", nullable = false, length = 45)
	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Column(name = "city_name", nullable = false, length = 45)
	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Column(name = "street", nullable = false, length = 45)
	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Column(name = "pincode", nullable = false, length = 45)
	public String getPincode() {
		return this.pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Column(name = "address_type", nullable = false, length = 45)
	public String getAddressType() {
		return this.addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

}
