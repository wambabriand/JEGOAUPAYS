package com.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.forJson.MakeReservation;




@Entity
public class Reservation implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private boolean confirm;
	private String nameAdmin;
	
	private String departCity;
	private String arrivalCity; 
	private float numberKg;
	private String paymentMode;
	private String coliDescription;
	private String fullNameSen;
	private String phoneNumSen;
	private String emailSen;
	private String fullNameRec;
	private String phoneNumRec;
	private String emailRec;
	
	@ManyToOne( fetch = FetchType.EAGER)
	@JoinColumn(name ="idVoyage", nullable = false)
	private Voyage voyage;
	
	
	
	public Reservation(MakeReservation r, Voyage voyage) {
		super();
		this.confirm = false;
		this.nameAdmin = null;
		this.departCity = r.getDepartCity();
		this.arrivalCity = r.getArrivalCity();
		this.numberKg = r.getNumberKg();
		this.paymentMode = r.getPaymentMode();
		this.coliDescription = r.getColiDescription();
		this.fullNameSen = r.getFullNameSen();
		this.phoneNumSen = r.getPhoneNumSen();
		this.emailSen = r.getEmailSen();
		this.fullNameRec = r.getFullNameRec();
		this.phoneNumRec = r.getPhoneNumRec();
		this.emailRec = r.getEmailRec();
		this.voyage = voyage;
	}
	

	public Reservation() {
		super();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameAdmin() {
		return nameAdmin;
	}
	

	public void setNameAdmin(String nameAdmin) {
		this.nameAdmin = nameAdmin;
	}

	public boolean isConfirm() {
		return confirm;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}

	public String getDepartCity() {
		return departCity;
	}

	public void setDepartCity(String departCity) {
		this.departCity = departCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public float getNumberKg() {
		return numberKg;
	}

	public void setNumberKg(float numberKg) {
		this.numberKg = numberKg;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getColiDescription() {
		return coliDescription;
	}

	public void setColiDescription(String coliDescription) {
		this.coliDescription = coliDescription;
	}

	public String getFullNameSen() {
		return fullNameSen;
	}

	public void setFullNameSen(String fullNameSen) {
		this.fullNameSen = fullNameSen;
	}

	public String getPhoneNumSen() {
		return phoneNumSen;
	}

	public void setPhoneNumSen(String phoneNumSen) {
		this.phoneNumSen = phoneNumSen;
	}

	public String getEmailSen() {
		return emailSen;
	}

	public void setEmailSen(String emailSen) {
		this.emailSen = emailSen;
	}

	public String getFullNameRec() {
		return fullNameRec;
	}

	public void setFullNameRec(String fullNameRec) {
		this.fullNameRec = fullNameRec;
	}

	public String getPhoneNumRec() {
		return phoneNumRec;
	}

	public void setPhoneNumRec(String phoneNumRec) {
		this.phoneNumRec = phoneNumRec;
	}

	public String getEmailRec() {
		return emailRec;
	}

	public void setEmailRec(String emailRec) {
		this.emailRec = emailRec;
	}

	public Voyage getVoyage() {
		return voyage;
	}

	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}


	@Override
	public String toString() {
		return "Reservation [id=" + id + ", confirm=" + confirm + ", nameAdmin=" + nameAdmin + ", departCity="
				+ departCity + ", arrivalCity=" + arrivalCity + ", numberKg=" + numberKg + ", paymentMode="
				+ paymentMode + ", coliDescription=" + coliDescription + ", fullNameSen=" + fullNameSen
				+ ", phoneNumSen=" + phoneNumSen + ", emailSen=" + emailSen + ", fullNameRec=" + fullNameRec
				+ ", phoneNumRec=" + phoneNumRec + ", emailRec=" + emailRec + ", voyage=" + voyage + "]";
	}
	
	
	
	
}
