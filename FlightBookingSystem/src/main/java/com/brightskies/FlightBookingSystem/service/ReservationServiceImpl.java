package com.brightskies.FlightBookingSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brightskies.FlightBookingSystem.entity.Reservation;
import com.brightskies.FlightBookingSystem.DAO.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

	private ReservationRepository reservationRepository;
	
	@Autowired
	public ReservationServiceImpl(ReservationRepository theReservationRepository) {
		reservationRepository = theReservationRepository;
		}
		
	@Override
	public List<Reservation> findAll() {
		return reservationRepository.findAll();
	}

	@Override
	public Reservation findById(int theId) {
		
		Optional<Reservation> result = reservationRepository.findById(theId);
		
		Reservation theReservation = null;
		
		if (result.isPresent()) {
			theReservation = result.get();
		}
		else {

			throw new RuntimeException("Did not find reservation id - " + theId);
		}
		
		return theReservation;
	}

	@Override
	public void save(Reservation theReservation) {
		
		reservationRepository.save(theReservation);
	}

	@Override
	public void deleteById(int theId) {

		reservationRepository.deleteById(theId);

	}

}
