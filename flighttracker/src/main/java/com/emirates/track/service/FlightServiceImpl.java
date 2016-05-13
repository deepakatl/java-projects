package com.emirates.track.service;

import org.springframework.stereotype.Service;

import com.emirates.track.dto.FlightDTO;


@Service

public class FlightServiceImpl implements FlightService{

	public FlightDTO getFlightInfo(){
		
		//return "{\"flightPrefix\":\"EK\",\"flightNumber\":\"3545\"}";
		return new FlightDTO("EK","0522");
	}

}
