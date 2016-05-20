package com.emirates.track.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emirates.track.db.FlightDAO;
import com.emirates.track.dto.FlightDTO;


@Service

public class FlightServiceImpl implements FlightService{

	@Autowired
	private FlightDAO flightDAO;
	
		
	public List<FlightDTO> getFlightInfo(){
		
		List<FlightDTO> flightList = null;
		if(flightDAO != null){
			flightList = flightDAO.getFlights();
			System.out.println(flightList);
		}
		return flightList;
	}
	
	public void createFlight(FlightDTO flightDto){
		flightDAO.createFlight(flightDto);
	}

	@Override
	public void deleteAll() {
		flightDAO.deleteAll();
		
	}

	@Override
	public void createFlights(List<FlightDTO> flightDtoList) {
		for(FlightDTO flightDto : flightDtoList){
			createFlight(flightDto);
		}
		
	}

	
}
