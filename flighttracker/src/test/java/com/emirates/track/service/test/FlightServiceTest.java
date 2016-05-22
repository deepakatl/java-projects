package com.emirates.track.service.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.emirates.track.db.FlightDAO;
import com.emirates.track.dto.FlightDTO;
import com.emirates.track.service.FlightService;
import com.emirates.track.service.FlightServiceImpl;


public class FlightServiceTest {
	
	
	private @Mock FlightDAO flightDAO;
	private @InjectMocks FlightService flightService = new FlightServiceImpl();
	
	private List<FlightDTO> flightList;
	private FlightDTO flightDTO;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		flightList = new ArrayList<FlightDTO>();
		flightDTO = new FlightDTO("EK", "0522");
		flightList.add(flightDTO);
	}
	
	@Test
	public void testGetFlightInfoForNotNull(){
		when(flightDAO.getFlights()).thenReturn(flightList);
		List<FlightDTO> resultList = flightService.getFlightInfo();
		assertNotNull(resultList);
	}
	
	@Test
	public void testCreateFlightSuccess(){
		when(flightDAO.createFlight(flightDTO)).thenReturn(1);
		boolean successFlag = flightService.createFlight(flightDTO);
		assertTrue(successFlag);
	}
	
	@Test
	public void testCreateFlightFailure(){
		when(flightDAO.createFlight(flightDTO)).thenReturn(0);
		boolean successFlag = flightService.createFlight(flightDTO);
		assertFalse(successFlag);
	}

}
