package uk.ac.ncl.coursework.phonecompany;

import static org.junit.Assert.*;
import org.junit.Test;


public class PhoneNumberTest {

	@Test
	public void testHashCode() {
		fail("Not yet implemented");
	}

	 @Test(expected = IllegalArgumentException.class)
	public void testPhoneNumber() {
		final PhoneNumber ph = new PhoneNumber(191, 2815532);
		//ToDo check these are needed
		assertEquals(191, ph.getAreaCode());
		assertEquals(2815532, ph.getLocalNumber());
		
		final PhoneNumber ph1 = new PhoneNumber(0121, 0715532);
	}

	@Test
	public void testGetAreaCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLocalNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testValueOf() {
		fail("Not yet implemented");
	}

}
