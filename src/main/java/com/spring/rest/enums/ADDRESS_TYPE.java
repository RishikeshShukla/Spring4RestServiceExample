package com.spring.rest.enums;

public enum ADDRESS_TYPE {

	LOCAL_ADDRESS(1, "Local Address"), 
	PERMANENT_ADDRESS(2, "Permanent Address");

	int code;
	String addressType;

	ADDRESS_TYPE(int code, String addressType) {
		this.code = code;
		this.addressType = addressType;
	}
}
