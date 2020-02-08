package com.brightskies.FlightBookingSystem.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brightskies.FlightBookingSystem.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
