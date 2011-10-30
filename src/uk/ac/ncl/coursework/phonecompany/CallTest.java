package uk.ac.ncl.coursework.phonecompany;

import static org.junit.Assert.*;

import org.junit.Test;

public class CallTest {

	@Test(expected = IllegalArgumentException.class)
	public void testCall() {
		PhoneNumber pn = new PhoneNumber(191, 2815562);
		Call c = new Call(pn, 10, 200);

		Call cOne = new Call(null, 0, 0);
	}

	@Test
	public void testGetPhoneNumber() {
		PhoneNumber pn = new PhoneNumber(191, 2815562);
		Call c = new Call(pn, 10, 200);
		
		assertEquals(pn, c.getPhoneNumber());
	}

	@Test
	public void testGetDuration() {
		PhoneNumber pn = new PhoneNumber(191, 2815562);
		Call c = new Call(pn, 10, 200);
		
		assertEquals(10, c.getDuration());
	}

	@Test
	public void testGetCost() {
		PhoneNumber pn = new PhoneNumber(191, 2815562);
		Call c = new Call(pn, 10, 200);
		
		assertEquals(200, c.getCost());
	}

	@Test
	public void testGetTime() {
		PhoneNumber pn = new PhoneNumber(191, 2815562);
		Call c = new Call(pn, 10, 200);
		c.getTime();
	}

	@Test
	public void testEqualsObject() {
		PhoneNumber pn = new PhoneNumber(191, 2815562);
		Call c = new Call(pn, 10, 200);
		Call cOne = c;

		assertTrue(c.equals(cOne));

	}

	/**
	 *  Tests compareTo, invokes thread.sleep as
	 *  time is automatically created when the
	 *  call object is instantiated 
	 */
	@Test
	public void testCompareTo() {
		PhoneNumber pn = new PhoneNumber(191, 2815562);
		Call c = new Call(pn, 10, 200);
		Call cOne = new Call(pn, 10, 200);
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Call cTwo = new Call(pn, 10, 200);
		
		assertEquals(0, c.compareTo(cOne));
		assertEquals(1, cTwo.compareTo(cOne));
	}

}
