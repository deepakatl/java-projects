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
		}
		return flightList;
	}
	
	public boolean createFlight(FlightDTO flightDto){
		boolean successFlag = false;
		int success = flightDAO.createFlight(flightDto);
		if(success == 1){
			successFlag = true;
		}
		return successFlag;
	}

	@Override
	public boolean deleteAll() {
		boolean successFlag = false;
		int success = flightDAO.deleteAll();
		if(success == 1){
			successFlag = true;
		}
		return successFlag;
		
	}

	@Override
	public boolean createFlights(List<FlightDTO> flightDtoList) {
		boolean successFlag = false;
		int success = flightDAO.createFlights(flightDtoList);
		if(success == 1){
			successFlag = true;
		}
		return successFlag;
	}
		
	
}
