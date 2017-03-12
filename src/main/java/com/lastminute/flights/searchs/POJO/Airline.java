/**
 * 
 */
package com.lastminute.flights.searchs.POJO;

/**
 * This class represents each airline
 * @author JLHM
 *
 */
public class Airline {

	private String iataCode = "";
	private String name = "";
	private float infantPrice = 0;
	
	public String getIataCode() {
		return iataCode;
	}
	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getInfantPrice() {
		return infantPrice;
	}
	public void setInfantPrice(float infantPrice) {
		this.infantPrice = infantPrice;
	}
}
