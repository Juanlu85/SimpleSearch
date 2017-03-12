package com.lastminute.flights.searchs;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.lastminute.flights.searchs.POJO.AirlinesDummy;
import com.lastminute.flights.searchs.POJO.Flight;
import com.lastminute.flights.searchs.POJO.FlightsDummy;
import com.lastminute.flights.searchs.POJO.Passengers;
import com.lastminute.flights.searchs.POJO.ResultDetail;
import com.lastminute.flights.searchs.POJO.UserSearch;
import com.lastminute.flights.searchs.POJO.UserSearchDummy;

public class CalculateTotalPriceTest {

	UserSearch search;
	@Before
	public void setUp() throws Exception {
		
		UserSearchDummy searchDummy = new UserSearchDummy();
		search = searchDummy.getSearch();

	}

	@Test
	public void calculatePercentChild() {
		ResultDetail result = new ResultDetail();
		FlightsDummy flightsDummy = new FlightsDummy();
		result.setFlights(flightsDummy.getFlights());
		result.setPercentDaysPrior(0.8f);
		result.setPercentChild(0.67f);
		
		flightsDummy.getFlights().get(0).setPriceInfant(5);//TK
		flightsDummy.getFlights().get(1).setPriceInfant(5);//TK
		flightsDummy.getFlights().get(2).setPriceInfant(7);//LH
		
		SimpleSearch simple = new SimpleSearch();
		simple.calculateTotal(result, search);

		FlightsDummy flightsDummy_expected = new FlightsDummy();
		flightsDummy_expected.getFlights().get(0).setTotal(425.79202f);
		flightsDummy_expected.getFlights().get(1).setTotal(534.728f);
		flightsDummy_expected.getFlights().get(2).setTotal(248.36801f);
		
		for(int i=0; i<result.getFlights().size();i++){
			Flight flight = result.getFlights().get(i);
			Flight flight_expected = flightsDummy_expected.getFlights().get(i);
			
			assertEquals(flight_expected.getAirline(), flight.getAirline());
			assertTrue(flight_expected.getTotal() == flight.getTotal());
		}
	}
	
	@Test
	public void example1() {
		System.out.println("\n**** Example 1 ****\n");
		
		UserSearch search = new UserSearch();
		search.setOriginAirport("AMS");
		search.setDestAirport("FRA");
		search.setNumDaysToDeparture(31);
		Passengers passengers = new Passengers();
		passengers.setAdultNum(1);
		search.setPassengers(passengers);
		
		System.out.println(search.toString());
		
		SimpleSearch simple = new SimpleSearch();
		//1 search flights
		List<Flight> flights = simple.searchFlights(search);
		if (!flights.isEmpty()){
			ResultDetail result = new ResultDetail();
	    	result.setFlights(flights);
			
			//2 calculate infants prices
			AirlinesDummy airlinesDummy = new AirlinesDummy();
			simple.calculatePricesInfants(search, flights, airlinesDummy.getAirlines());
			
			//3 get the percentage depending on the days to departure 
			float applyPercent = simple.calculatePercentDaysPrior(search);
			result.setPercentDaysPrior(applyPercent);
			
			//4 calculate the percentage 
			float applyPercentChild = simple.calculatePercentChild(search);
			result.setPercentChild(applyPercentChild);
			
			simple.calculateTotal(result,search);
			
			
			FlightsDummy flightsDummy_expected = new FlightsDummy();
			flightsDummy_expected.getFlights().get(0).setTotal(157.6f);
			flightsDummy_expected.getFlights().get(1).setTotal(198.40001f);
			flightsDummy_expected.getFlights().get(2).setTotal(90.4f);
			
			for(int i=0; i<result.getFlights().size();i++){
				Flight flight = result.getFlights().get(i);
				Flight flight_expected = flightsDummy_expected.getFlights().get(i);
				
				assertEquals(flight_expected.getAirline(), flight.getAirline());
				assertTrue(flight_expected.getTotal() == flight.getTotal());
			}
		}
		
	}

	
	@Test
	public void example2() {
		System.out.println("\n**** Example 2 ****\n");
		
		UserSearch search = new UserSearch();
		search.setOriginAirport("LHR");
		search.setDestAirport("IST");
		search.setNumDaysToDeparture(15);
		Passengers passengers = new Passengers();
		passengers.setAdultNum(2);
		passengers.setChildrenNum(1);
		passengers.setInfatNum(1);
		search.setPassengers(passengers);
		
		System.out.println(search.toString());
		
		SimpleSearch simple = new SimpleSearch();
		//1 search flights
		List<Flight> flights = simple.searchFlights(search);
		if (!flights.isEmpty()){
			ResultDetail result = new ResultDetail();
	    	result.setFlights(flights);
			
			//2 calculate infants prices
			AirlinesDummy airlinesDummy = new AirlinesDummy();
			simple.calculatePricesInfants(search, flights, airlinesDummy.getAirlines());
			
			//3 get the percentage depending on the days to departure 
			float applyPercent = simple.calculatePercentDaysPrior(search);
			result.setPercentDaysPrior(applyPercent);
			
			//4 calculate the percentage 
			float applyPercentChild = simple.calculatePercentChild(search);
			result.setPercentChild(applyPercentChild);
			
			simple.calculateTotal(result,search);
			
			
			FlightsDummy flightsDummy_expected = new FlightsDummy();
			flightsDummy_expected.getFlights().get(0).setAirline("TK8891");
			flightsDummy_expected.getFlights().get(0).setTotal(806);
			flightsDummy_expected.getFlights().get(1).setAirline("LH1085");
			flightsDummy_expected.getFlights().get(1).setTotal(481.19202f);
			
			for(int i=0; i<result.getFlights().size();i++){
				Flight flight = result.getFlights().get(i);
				Flight flight_expected = flightsDummy_expected.getFlights().get(i);
				
				assertEquals(flight_expected.getAirline(), flight.getAirline());
				assertTrue(flight_expected.getTotal() == flight.getTotal());
			}
		}
		
	}
	
