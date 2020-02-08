package com.brightskies.FlightBookingSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reservation")
public class Reservation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="flightID")
	private int flightID;
	
	@Column(name="flight_class")
	private String flightClass;
	
	@Column(name="customerID")
	private int customerID;
	
	
	public Reservation() {
		
	}

	public Reservation(int flightID, String flightClass, int customerID, String fare) {
		this.flightID = flightID;
		this.flightClass = flightClass;
		this.customerID = customerID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFlightID() {
		return flightID;
	}

	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}


	@Override
	public String toString() {
		return "Reservation [id=" + id + ", flightID=" + flightID + ", flightClass="
				+ flightClass + ", customerID=" + customerID + "]";
	}
		
}
