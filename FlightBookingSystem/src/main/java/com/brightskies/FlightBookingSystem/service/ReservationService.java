package com.brightskies.FlightBookingSystem.service;
import java.util.List;

import com.brightskies.FlightBookingSystem.entity.Reservation;

public interface ReservationService {

	public List<Reservation> findAll();
	
	public Reservation findById(int theId);
	
	public void save(Reservation theAirport);
	
	public void deleteById(int theId);
}
