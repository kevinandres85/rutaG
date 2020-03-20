
package com.bbva.cap2.dto.dto.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.bbva.cap2.dto.dto.*;

import junit.framework.Assert;

public class DataInTest {

	DataIn base = new DataIn();

	/**
	 * initialization data
	 */
	@Before
	public void starting() {

		base.setDestiny("medellin");
		base.setOrigin("bogota");
		base.getDestiny();
		base.getOrigin();

	}

	/**
	 * Method to test sentence toString()
	 */
	@Test
	public void testString() {
		Assert.assertEquals(base.toString(), "DataIn [origin=bogota, destiny=medellin]");
	}

	/**
	 * Method to test sentence toString() fail - ended fail
	 */
	@Test
	public void testToStringFail() {
		Assert.assertFalse(base.toString().equals("123"));
	}

	/**
	 * Method to test hashCode() - ended ok
	 */
	@Test
	public void testHashCode() {
		int hashCode = base.hashCode();
		Assert.assertEquals(base.hashCode(), hashCode);
	}

	/**
	 * Method to test HashCode() - ended fail
	 */
	@Test
	public void testHashCodeFail() {
		Assert.assertEquals(base.hashCode()==3,false);
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
	 * Method to test Equals() - ended ok
	 */
	@Test
	public void testEquals() {

		Assert.assertEquals(base.equals(base), true);
		Assert.assertEquals(base.equals(null), false);
		Assert.assertFalse(base.equals("hola"));

		DataIn base4 = new DataIn();
		base.setDestiny(null);
		base4.setDestiny(" ");
		Assert.assertEquals(base.equals(base4), false);

		base.setDestiny("medellin"); 
		Assert.assertEquals(base.equals(base4), false);

		base.setDestiny("medellin");
		base4.setDestiny("medellin");

		base.setOrigin(null);
		base4.setOrigin("bogota");
		Assert.assertEquals(base.equals(base4), false);
		base.setOrigin("medellin");
		Assert.assertEquals(base.equals(base4), false);
		base4.setOrigin("medellin");
		Assert.assertEquals(base.equals(base4), true);

	}

}
