package uk.ac.ncl.coursework.phonecompany;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

import org.junit.Test;

public class PayAsYouGoAccountTest {
	private static final Logger LOG = Logger.getLogger("uk.ac.ncl.coursework");
	/**
	 * Tests credit() getBalance(), getInstance()
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCredit() {
		final PhoneNumber pn = new PhoneNumber(7998, 2816476);	
		Calendar dob  = Calendar.getInstance();
		dob.set(1998, 9, 21);
		Person accountHolder = new Person("Jonathan Fairfull", new Date(dob.getTimeInMillis()));
		
		final PhoneAccount pa = PhoneAccountFactory.getInstance(pn, accountHolder, PhoneAccountFactory.PAY_AS_YOU_GO);
		
		pa.credit(1);
		
		LOG.info(" --------- " + pa.getBalance());
		assertEquals(100, pa.getBalance());
		
		pa.credit(20);
		assertEquals(pa.getBalance(), 2100);
		
		pa.credit(0);
		pa.credit(-10);
	}

	/**
	 * Test charge call, getInstance, getBalance and credit
	 */
	@Test
	public void testChargeCall() {
		final PhoneNumber pn = new PhoneNumber(9928, 2816486);	
		Calendar dob  = Calendar.getInstance();
		dob.set(1998, 9, 21);
		Person accountHolder = new Person("Jonathan Fairfull", new Date(dob.getTimeInMillis()));
		
		final PhoneAccount pa = PhoneAccountFactory.getInstance(pn, accountHolder, PhoneAccountFactory.PAY_AS_YOU_GO);
		pa.credit(1);
		pa.chargeCall(new PhoneNumber(191, 2815545), 1);
		assertEquals(80, pa.getBalance());
	}

	/**
	 * Tests block() and isBlocked() and credit when phone is blocked
	 */
	@Test
	public void testBlock() {
		final PhoneNumber pn = new PhoneNumber(7928, 2816486);	
		Calendar dob  = Calendar.getInstance();
		dob.set(1998, 9, 21);
		Person accountHolder = new Person("Jonathan Fairfull", new Date(dob.getTimeInMillis()));
		
		final PhoneAccount pa = PhoneAccountFactory.getInstance(pn, accountHolder, PhoneAccountFactory.PAY_AS_YOU_GO);
		
		pa.block();
		assertTrue(pa.isBlocked());
		
		assertTrue(!pa.credit(20));
	}

	

	/**
	 * Tests person.equals(), and getHolder()
	 */
	@Test
	public void testGetHolder() {
		final PhoneNumber pn = new PhoneNumber(7928, 2222222);	
		Calendar dob  = Calendar.getInstance();
		dob.set(1998, 9, 21);
		Person accountHolder = new Person("Jonathan Fairfull", new Date(dob.getTimeInMillis()));
		
		final PhoneAccount pa = PhoneAccountFactory.getInstance(pn, accountHolder, PhoneAccountFactory.PAY_AS_YOU_GO);
		
		assertTrue(accountHolder.equals(pa.getHolder()));
	}


	@Test
	public void testGetNumber() {
		final PhoneNumber pn = new PhoneNumber(7928, 2816486);	
		Calendar dob  = Calendar.getInstance();
		dob.set(1998, 9, 21);
		Person accountHolder = new Person("Jonathan Fairfull", new Date(dob.getTimeInMillis()));
		
		final PhoneAccount pa = PhoneAccountFactory.getInstance(pn, accountHolder, PhoneAccountFactory.PAY_AS_YOU_GO);
		
		assertTrue(pn.equals(pa.getNumber()));
	}



}
