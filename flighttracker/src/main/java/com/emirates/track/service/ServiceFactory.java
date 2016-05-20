package com.emirates.track.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceFactory {
	@Autowired
	public static FlightService getFlightService(){
		FlightService flightService = new FlightServiceImpl();
		return flightService;
	}

}
