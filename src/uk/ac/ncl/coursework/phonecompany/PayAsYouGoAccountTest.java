package uk.ac.ncl.coursework.phonecompany;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class PayAsYouGoAccountTest {

	@Test
	public void testCredit() {
		final PhoneNumber pn = new PhoneNumber(7928, 2816476);	
		Calendar dob  = Calendar.getInstance();
		dob.set(1998, 9, 21);
		Person accountHolder = new Person("Jonathan Fairfull", new Date(dob.getTimeInMillis()));
		
		final PhoneAccount pa = PhoneAccountFactory.getInstance(pn, accountHolder, PhoneAccountFactory.PAY_AS_YOU_GO);
		
		//pa.c
	}

	@Test
	public void testChargeCall() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInstance() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllAccounts() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAccount() {
		fail("Not yet implemented");
	}

	@Test
	public void testBlock() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBalance() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetHolder() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsBlocked() {
		fail("Not yet implemented");
	}

}
