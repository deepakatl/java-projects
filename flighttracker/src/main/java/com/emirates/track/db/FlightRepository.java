package com.emirates.track.db;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FlightRepository extends CrudRepository<Flight,String>{
	List<Flight> findByFlightNumber(@Param("number") String flightNumber);
}
