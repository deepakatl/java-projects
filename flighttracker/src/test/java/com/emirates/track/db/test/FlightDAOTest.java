package com.emirates.track.db.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.when;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.emirates.track.dto.FlightDTO;

public class FlightDAOTest<T> {
	
	private @Mock JdbcTemplate jdbcTemplate;
	
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
	public void testGetFlightsSuccess(){
		
		//when(jdbcTemplate.queryForList(anyString()).thenReturn(flightList));
		
	}

}
