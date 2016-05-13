package com.emirates.track.db;

import org.springframework.stereotype.Repository;

import com.emirates.track.dto.FlightDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@Repository
public class FlightDAO {
	@Autowired
	private  JdbcTemplate jdbcTemplate;
    
	public List<FlightDTO> getFlights(){
		return jdbcTemplate.query("SELECT * FROM sb_user ", flightMapper);
	}
	private static final RowMapper<FlightDTO> flightMapper = new RowMapper<FlightDTO>() {
        public FlightDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        	FlightDTO flight = new FlightDTO("EK","3455");
        	
            return flight;
        }
    };
}
