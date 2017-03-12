package com.lastminute.flights.searchs.POJO;

import java.util.ArrayList;
import java.util.List;

public class FlightsDummy {
	
	private List<Flight> flights;

	public FlightsDummy() {
		this.setFlights(new ArrayList<Flight>());
		
		Flight flight = new Flight();
		flight.setOriginAirport("AMS");
		flight.setDestAirport("FRA");
		flight.setAirline("TK2372");
		flight.setBasePrice(197);
		this.add(flight);
		
		flight = new Flight();
		flight.setOriginAirport("AMS");
		flight.setDestAirport("FRA");
		flight.setAirline("TK2659");
		flight.setBasePrice(248);
		this.add(flight);
		
		flight = new Flight();
		flight.setOriginAirport("AMS");
		flight.setDestAirport("FRA");
		flight.setAirline("LH5909");
		flight.setBasePrice(113);
		this.add(flight);

	}

	public void add(Flight flight){
		this.flights.add(flight);
	}
	
	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
}
