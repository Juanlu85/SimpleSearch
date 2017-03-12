package com.lastminute.flights.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.lastminute.flights.dao.ServiceDAO;
import com.lastminute.flights.exceptions.SearchException;
import com.lastminute.flights.searchs.POJO.Flight;
import com.lastminute.flights.searchs.POJO.UserSearch;
import com.lastminute.flights.utils.Constants;

/**
 * This class represents the DAO service implementation
 * @author JLHM
 *
 */
public class ServiceDAOImpl implements ServiceDAO {
	public ArrayList<Flight> getFlights(UserSearch inputSearch) throws SearchException {
		ClassLoader classLoader = getClass().getClassLoader();

		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		ArrayList<Flight> flights = new ArrayList<Flight>();
		try {
			File file = new File(classLoader.getResource(Constants.FILE_NAME_FLIGHTS_CSV).getFile());
			br = new BufferedReader(new FileReader(file));
			boolean firstLine = true;
			while ((line = br.readLine()) != null) {

				if (firstLine){
					firstLine = false;
				}else{
					String[] flight_line = line.split(cvsSplitBy);
					if (inputSearch.getOriginAirport().equals(flight_line[0]) &&
							inputSearch.getDestAirport().equals(flight_line[1])){
						Flight flight = new Flight();
						flight.setOriginAirport(flight_line[0]);
						flight.setDestAirport(flight_line[1]);
						flight.setAirline(flight_line[2]);
						flight.setBasePrice(Float.parseFloat(flight_line[3]));
						flights.add(flight);
					}
				}
			}

		} catch (IOException e) {
			throw new SearchException(e.getMessage());
		} catch (Exception e) {
			throw new SearchException(e.toString());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					throw new SearchException(e.getMessage());
				}
			}
		}
		
		return flights;
	}

	
}
