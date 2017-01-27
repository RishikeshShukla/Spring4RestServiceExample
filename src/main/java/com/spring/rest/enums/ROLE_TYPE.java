package com.spring.rest.enums;

/**
 * @author Rishikesh Shukla
 *
 */
public enum ROLE_TYPE {

	ADMINSTRATOR(1,"Administrator"),
	MANAGER(2,"Manager"),
	EMPLOYEE(3,"Employee");
		
	int code;
	String roleType;
	
	ROLE_TYPE(int code, String roleType){
		this.code = code;
		this.roleType = roleType;
	}
}
