package com.emirates.track.service;

import java.util.List;

import com.emirates.track.dto.FlightDTO;

public interface FlightService {

	public List<FlightDTO> getFlightInfo();
	public boolean createFlight(FlightDTO flightDto);
	public boolean createFlights(List<FlightDTO> flightDtoList);
	public boolean deleteAll();
}
