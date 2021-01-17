package com.entity;

import java.io.Serializable;

public class GenericResponse implements Serializable{

	
	private static final long serialVersionUID = 1L;

	private boolean result;
	private String message;
	
	public GenericResponse(boolean result, String message) {
		super();
		this.result = result;
		this.message = message;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
