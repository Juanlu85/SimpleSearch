package com.lastminute.flights.searchs;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.lastminute.flights.searchs.POJO.AirlinesDummy;
import com.lastminute.flights.searchs.POJO.Flight;
import com.lastminute.flights.searchs.POJO.FlightsDummy;
import com.lastminute.flights.searchs.POJO.UserSearch;
import com.lastminute.flights.searchs.POJO.UserSearchDummy;

public class CalculatePriceInfantTest {

	UserSearch search;
	FlightsDummy flightsDummy;
	AirlinesDummy airlinesDummy;
	@Before
	public void setUp() throws Exception {
		UserSearchDummy searchDummy = new UserSearchDummy();
		search = searchDummy.getSearch();
		
		flightsDummy = new FlightsDummy();
		airlinesDummy = new AirlinesDummy();
	}

	@Test
	public void calculatePricesInfants() {
		SimpleSearch simple = new SimpleSearch();
		simple.calculatePricesInfants(search, flightsDummy.getFlights(), airlinesDummy.getAirlines());
		
		FlightsDummy flightsDummy_expected = new FlightsDummy();
		flightsDummy_expected.getFlights().get(0).setPriceInfant(5.0f);
		flightsDummy_expected.getFlights().get(1).setPriceInfant(5.0f);
		flightsDummy_expected.getFlights().get(2).setPriceInfant(7.0f);
		
		for(int i=0; i<flightsDummy.getFlights().size();i++){
			Flight flight = flightsDummy.getFlights().get(i);
			Flight flight_expected = flightsDummy_expected.getFlights().get(i);
			
			assertTrue(flight_expected.getPriceInfant()==flight.getPriceInfant());
		}
	}
	
	@Test
	public void airlineWithoutInfantPrice() {
		SimpleSearch simple = new SimpleSearch();
		search.getPassengers().setInfatNum(0);
		simple.calculatePricesInfants(search, flightsDummy.getFlights(), airlinesDummy.getAirlines());
		
		for(int i=0; i<flightsDummy.getFlights().size();i++){
			Flight flight = flightsDummy.getFlights().get(i);
			
			assertTrue(0==flight.getPriceInfant());//If there are not infants this price should be 0	
		}
	}


}
