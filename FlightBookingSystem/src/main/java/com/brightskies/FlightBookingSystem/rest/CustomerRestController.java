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

import com.brightskies.FlightBookingSystem.entity.Customer;
import com.brightskies.FlightBookingSystem.service.CustomerService;


@RestController
@RequestMapping("/api")
public class CustomerRestController {

	private CustomerService customerService;
	
	@Autowired
	public CustomerRestController(CustomerService theCustomerService) {
		customerService = theCustomerService;
	}
	
	@GetMapping("/customers")
	public List<Customer> findAll() {
		return customerService.findAll();
	}

	
	@GetMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable int id) {
		
		Customer theCustomer = customerService.findById(id);
		
		if (theCustomer == null) {
			throw new RuntimeException("Customer id not found - " + id);
		}
		
		return theCustomer;
	}

	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {	
		
		theCustomer.setId(0);
		
		customerService.save(theCustomer);
		
		return theCustomer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		
		customerService.save(theCustomer);
		
		return theCustomer;
	}

	
	@DeleteMapping("/customers/{id}")
	public String deleteCustomer(@PathVariable int customerId) {
		
		Customer tempCustomer = customerService.findById(customerId);
		
		
		if (tempCustomer == null) {
			throw new RuntimeException("Customer id not found - " + customerId);
		}
		
		customerService.deleteById(customerId);
		
		return "Deleted customer id - " + customerId;
	}
	
}