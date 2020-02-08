package com.brightskies.FlightBookingSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brightskies.FlightBookingSystem.entity.Flight;
import com.brightskies.FlightBookingSystem.DAO.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

	private FlightRepository flightRepository;
	
	@Autowired
	public FlightServiceImpl(FlightRepository theFlightRepository) {
		flightRepository = theFlightRepository;
		}
		
	@Override
	public List<Flight> findAll() {
		return flightRepository.findAll();
	}

	@Override
	public Flight findById(int theId) {
		
		Optional<Flight> result = flightRepository.findById(theId);
		
		Flight theFlight = null;
		
		if (result.isPresent()) {
			theFlight = result.get();
		}
		else {

			throw new RuntimeException("Did not find flight id - " + theId);
		}
		
		return theFlight;
	}
	
	public List<Flight> findByDepAndArr(String departureCity,String arrivalCity) {
	
		return flightRepository.findAll();
		
	}

	@Override
	public void save(Flight theFlight) {
		
		flightRepository.save(theFlight);
	}

	@Override
	public void deleteById(int theId) {

		flightRepository.deleteById(theId);

	}

}
