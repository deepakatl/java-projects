package com.emirates.track.db;

import org.springframework.stereotype.Repository;

import com.emirates.track.dto.FlightDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@Repository
public class FlightDAO implements ApplicationListener<ContextRefreshedEvent>{
	@Autowired
	private  JdbcTemplate jdbcTemplate;
    

	public List<FlightDTO> getFlights(){
		return jdbcTemplate.query("SELECT * FROM flights ", flightMapper);
	}
	
	public int createFlight(FlightDTO flight){
		int successFlag = jdbcTemplate.update("INSERT INTO flights(prefix,number) values(?,?)",flight.getFlightPrefix(), flight.getFlightNumber());
		return successFlag;
	}
	
	public void deleteAll(){
		jdbcTemplate.update("DELETE FROM FLIGHTS");
	}
	
	private static final RowMapper<FlightDTO> flightMapper = new RowMapper<FlightDTO>() {
        public FlightDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        	String prefix = rs.getString("prefix");
        	String number = rs.getString("number");
        	FlightDTO flight = new FlightDTO(prefix,number);
        	
            return flight;
        }
    };

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		try{
			jdbcTemplate.execute("create table flights (id integer generated always as identity constraint pkId primary key, prefix varchar(255), number varchar(255))");
			System.out.println("Table flights created");
		}catch(Exception e){
			System.out.println("table flights already exist");
		}		
	}
}
