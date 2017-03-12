package com.lastminute.flights.searchs.POJO;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents all airports
 * @author JLHM
 *
 */
public class AirportsDummy {
	private List<Airport> airport;
	
	public AirportsDummy() {
		this.setAirport(new ArrayList<Airport>());
		
		Airport airport = new Airport();
		airport.setIataCode("MAD");
		airport.setCity("Madrid");
		this.add(airport);
		
		airport = new Airport();
		airport.setIataCode("BCN");
		airport.setCity("Barcelona");
		this.add(airport);
		
		airport = new Airport();
		airport.setIataCode("LHR");
		airport.setCity("London");
		this.add(airport);

		airport = new Airport();
		airport.setIataCode("CDG");
		airport.setCity("Paris");
		this.add(airport);

		airport = new Airport();
		airport.setIataCode("FRA");
		airport.setCity("Frakfurt");
		this.add(airport);

		airport = new Airport();
		airport.setIataCode("IST");
		airport.setCity("Istanbul");
		this.add(airport);

		airport = new Airport();
		airport.setIataCode("AMS");
		airport.setCity("Amsterdam");
		this.add(airport);

		airport = new Airport();
		airport.setIataCode("FCO");
		airport.setCity("Rome");
		this.add(airport);

		airport = new Airport();
		airport.setIataCode("CPH");
		airport.setCity("Copenhagen");
		this.add(airport);
		
	}

	public void add(Airport airport){
		
		this.airport.add(airport);
	}


	public List<Airport> getAirport() {
		return airport;
	}


	public void setAirport(List<Airport> airport) {
		this.airport = airport;
	}
	
}
