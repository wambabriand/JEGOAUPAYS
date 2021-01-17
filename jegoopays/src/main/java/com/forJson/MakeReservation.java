package com.forJson;

import java.io.Serializable;

public class MakeReservation implements Serializable{

	private static final long serialVersionUID = 1L;

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
	
	
	private Long idVoyage; // we can use relation OneToMany
	
	
	
	
	
	
	public MakeReservation(MakeReservation m) {
		super();
		this.departCity = m.getDepartCity();
		this.arrivalCity = m.getArrivalCity();
		this.numberKg = m.getNumberKg();
		this.paymentMode = m.getPaymentMode();
		this.coliDescription = m.getColiDescription();
		this.fullNameSen = m.getFullNameSen();
		this.phoneNumSen = m.getPhoneNumSen();
		this.emailSen = m.getEmailSen();
		this.fullNameRec = m.getFullNameRec();
		this.phoneNumRec = m.getPhoneNumRec();
		this.emailRec = m.getEmailRec();
		this.idVoyage = m.getIdVoyage();
	}
	
	public MakeReservation(String departCity, String arrivalCity, float numberKg, String paymentMode,
			String coliDescription, String fullNameSen, String phoneNumSen, String emailSen, String fullNameRec,
			String phoneNumRec, String emailRec, Long idVoyage) {
		super();
		this.departCity = departCity;
		this.arrivalCity = arrivalCity;
		this.numberKg = numberKg;
		this.paymentMode = paymentMode;
		this.coliDescription = coliDescription;
		this.fullNameSen = fullNameSen;
		this.phoneNumSen = phoneNumSen;
		this.emailSen = emailSen;
		this.fullNameRec = fullNameRec;
		this.phoneNumRec = phoneNumRec;
		this.emailRec = emailRec;
		this.idVoyage  = idVoyage;
	}



	public String getDepartCity() {
		return departCity;
	}



	public void setDepartCity(String departCity) {
		this.departCity = departCity;
	}


	public Long getIdVoyage() {
		return idVoyage;
	}

	public void setIdVoyage(Long idVoyage) {
		this.idVoyage = idVoyage;
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



	@Override
	public String toString() {
		return "MakeReservation [departCity=" + departCity + ", arrivalCity=" + arrivalCity + ", numberKg=" + numberKg
				+ ", paymentMode=" + paymentMode + ", coliDescription=" + coliDescription + ", fullNameSen="
				+ fullNameSen + ", phoneNumSen=" + phoneNumSen + ", emailSen=" + emailSen + ", fullNameRec="
				+ fullNameRec + ", phoneNumRec=" + phoneNumRec + ", emailRec=" + emailRec + "]";
	}
	
	
	
}
