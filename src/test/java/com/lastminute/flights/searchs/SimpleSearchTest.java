package com.lastminute.flights.searchs;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.lastminute.flights.searchs.POJO.Flight;
import com.lastminute.flights.searchs.POJO.Passengers;
import com.lastminute.flights.searchs.POJO.UserSearch;

public class SimpleSearchTest {

	UserSearch search;
	
	@Before
	public void setUp() throws Exception {
		search = new UserSearch();
		search.setOriginAirport("AMS");
		search.setDestAirport("FRA");
		search.setNumDaysToDeparture(31);

		Passengers passengers = new Passengers();
		passengers.setAdultNum(1);
		search.setPassengers(passengers);
	}

	@Test
	public void findFlight() {
		SimpleSearch simple = new SimpleSearch();
    	List<Flight> flights = simple.searchFlights(search);
    	assertTrue("Failure - It was expected some result",
    			!flights.isEmpty());
    	
	}
	
	@Test
	public void notFindFlight() {
		SimpleSearch simple = new SimpleSearch();
		search.setDestAirport("BBB");
    	List<Flight> flights = simple.searchFlights(search);
    	assertTrue("Failure - It was not expected some result",
    			flights.isEmpty());
    	
	}

}
