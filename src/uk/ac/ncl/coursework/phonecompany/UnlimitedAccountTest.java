package uk.ac.ncl.coursework.phonecompany;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/**
 * @author jonny
 * all other PhoneAccountFactory methods are tested in PayAsYouGoAccountTest. This test class just tests
 * the unlimited account specific methods
 */
public class UnlimitedAccountTest {

	/**
	 * Tests credit() getBalance(), getInstance()
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCredit() {
		final PhoneNumber pn = new PhoneNumber(7928, 2816476);	
		Calendar dob  = Calendar.getInstance();
		dob.set(1998, 9, 21);
		Person accountHolder = new Person("Jonathan Fairfull", new Date(dob.getTimeInMillis()));
		
		final PhoneAccount pa = PhoneAccountFactory.getInstance(pn, accountHolder, PhoneAccountFactory.PAY_AS_YOU_GO);
		
		pa.credit(31);
		assertEquals(pa.getBalance(), 3100);
		
		pa.credit(1);
		pa.credit(29);
		pa.credit(0);
		pa.credit(-10);
	}

	/**
	 *  Test credit and charge call, checks that the correct rate is applied to different
	 *  parts of the call depending on balance.
	 *  
	 */
	@Test
	public void testChargeCall() {
		final PhoneNumber pn = new PhoneNumber(7928, 2816486);	
		Calendar dob  = Calendar.getInstance();
		dob.set(1998, 9, 21);
		Person accountHolder = new Person("Jonathan Fairfull", new Date(dob.getTimeInMillis()));
		
		final PhoneAccount pa = PhoneAccountFactory.getInstance(pn, accountHolder, PhoneAccountFactory.UNLIMITED);
		pa.credit(31);
		assertEquals(3100, pa.getBalance());
		pa.chargeCall(new PhoneNumber(191, 2815545), 10);
		
		assertEquals(3000, pa.getBalance());
		
		pa.chargeCall(new PhoneNumber(191, 2815545), 149);
		
		assertEquals(1510, pa.getBalance());
		
		//crosses all 3 rates, each part of call charged at different rate depending on balance
		pa.chargeCall(new PhoneNumber(191, 2815545), 77);
		assertEquals(-50, pa.getBalance());
		
		
	}

}
