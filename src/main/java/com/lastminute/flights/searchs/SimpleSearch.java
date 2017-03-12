package com.lastminute.flights.searchs;

import java.util.ArrayList;
import java.util.List;

import com.lastminute.flights.dao.ServiceDAO;
import com.lastminute.flights.dao.impl.ServiceDAOImpl;
import com.lastminute.flights.exceptions.SearchException;
import com.lastminute.flights.searchs.POJO.Airline;
import com.lastminute.flights.searchs.POJO.Flight;
import com.lastminute.flights.searchs.POJO.ResultDetail;
import com.lastminute.flights.searchs.POJO.UserSearch;
import com.lastminute.flights.utils.Constants;

public class SimpleSearch {

	public List<Flight> searchFlights(UserSearch search){
		ServiceDAO service = new ServiceDAOImpl();
		List<Flight> flights = new ArrayList<Flight>();
		try {
			flights = service.getFlights(search);
			
			if (flights.isEmpty()){
				System.out.println("No flights available");
			}else{
				for (Flight flight:flights){
					System.out.println(flight);
				}
			}
			
		} catch (SearchException e) {
			System.out.println(e.getError());//logger
		}
		return flights;
	}
	
	public void calculatePricesInfants(UserSearch search, List<Flight> flights, List<Airline> airlines){
		float priceInfant = -1;
		if (search.getPassengers().getInfatNum()>0){
			for(Flight flight:flights){
				//Assuming iataCode is always 2 characters
				String iataCode = flight.getAirline().substring(0,2);
				
				boolean found = false;
				for (int i=0; (i<airlines.size() && !found); i++){
					Airline airline = airlines.get(i);
					found = airline.getIataCode().equals(iataCode);
					if (found){
						priceInfant = airline.getInfantPrice();
						System.out.println("The price of infant in "+airline.getName()+" is: "+priceInfant);
						flight.setPriceInfant(priceInfant);
					}
				}
				
			}
		}else{
			System.out.println("There aren't infants passengers");
		}
	}

	public float calculatePercentDaysPrior(UserSearch search) {
		float applyPercent = -1f; //100%
		
		if (31<=search.getNumDaysToDeparture()){
			applyPercent = 0.8f;					
		}else if (30>=search.getNumDaysToDeparture() && 16<=search.getNumDaysToDeparture()){
			applyPercent = 1f;
		}else if (15>=search.getNumDaysToDeparture() && 3<=search.getNumDaysToDeparture()){
			applyPercent = 1.2f;					
		}else if (2>=search.getNumDaysToDeparture() && 0<=search.getNumDaysToDeparture()){
			applyPercent = 1.5f;					
		}
		System.out.println("Apply this percentage to base price: "+applyPercent+ "%");
		
		return applyPercent;
	}
	
	public float calculatePercentChild(UserSearch search){
		
		float applyPercent = 1f;
		
		if (search.getPassengers().getChildrenNum()>0){
			applyPercent = (100 - Constants.CTE_DISCOUNT_CHILD)/100;					
		}else{
			applyPercent = 0; // there are no children
		}
		System.out.println("Apply this percentage to base price: "+applyPercent+ "%");
		return applyPercent;
	}

	public void calculateTotal(ResultDetail result, UserSearch search) {
		
		for (Flight flight :result.getFlights()){
			//Adults
			float totalFlight = flight.getBasePrice()*result.getPercentDaysPrior()*search.getPassengers().getAdultNum();
			//Childrens
			totalFlight += flight.getBasePrice()*result.getPercentDaysPrior()*result.getPercentChild()*search.getPassengers().getChildrenNum();
			//Infants
			totalFlight += flight.getPriceInfant()*search.getPassengers().getInfatNum();
			flight.setTotal(totalFlight);

			System.out.println(flight.getAirline()+", "+String.format("%.2f", totalFlight).replace(",", ".")+"€");
			
			
			System.out.println(flight.getAirline()+", "+String.format("%.2f", totalFlight).replace(",", ".")+"€ ( "
					+ search.getPassengers().getAdultNum()+" * ( "+result.getPercentDaysPrior() + " * " + flight.getBasePrice()+ " ) + "
					+ search.getPassengers().getChildrenNum()+" * "+ result.getPercentChild() +" * ( "+result.getPercentDaysPrior() + " * "+flight.getBasePrice()+ " ) + "
					+ search.getPassengers().getInfatNum() +" * "+flight.getPriceInfant() + ")");
		}
	}
}
