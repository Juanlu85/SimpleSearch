package com.lastminute.flights.searchs.POJO;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents all airlines
 * @author JLHM
 *
 */
public class AirlinesDummy {
	
	private List<Airline> airlines;
	
	public AirlinesDummy() {
		this.setAirlines(new ArrayList<Airline>());
		
		Airline airline = new Airline();
		airline.setIataCode("IB");
		airline.setName("Iberia");
		airline.setInfantPrice(10);
		this.add(airline);
		
		airline = new Airline();
		airline.setIataCode("BA");
		airline.setName("British Airways");
		airline.setInfantPrice(15);
		this.add(airline);
		
		airline = new Airline();
		airline.setIataCode("LH");
		airline.setName("Lufthansa");
		airline.setInfantPrice(7);
		this.add(airline);
		
		airline = new Airline();
		airline.setIataCode("FR");
		airline.setName("Ryanair");
		airline.setInfantPrice(20);
		this.add(airline);
		
		airline = new Airline();
		airline.setIataCode("VY");
		airline.setName("Vueling");
		airline.setInfantPrice(10);
		this.add(airline);
		
		airline = new Airline();
		airline.setIataCode("TK");
		airline.setName("Turkish Airlines");
		airline.setInfantPrice(5);
		this.add(airline);
		
		airline = new Airline();
		airline.setIataCode("U2");
		airline.setName("Easyjet");
		airline.setInfantPrice(19.90f);
		this.add(airline);
		
	}

	public List<Airline> getAirlines() {
		return airlines;
	}

	public void setAirlines(List<Airline> airlines) {
		this.airlines = airlines;
	}
	
	public void add(Airline airline){
		this.airlines.add(airline);
	}
	
}
