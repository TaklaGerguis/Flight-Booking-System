package com.brightskies.FlightBookingSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flight")
public class Flight {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="departure_city")
	private String departureCity;
	
	@Column(name="arrival_city")
	private String arrivalCity;
	
	
	@Column(name="departure_date")
	private String departureDate;
	
	@Column(name="arrival_date")
	private String arrivalDate;
	
	@Column(name="buissness_class_fare")
	private String buissnessClassFare;
	
	@Column(name="economic_class_fare")
	private String economicClassFare;
	
	public Flight() {
		
	}
	
	public Flight(String departureCity, String arrivalCity, String departureDate,
			 String arrivalDate, String buissnessClassFare, String economicClassFare) {
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.buissnessClassFare = buissnessClassFare;
		this.economicClassFare = economicClassFare;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getBuissnessClassFare() {
		return buissnessClassFare;
	}

	public void setBuissnessClassFare(String buissnessClassFare) {
		this.buissnessClassFare = buissnessClassFare;
	}

	public String getEconomicClassFare() {
		return economicClassFare;
	}

	public void setEconomicClassFare(String economicClassFare) {
		this.economicClassFare = economicClassFare;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", departureCity=" + departureCity + ", arrivalCity=" + arrivalCity
				+ ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate + ", buissnessClassFare="
				+ buissnessClassFare + ", economicClassFare=" + economicClassFare + "]";
	}


		
}
