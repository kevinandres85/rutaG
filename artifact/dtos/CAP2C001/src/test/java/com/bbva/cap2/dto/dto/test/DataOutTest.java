package com.bbva.cap2.dto.dto.test;

import org.junit.Before;
import org.junit.Test;

import com.bbva.cap2.dto.dto.DataIn;
import com.bbva.cap2.dto.dto.DataOut;

import junit.framework.Assert;

public class DataOutTest {
	
	
	DataOut baseo=new DataOut();
	/**
	 * initialization data
	 */
	@Before
	public void starting() {

		baseo.setDistance(10);
		baseo.setTime(30);
		baseo.setCost(30.000);
		
		baseo.getDistance();
		baseo.getTime();
		baseo.getCost();
		baseo.getRate();
	}
	
	/**
	 * Method to test sentence toString()
	 */
	@Test
	public void testString() {
		Assert.assertEquals(baseo.toString(),"DataOut [distance=10, time=30, cost=30.0, rate=2000.0]");
	}

	/**
	 * Method to test sentence toString() fail - ended fail
	 */
	@Test
	public void testToStringFail() {
		Assert.assertFalse(baseo.toString().equals("123"));
	}

	/**
	 * Method to test hashCode() - ended ok
	 */
	@Test
	public void testHashCode() {
		int hashCode = baseo.hashCode();
		Assert.assertEquals(baseo.hashCode(), hashCode);
	}

	

	/**
	 * Method to test HashCode() in null - ended ok
	 */
	@Test
	public void testHashCodeNull() {
		DataIn basex = new DataIn();
		int hashCode = basex.hashCode();
		Assert.assertEquals(basex.hashCode(), hashCode);
	}
	/**
	 * Method to test equals() - ended ok
	 */
	
	@Test
	public void testEquals(){
		Assert.assertEquals(baseo.equals(baseo), true);
		Assert.assertEquals(baseo.equals(null), false);
		Assert.assertEquals(baseo.equals(baseo.getClass()), false);
		
		
		DataOut baseo1=new DataOut();
		
		baseo.setCost(3.0);
		baseo1.setCost(2.0);
		Assert.assertEquals(baseo.equals(baseo1), false);
		
		baseo.setCost(3.0);
		baseo1.setCost(3.0);
		
		baseo.setDistance(10);
		baseo1.setDistance(25);
		Assert.assertEquals(baseo.equals(baseo1), false);
		
		baseo.setDistance(10);
		baseo1.setDistance(10);
		
		
		Assert.assertEquals(baseo.equals(baseo1), false);
	
		baseo.setTime(30);
		baseo1.setTime(10);
		Assert.assertEquals(baseo.equals(baseo1), false);
		baseo.setTime(10);
		baseo1.setTime(10);
		
		Assert.assertEquals(baseo.equals(baseo1), true);
		
		
	}
	
	

}
