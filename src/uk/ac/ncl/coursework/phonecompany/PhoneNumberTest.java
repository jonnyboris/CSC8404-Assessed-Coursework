package uk.ac.ncl.coursework.phonecompany;

import static org.junit.Assert.*;
import org.junit.Test;


public class PhoneNumberTest {

	 @Test(expected = IllegalArgumentException.class)
	public void testPhoneNumber() {
		final PhoneNumber ph = new PhoneNumber(191, 2815532);
		
		assertEquals(191, ph.getAreaCode());
		assertEquals(2815532, ph.getLocalNumber());
		
		final PhoneNumber ph1 = new PhoneNumber(0121, 0715532);
	}

	@Test
	public void testGetAreaCode() {
		final PhoneNumber ph = new PhoneNumber(7928, 2815532);
		assertEquals(7928, ph.getAreaCode());
	}

	@Test
	public void testGetLocalNumber() {
		final PhoneNumber ph = new PhoneNumber(7928, 2816476);
		assertEquals(2816476, ph.getLocalNumber());
	}

	@Test
	public void testToString() {
		final PhoneNumber ph = new PhoneNumber(7928, 2816476);
		assertEquals("7928 2816476", ph.toString());
	}

	/**
	 * Test equals method for symmetry, reflexivity, transitivity
	 * and Inequality
	 * 
	 */
	@Test
	public void testEqualsObject() {
		final PhoneNumber ph = new PhoneNumber(7928, 2816476);
		final PhoneNumber phOne = new PhoneNumber(7928, 2816476);
		final PhoneNumber phTwo = new PhoneNumber(7928, 2816476);
		final PhoneNumber phThree = new PhoneNumber(7928, 5554444);
		
		assertTrue(ph.equals(phOne));
		assertTrue(phOne.equals(ph));
		
		assertTrue(ph.equals(ph));
		
		assertTrue(ph.equals(phOne));
		assertTrue(phOne.equals(phTwo));
		assertTrue(ph.equals(phTwo));
		
		assertFalse(ph.equals(phThree));
	}

	/**
	 * Tests that objects created with value of are created and 
	 * have the correct values
	 */
	@Test
	public void testValueOf() {
		final PhoneNumber ph = new PhoneNumber(7928, 2816476);
		String phString = ph.toString();
		final PhoneNumber phFromString = PhoneNumber.valueOf(phString);
		
		assertTrue(ph.equals(phFromString));
		assertEquals(phFromString.toString(), phString);
	}

}
