package com.lastminute.flights.searchs.POJO;

/**
 * This class represents number of Passengers of each type
 * @author JLHM
 *
 */
public class Passengers {
	private int adultNum = 0;
	private int childrenNum = 0;
	private int infatNum = 0;
	
	public int getAdultNum() {
		return adultNum;
	}
	public void setAdultNum(int adultNum) {
		this.adultNum = adultNum;
	}
	public int getChildrenNum() {
		return childrenNum;
	}
	public void setChildrenNum(int childrenNum) {
		this.childrenNum = childrenNum;
	}
	public int getInfatNum() {
		return infatNum;
	}
	public void setInfatNum(int infatNum) {
		this.infatNum = infatNum;
	}
}
