package com.forJson;


public class LoggedUser {
	private String token;
	private String surname;
	private String lastname;
	
	public LoggedUser( ) {
	}
	
	public LoggedUser(String token, String surname, String lastname) {
		super();
		this.token = token;
		this.surname = surname;
		this.lastname = lastname;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "{token:" + token + ", surname:" + surname + ", lastname:" + lastname + "}";
	}
	
	
}
