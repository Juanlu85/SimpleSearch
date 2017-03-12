package com.lastminute.flights.searchs;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.lastminute.flights.searchs.POJO.UserSearch;
import com.lastminute.flights.searchs.POJO.UserSearchDummy;

public class CalculatePercentChildTest {

	UserSearch search;
	@Before
	public void setUp() throws Exception {
		
		UserSearchDummy searchDummy = new UserSearchDummy();
		search = searchDummy.getSearch();
		
	}

	@Test
	public void calculatePercentChild() {
		SimpleSearch simple = new SimpleSearch();
		float percent = simple.calculatePercentChild(search);
		
		assertTrue("Failure - It was expected 0.67",
				0.67f==percent);
		
	}
	
	@Test
	public void calculatePercentWithoutChild() {
		SimpleSearch simple = new SimpleSearch();
		search.getPassengers().setChildrenNum(0);
		float percent = simple.calculatePercentChild(search);
		
		assertTrue("Failure - It was expected 0 (there are no children)",
				0f==percent);
		
	}

}
