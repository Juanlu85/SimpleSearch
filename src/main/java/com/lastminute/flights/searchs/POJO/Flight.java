package com.lastminute.flights.searchs.POJO;

/**
 * This class represents each flight
 * @author JLHM
 *
 */
public class Flight {

	private String originAirport = "";
	private String destAirport = "";
	private String airline = "";
	private float basePrice = 0;
	private float priceInfant = 0;
	private float total = 0;
	
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
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public float getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}
	public float getPriceInfant() {
		return priceInfant;
	}
	public void setPriceInfant(float priceInfant) {
		this.priceInfant = priceInfant;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return this.getOriginAirport()+" -> "+this.getDestAirport()+ " " + this.getBasePrice()+"€ "+ "("+this.getAirline()+")";
	}
}
