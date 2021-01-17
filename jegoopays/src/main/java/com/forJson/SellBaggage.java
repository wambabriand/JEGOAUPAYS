package com.forJson;

import java.io.Serializable;



public class SellBaggage implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String email;
	private String phoneNumber;
	private String kgAvailable ;
	private String priceByKg;
	private String villesDeparture;
	private String villesArrival;
	private String date;
	private String comment;
	
	
	
	public SellBaggage(String email, String phoneNumber, String kgAvailable, String priceByKg, String villesDeparture,
			String villesArrival, String date, String comment) {
		super();
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.kgAvailable = kgAvailable;
		this.priceByKg = priceByKg;
		this.villesDeparture = villesDeparture;
		this.villesArrival = villesArrival;
		this.date = date;
		this.comment = comment;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getKgAvailable() {
		return kgAvailable;
	}
	public void setKgAvailable(String kgAvailable) {
		this.kgAvailable = kgAvailable;
	}
	public String getPriceByKg() {
		return priceByKg;
	}
	public void setPriceByKg(String priceByKg) {
		this.priceByKg = priceByKg;
	}
	public String getVillesDeparture() {
		return villesDeparture;
	}
	public void setVillesDeparture(String villesDeparture) {
		this.villesDeparture = villesDeparture;
	}
	public String getVillesArrival() {
		return villesArrival;
	}
	public void setVillesArrival(String villesArrival) {
		this.villesArrival = villesArrival;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
