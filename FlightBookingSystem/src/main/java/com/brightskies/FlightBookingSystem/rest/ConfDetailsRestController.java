package com.brightskies.FlightBookingSystem.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfDetailsRestController {
	
	//property injections for postgres url,username,password
	
	@Value("${spring.datasource.url}")
	private String url;
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	@GetMapping("/postgresinfo")
	public String getPostgresInfo() {
		return "url " + url + "username " + username + "password " + password;
	}
	
	@GetMapping("/conf")
	public String sayHello() {
		return "Time on server is:" + LocalDateTime.now();
	}
}
