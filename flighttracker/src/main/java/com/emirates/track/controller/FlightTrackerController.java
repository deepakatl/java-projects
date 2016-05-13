package com.emirates.track.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emirates.track.dto.FlightDTO;
import com.emirates.track.service.FlightService;
import com.emirates.track.service.FlightServiceImpl;
import com.emirates.track.service.ServiceFactory;

@RestController
public class FlightTrackerController {

	@RequestMapping("/flight")
	public List<FlightDTO> getFlight(){
		List<FlightDTO> flightList = new ArrayList<FlightDTO>();
		/*flightList.add(new FlightDTO("EK", "0522"));
		flightList.add(new FlightDTO("EK", "0456"));
		flightList.add(new FlightDTO("EK", "0458"));
		flightList.add(new FlightDTO("EK", "0458"));
		flightList.add(new FlightDTO("EK", "0458"));*/
		FlightService flightService =ServiceFactory.getFlightService();
		FlightDTO flightDTO = flightService.getFlightInfo();
		flightList.add(flightDTO);
		return flightList;
	}
	
}
