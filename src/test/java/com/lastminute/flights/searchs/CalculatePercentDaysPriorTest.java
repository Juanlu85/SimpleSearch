package com.lastminute.flights.searchs;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.lastminute.flights.searchs.POJO.UserSearch;
import com.lastminute.flights.searchs.POJO.UserSearchDummy;

public class CalculatePercentDaysPriorTest {
	
	UserSearch search;
	
	@Before
	public void setUp() throws Exception {
		UserSearchDummy searchDummy = new UserSearchDummy();
		search = searchDummy.getSearch();
	}

	@Test
	public void getPercentDaysPrior() {
		SimpleSearch simple = new SimpleSearch();
		search.setNumDaysToDeparture(31);
		float percent = simple.calculatePercentDaysPrior(search);
		assertTrue("Failure - It was expected 0.8 to 31 days to departure",
				0.8f==percent);
		
		search.setNumDaysToDeparture(30);
		percent = simple.calculatePercentDaysPrior(search);
		assertTrue("Failure - It was expected 1 to 30 days to departure",
				1f==percent);
		
		search.setNumDaysToDeparture(16);
		percent = simple.calculatePercentDaysPrior(search);
		assertTrue("Failure - It was expected 1 to 16 days to departure",
				1f==percent);
		
		search.setNumDaysToDeparture(15);
		percent = simple.calculatePercentDaysPrior(search);
		assertTrue("Failure - It was expected 1.2 to 15 days to departure",
				1.2f==percent);
		
		search.setNumDaysToDeparture(3);
		percent = simple.calculatePercentDaysPrior(search);
		assertTrue("Failure - It was expected 1.2 to 3 days to departure",
				1.2f==percent);
		
		search.setNumDaysToDeparture(2);
		percent = simple.calculatePercentDaysPrior(search);
		assertTrue("Failure - It was expected 1.5 to 2 days to departure",
				1.5f==percent);
	}
	
	@Test
	public void daysToDepartureNegative() {
		SimpleSearch simple = new SimpleSearch();
		search.setNumDaysToDeparture(-1);
		float percent = simple.calculatePercentDaysPrior(search);
		assertTrue("Failure - It was expected 0.8 to 31 days to departure",
				-1f==percent);
	}

}
