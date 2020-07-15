package com.employeeapi.model;

import java.io.Serializable;

public class JwtResponse implements Serializable{

	private static final long serialVersionUID = -8355871373008963774L;
	private final String jwttoken;

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}
