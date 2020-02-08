package com.brightskies.FlightBookingSystem.service;
import java.util.List;

import com.brightskies.FlightBookingSystem.entity.Flight;

public interface FlightService {

	public List<Flight> findAll();
	
	public Flight findById(int theId);
	
	public List<Flight> findByDepAndArr(String departureCity,String arrivalCity);
	
	public void save(Flight theFlight);
	
	public void deleteById(int theId);
}
