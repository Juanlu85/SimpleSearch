package com.lastminute.flights.dao;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.lastminute.flights.dao.impl.ServiceDAOImpl;
import com.lastminute.flights.exceptions.SearchException;
import com.lastminute.flights.searchs.POJO.Flight;
import com.lastminute.flights.searchs.POJO.Passengers;
import com.lastminute.flights.searchs.POJO.UserSearch;

public class ServiceDAOTest {

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
	public void findFlights() {
		ServiceDAO service = new ServiceDAOImpl();
		
		try {
			List<Flight> flights = service.getFlights(search);
			
			List<Flight> flights_expected = new ArrayList<Flight>();
			
			Flight flight_expected = new Flight();
			flight_expected.setOriginAirport("AMS");
			flight_expected.setDestAirport("FRA");
			flight_expected.setBasePrice(Float.parseFloat("197.0"));
			flight_expected.setAirline("TK2372");
			flights_expected.add(flight_expected);
			
			flight_expected = new Flight();
			flight_expected.setOriginAirport("AMS");
			flight_expected.setDestAirport("FRA");
			flight_expected.setBasePrice(Float.parseFloat("248.0"));
			flight_expected.setAirline("TK2659");
			flights_expected.add(flight_expected);
			
			flight_expected = new Flight();
			flight_expected.setOriginAirport("AMS");
			flight_expected.setDestAirport("FRA");
			flight_expected.setBasePrice(Float.parseFloat("113"));
			flight_expected.setAirline("LH5909");
			flights_expected.add(flight_expected);
			
			
			for (int i=0;i<flights.size();i++){
				Flight flight = flights.get(i);
				Flight expected = flights_expected.get(i);
				
				assertEquals("Failure - The airline is not as expected", 
						expected.getAirline(), flight.getAirline());
				assertEquals("Failure - The airport of departure is not as expected",
						expected.getOriginAirport(), flight.getOriginAirport());
				assertEquals("Failure - The airport of destination is not as expected",
						expected.getDestAirport(), flight.getDestAirport());
				assertTrue("Failure - The price base of the flight is not as expected",
						expected.getBasePrice()==flight.getBasePrice());
				
			}
		} catch (SearchException e) {
			fail("Failure - No exceptions are expected");
		}
	}
	
	@Test
	public void notFoundFlights() {
		ServiceDAO service = new ServiceDAOImpl();
		search.setOriginAirport("AAA");
		search.setDestAirport("FRA");
		try {
			List<Flight> flights = service.getFlights(search);
			assertTrue(flights.isEmpty());
			
		} catch (SearchException e) {
			fail("Failure - No exceptions are expected");
		}
	}
	
	@Test
	public void inputValuesNullFlights() {
		ServiceDAO service = new ServiceDAOImpl();
		search.setOriginAirport(null);
		search.setDestAirport("FRA");
		try {
			List<Flight> flights = service.getFlights(search);
			fail("Failure - It is expected an exception");
			
		} catch (SearchException e) {
			//Expected this exception
		}
	}

}
