package com.emirates.track.controller.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.emirates.track.controller.FlightTrackerController;
import com.emirates.track.dto.FlightDTO;
import com.emirates.track.service.FlightService;

public class FlightTrackerControllerTest {
	
	private @Mock FlightService flightService;
	private @InjectMocks FlightTrackerController flightController;
	
	private List<FlightDTO> flightList;
	private FlightDTO flightDTO;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		flightList = new ArrayList<FlightDTO>();
		flightDTO = new FlightDTO("EK", "0522");
		flightList.add(flightDTO);
		flightList.add(new FlightDTO("EK", "0523"));
	}
	
	@Test
	public void testGetFlight(){
		when(flightService.getFlightInfo()).thenReturn(flightList);
		List<FlightDTO> resultList = flightController.getFlight();
		assertNotNull(resultList);
	}
	
	@Test
	public void testCreateFlightSuccess(){
		when(flightService.createFlight(flightDTO)).thenReturn(true);
		boolean successFlag = flightController.createFlight(flightDTO);
		assertTrue(successFlag);
	}
	
	@Test
	public void testCreateFlightFailure(){
		when(flightService.createFlight(flightDTO)).thenReturn(false);
		boolean successFlag = flightController.createFlight(flightDTO);
		assertFalse(successFlag);
	}
	@Test
	public void testCreateFlightsSuccess(){
		when(flightService.createFlights(flightList)).thenReturn(true);
		boolean successFlag = flightController.createFlight(flightList);
		assertTrue(successFlag);
	}
	@Test
	public void testCreateFlightsfailure(){
		when(flightService.createFlights(flightList)).thenReturn(false);
		boolean successFlag = flightController.createFlight(flightList);
		assertFalse(successFlag);
	}
	@Test
	public void testDeleteAllFlightSuccess(){
		when(flightService.deleteAll()).thenReturn(true);
		boolean successFlag = flightController.deleteAll();
		assertTrue(successFlag);
	}
	@Test
	public void testDeleteAllFlightFailure(){
		when(flightService.deleteAll()).thenReturn(false);
		boolean successFlag = flightController.deleteAll();
		assertFalse(successFlag);
	}

}
