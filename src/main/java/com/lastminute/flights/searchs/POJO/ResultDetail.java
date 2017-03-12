package com.lastminute.flights.searchs.POJO;

import java.util.List;

public class ResultDetail {
	private List<Flight> flights;
	private float percentDaysPrior = 0;
	private float percentChild = 0;
	
	public List<Flight> getFlights() {
		return flights;
	}
	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
	public float getPercentDaysPrior() {
		return percentDaysPrior;
	}
	public void setPercentDaysPrior(float percentDaysPrior) {
		this.percentDaysPrior = percentDaysPrior;
	}
	public float getPercentChild() {
		return percentChild;
	}
	public void setPercentChild(float percentChild) {
		this.percentChild = percentChild;
	}
}
