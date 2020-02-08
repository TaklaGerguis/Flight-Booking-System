package com.brightskies.FlightBookingSystem.DAO;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.brightskies.FlightBookingSystem.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer>{

	List<Flight> findByDepartureCityAndArrivalCity(final String departureCity,final String arrivalCity);

}
