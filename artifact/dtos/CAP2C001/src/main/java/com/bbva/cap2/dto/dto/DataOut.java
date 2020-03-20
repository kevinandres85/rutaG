package com.bbva.cap2.dto.dto;

import com.bbva.apx.dto.AbstractDTO;

public class DataOut extends  AbstractDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2421897614347502396L;
	private long distance;
	private int time;
	private double cost;
	private static final double RATE=2000.0;
	
	/**
	 *  distance to get
	 */
	public long getDistance() {
		return distance;
	}
	/**
	 * distance to set
	 */
	public void setDistance(long distance) {
		this.distance = distance;
	}
	/**
	 * time to get 
	 */
	public int getTime() {
		return time;
	}
	/**
	 * time to set
	 */
	public void setTime(int time) {
		this.time = time;
	}
	/**
	 * cost to get
	 */
	public double getCost() {
		return cost;
	}
	/**
	 * cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	/**
	 * rate to get
	 */
	
	public static double getRate() {
		return RATE;
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (distance ^ (distance >>> 32));
		result = prime * result + time;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataOut other = (DataOut) obj;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (distance != other.distance)
			return false;
		if (time != other.time)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DataOut [distance=" + distance + ", time=" + time + ", cost=" + cost + ", rate=" + RATE + "]";
	}
	
	/**
	 * constructor to the super class
	 */
	public DataOut() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
