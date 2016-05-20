package com.emirates.track.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emirates.track.dto.FlightDTO;
import com.emirates.track.service.FlightService;

@RestController
public class FlightTrackerController {

	@Autowired
	private FlightService flightService;
	@RequestMapping("/listFlight")
	public List<FlightDTO> getFlight(){
		
		List<FlightDTO> flightList = flightService.getFlightInfo();
		return flightList;
	}
	
	@RequestMapping("/createFlight")
	public void createFlight(@RequestBody FlightDTO flight){
		
		flightService.createFlight(flight);
	}
	
	@RequestMapping("/createFlightList")
	public void createFlight(@RequestBody List<FlightDTO> flightList){
		
		flightService.createFlights(flightList);
	}
	
	@RequestMapping("/deleteAll")
	public void deleteAll(){
		flightService.deleteAll();
	}
	
	
}
