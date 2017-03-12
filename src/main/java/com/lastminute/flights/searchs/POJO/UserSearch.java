package com.lastminute.flights.searchs.POJO;

import java.util.Date;

/**
 * This class represents the users input values
 * @author JLHM
 *
 */
public class UserSearch {

	private String originAirport = "";
	private String destAirport = "";
	private Date dateDeparture;
	private int numDaysToDeparture;
	private Passengers passengers;
	
	
	public String getOriginAirport() {
		return originAirport;
	}
	public void setOriginAirport(String originAirport) {
		this.originAirport = originAirport;
	}
	public String getDestAirport() {
		return destAirport;
	}
	public void setDestAirport(String destAirport) {
		this.destAirport = destAirport;
	}
	public Date getDateDeparture() {
		return dateDeparture;
	}
	public void setDateDeparture(Date dateDeparture) {
		Date now = new Date();
		long diff = now.getTime() - dateDeparture.getTime();
		int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
		this.setNumDaysToDeparture(diffDays);
		this.dateDeparture = dateDeparture;
	}
	public int getNumDaysToDeparture() {
		return numDaysToDeparture;
	}
	public void setNumDaysToDeparture(int numDaysToDeparture) {
		this.numDaysToDeparture = numDaysToDeparture;
	}
	public Passengers getPassengers() {
		return passengers;
	}
	public void setPassengers(Passengers passengers) {
		this.passengers = passengers;
	}
	
	@Override
	public String toString() {
		return this.getPassengers().getAdultNum()+" adults, "
				+ ""+ this.getPassengers().getChildrenNum()+ " child, "+ this.getPassengers().getInfatNum()+ " infant, "
						+ this.getNumDaysToDeparture() + " days to the departure date, flying "+ this.getOriginAirport()+" --> "
								+ this.getDestAirport();
	}

}
