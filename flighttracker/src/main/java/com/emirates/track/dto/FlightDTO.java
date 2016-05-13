package com.emirates.track.dto;

public class FlightDTO {
	
	private String flightPrefix;
	private String flightNumber;
	public FlightDTO(String flightPrefix, String flightNumber){
		this.flightPrefix=flightPrefix;
		this.flightNumber=flightNumber;
	}
	public String getFlightPrefix() {
		return flightPrefix;
	}
	public void setFlightPrefix(String flightPrefix) {
		this.flightPrefix = flightPrefix;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	

}
