package com.entity;


import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Voyage implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private String direction; 
	private float priceByKg;
	private String date;
	private String typeTravaller;  
	private int kgAvailable;
	private String comment;
	private String phoneNumber;
	private String email;
	private String fullName;
	private String departures;
	private String arrivals;
	
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "voyage", cascade = CascadeType.ALL )
	private List<Reservation> reservations;
	
	
	
	public Voyage(String direction, float priceByKg, String date, String typeTravaller, int kgAvailable,String comment,
			String phoneNumber, String email, String fullName, String departures,String arrivals) {
		super();
		this.priceByKg = priceByKg;
		this.date = date;
		this.typeTravaller = typeTravaller;
		this.kgAvailable = kgAvailable;
		this.comment = comment;
		this.phoneNumber = phoneNumber; 
		this.email = email ;  
		this.fullName = fullName;
		this.direction = direction;
		this.departures = departures;
		this.arrivals = arrivals;
	}
	
	
	public Voyage() {}
	
	public Voyage(Voyage v) {	
		this.priceByKg = v.getPriceByKg();
		this.date = v.getDate();
		this.typeTravaller = v.getTypeTravaller();
		this.kgAvailable = v.getKgAvailable();
		this.comment = v.getComment();
		this.phoneNumber = v.getPhoneNumber(); 
		this.email = v.getEmail() ;  
		this.fullName = v.getFullName();
		this.direction = v.getDirection();
		this.departures = v.getDepartures();
		this.arrivals = v.getArrivals();
	}
	
	
	
	
	public List<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}


	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public float getPriceByKg() {
		return priceByKg;
	}
	public void setPriceByKg(float priceByKg) {
		this.priceByKg = priceByKg;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTypeTravaller() {
		return typeTravaller;
	}
	public int getKgAvailable() {
		return kgAvailable;
	}
	public void setKgAvailable(int kgAvailable) {
		this.kgAvailable = kgAvailable;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFullName() {
		return fullName;
	}


	public String getDepartures() {
		return departures;
	}


	public void setDepartures(String departures) {
		this.departures = departures;
	}


	public String getArrivals() {
		return arrivals;
	}


	public void setArrivals(String arrivals) {
		this.arrivals = arrivals;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public void setTypeTravaller(String typeTravaller) {
		this.typeTravaller = typeTravaller;
	}

	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}


	@Override
	public String toString() {
		return "Voyage [direction=" + direction + ", priceByKg=" + priceByKg + ", date=" + date + ", typeTravaller=" + typeTravaller
				+ ", kgAvailable=" + kgAvailable + ", comment=" + comment + ", phoneNumber=" + phoneNumber + ", email="
				+ email + ", fullName=" + fullName + ", departures=" + departures + ", arrivals=" + arrivals + "]";
	}
	
	
	
	
	
}
