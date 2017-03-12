package com.lastminute.flights.dao;

import java.util.List;

import com.lastminute.flights.exceptions.SearchException;
import com.lastminute.flights.searchs.POJO.Flight;
import com.lastminute.flights.searchs.POJO.UserSearch;

/**
 * This class represents Interface of service to access data
 * @author JLHM
 *
 */
public interface ServiceDAO {

	public List<Flight> getFlights(UserSearch inputSearch) throws SearchException;
}
