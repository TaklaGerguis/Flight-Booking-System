package com.brightskies.FlightBookingSystem.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brightskies.FlightBookingSystem.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
