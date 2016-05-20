package com.emirates.track.db;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Flight {
	
	private String flightPrefix;
	private String flightNumber;
	
	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	
	public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
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
	
	@Override
	public String toString() {
		String flight = this.flightPrefix + this.flightNumber;
		return flight;
	}
	

}
