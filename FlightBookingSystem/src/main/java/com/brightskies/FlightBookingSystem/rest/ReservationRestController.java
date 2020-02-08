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

import com.brightskies.FlightBookingSystem.entity.Reservation;
import com.brightskies.FlightBookingSystem.service.ReservationService;


@RestController
@RequestMapping("/api")
public class ReservationRestController {

	private ReservationService reservationService;
	
	@Autowired
	public ReservationRestController(ReservationService theReservationService) {
		reservationService = theReservationService;
	}
	
	@GetMapping("/reservations")
	public List<Reservation> findAll() {
		return reservationService.findAll();
	}

	
	@GetMapping("/reservations/{id}")
	public Reservation getAirport(@PathVariable int id) {
		
		Reservation theReservation = reservationService.findById(id);
		
		if (theReservation == null) {
			throw new RuntimeException("Reservation id not found - " + id);
		}
		
		return theReservation;
	}

	
	@PostMapping("/reservations")
	public Reservation addReservation(@RequestBody Reservation theReservation) {	
		
		theReservation.setId(0);
		
		reservationService.save(theReservation);
		
		return theReservation;
	}
	
	@PutMapping("/reservations")
	public Reservation updateReservation(@RequestBody Reservation theReservation) {
		
		reservationService.save(theReservation);
		
		return theReservation;
	}

	
	@DeleteMapping("/reservations/{id}")
	public String deleteReservation(@PathVariable int reservationId) {
		
		Reservation tempReservation = reservationService.findById(reservationId);
		
		
		if (tempReservation == null) {
			throw new RuntimeException("Airport id not found - " + reservationId);
		}
		
		reservationService.deleteById(reservationId);
		
		return "Deleted reservation id - " + reservationId;
	}
	
}