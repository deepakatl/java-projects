package com.emirates.track.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emirates.track.dto.FlightDTO;
import com.emirates.track.service.FlightService;
/**
 * Flight tracking controller file for Spring Boot MVC
 *  
 */
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
	public boolean createFlight(@RequestBody FlightDTO flight){
		
		boolean successFlag = flightService.createFlight(flight);
		return successFlag;
	}
	
	@RequestMapping("/createFlightList")
	public boolean createFlight(@RequestBody List<FlightDTO> flightList){
		
		boolean successFlag = flightService.createFlights(flightList);
		return successFlag;
	}
	
	@RequestMapping("/deleteAll")
	public boolean deleteAll(){
		boolean successFlag = flightService.deleteAll();
		return successFlag;
	}
	
	
}
