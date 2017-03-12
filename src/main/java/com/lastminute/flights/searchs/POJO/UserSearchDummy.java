package com.lastminute.flights.searchs.POJO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserSearchDummy {
	
	UserSearch search;
	
	public UserSearchDummy() {
		search = new UserSearch();
		search.setOriginAirport("AMS");
		search.setDestAirport("FRA");
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		String dateDeparture = "09-Feb-2017";
		Date date;
		try {
			date = formatter.parse(dateDeparture);
			search.setDateDeparture(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

//		search.setNumDaysToDeparture(31);
		
		Passengers passengers = new Passengers();
		passengers.setAdultNum(2);
		passengers.setChildrenNum(1);
		passengers.setInfatNum(1);
		search.setPassengers(passengers);
		
//		System.out.println(search.toString());
	}

	public UserSearch getSearch() {
		return search;
	}

	public void setSearch(UserSearch search) {
		this.search = search;
	}
}