	@Test
	public void example3() {
		System.out.println("\n**** Example 3 ****\n");
		
		UserSearch search = new UserSearch();
		search.setOriginAirport("BCN");
		search.setDestAirport("MAD");
		search.setNumDaysToDeparture(2);
		Passengers passengers = new Passengers();
		passengers.setAdultNum(1);
		passengers.setChildrenNum(2);
		search.setPassengers(passengers);
		
		System.out.println(search.toString());
		
		SimpleSearch simple = new SimpleSearch();
		//1 search flights
		List<Flight> flights = simple.searchFlights(search);
		if (!flights.isEmpty()){
			ResultDetail result = new ResultDetail();
	    	result.setFlights(flights);
			
			//2 calculate infants prices
			AirlinesDummy airlinesDummy = new AirlinesDummy();
			simple.calculatePricesInfants(search, flights, airlinesDummy.getAirlines());
			
			//3 get the percentage depending on the days to departure 
			float applyPercent = simple.calculatePercentDaysPrior(search);
			result.setPercentDaysPrior(applyPercent);
			
			//4 calculate the percentage 
			float applyPercentChild = simple.calculatePercentChild(search);
			result.setPercentChild(applyPercentChild);
			
			simple.calculateTotal(result,search);
			
			
			FlightsDummy flightsDummy_expected = new FlightsDummy();
			flightsDummy_expected.getFlights().get(0).setAirline("IB2171");
			flightsDummy_expected.getFlights().get(0).setTotal(909.09f);
			flightsDummy_expected.getFlights().get(1).setAirline("LH5496");
			flightsDummy_expected.getFlights().get(1).setTotal(1028.4299f);
			
			for(int i=0; i<result.getFlights().size();i++){
				Flight flight = result.getFlights().get(i);
				Flight flight_expected = flightsDummy_expected.getFlights().get(i);
				
				assertEquals(flight_expected.getAirline(), flight.getAirline());
				assertTrue(flight_expected.getTotal() == flight.getTotal());
			}
		}
		
	}
	
	@Test
	public void example4() {
		System.out.println("\n**** Example 4 ****\n");
		
		UserSearch search = new UserSearch();
		search.setOriginAirport("CDG");
		search.setDestAirport("FRA");
		Passengers passengers = new Passengers();
		search.setPassengers(passengers);
		
		System.out.println(search.toString());
		
		SimpleSearch simple = new SimpleSearch();
		//1 search flights
		List<Flight> flights = simple.searchFlights(search);
		if (!flights.isEmpty()){
			ResultDetail result = new ResultDetail();
	    	result.setFlights(flights);
			
			//2 calculate infants prices
			AirlinesDummy airlinesDummy = new AirlinesDummy();
			simple.calculatePricesInfants(search, flights, airlinesDummy.getAirlines());
			
			//3 get the percentage depending on the days to departure 
			float applyPercent = simple.calculatePercentDaysPrior(search);
			result.setPercentDaysPrior(applyPercent);
			
			//4 calculate the percentage 
			float applyPercentChild = simple.calculatePercentChild(search);
			result.setPercentChild(applyPercentChild);
			
			simple.calculateTotal(result,search);
			
			
			FlightsDummy flightsDummy_expected = new FlightsDummy();
			flightsDummy_expected.getFlights().get(0).setAirline("IB2171");
			flightsDummy_expected.getFlights().get(0).setTotal(909.09f);
			flightsDummy_expected.getFlights().get(1).setAirline("LH5496");
			flightsDummy_expected.getFlights().get(1).setTotal(1028.4299f);
			
			for(int i=0; i<result.getFlights().size();i++){
				Flight flight = result.getFlights().get(i);
				Flight flight_expected = flightsDummy_expected.getFlights().get(i);
				
				assertEquals(flight_expected.getAirline(), flight.getAirline());
				assertTrue(flight_expected.getTotal() == flight.getTotal());
			}
		}
		
	}

}
