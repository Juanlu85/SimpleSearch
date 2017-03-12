package com.lastminute.flights.searchs;

import java.util.List;

import com.lastminute.flights.searchs.POJO.AirlinesDummy;
import com.lastminute.flights.searchs.POJO.Flight;
import com.lastminute.flights.searchs.POJO.ResultDetail;
import com.lastminute.flights.searchs.POJO.UserSearchDummy;


/**
 * Main class
 */
public class App 
{
    public static void main( String[] args )
    {
    	UserSearchDummy dummySearch = new UserSearchDummy();
    	
    	SimpleSearch simple = new SimpleSearch();
    	List<Flight> flights = simple.searchFlights(dummySearch.getSearch());
    	
    	AirlinesDummy airlinesDummy = new AirlinesDummy();
    	
    	simple.calculatePricesInfants(dummySearch.getSearch(), flights, airlinesDummy.getAirlines());
    	ResultDetail result = new ResultDetail();
    	result.setFlights(flights);
    	
    	float applyPercent = simple.calculatePercentDaysPrior(dummySearch.getSearch());
    	
    	if (applyPercent<0){
    		System.out.println("Error number of day to departure: "+dummySearch.getSearch().getNumDaysToDeparture());
    	}else{
    		result.setPercentDaysPrior(applyPercent);
    		float applyPercentChild = simple.calculatePercentChild(dummySearch.getSearch());
    		result.setPercentChild(applyPercentChild);
    	}
    	
    	simple.calculateTotal(result,dummySearch.getSearch());
    	
    }
}
