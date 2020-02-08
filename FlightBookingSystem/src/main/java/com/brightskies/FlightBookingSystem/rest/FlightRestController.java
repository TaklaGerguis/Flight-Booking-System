package com.brightskies.FlightBookingSystem.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brightskies.FlightBookingSystem.entity.Flight;
import com.brightskies.FlightBookingSystem.service.FlightService;


@RestController
@RequestMapping("/api")
public class FlightRestController {

	private FlightService flightService;
	
	@Autowired
	public FlightRestController(FlightService theFlightService) {
		flightService = theFlightService;
	}
	
	@GetMapping("/flights")
	public List<Flight> findAll() {
		return flightService.findAll();
	}

	@GetMapping("/flights/{id}")
	public Flight getFlight(@PathVariable int id) {
		
		Flight theFlight = flightService.findById(id);
		
		if (theFlight == null) {
			throw new RuntimeException("Flight id not found - " + id);
		}
		
		return theFlight;
	}
	
	@GetMapping("/flights/{departureCity}/{arrivalCity}")
	public List<Flight> getFlight(@PathVariable String departureCity, @PathVariable String arrivalCity) {
		
		List<Flight> theFlight = flightService.findByDepAndArr(departureCity, arrivalCity);
		
		if (theFlight == null) {
			throw new RuntimeException("Flight id not found - " + departureCity + arrivalCity);
		}
		
		return theFlight;
	}
	
	@PostMapping("/flights")
	public Flight addFlight(@RequestBody Flight theFlight) {	
		
		theFlight.setId(0);
		
		flightService.save(theFlight);
		
		return theFlight;
	}
	
	@PutMapping("/flights")
	public Flight updateFlight(@RequestBody Flight theFlight) {
		
		flightService.save(theFlight);
		
		return theFlight;
	}
	
	@DeleteMapping("/flights/{id}")
	public String deleteFlight(@PathVariable int flightId) {
		
		Flight tempFlight = flightService.findById(flightId);
		
		
		if (tempFlight == null) {
			throw new RuntimeException("Flight id not found - " + flightId);
		}
		
		flightService.deleteById(flightId);
		
		return "Deleted flight id - " + flightId;
	}
	
}