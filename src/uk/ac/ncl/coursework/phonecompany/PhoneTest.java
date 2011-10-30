package uk.ac.ncl.coursework.phonecompany;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Test;

public class PhoneTest {

	PhoneManager pm = new PhoneManager();
	@Test
	public void testCall() {
		
		Calendar dob  = Calendar.getInstance();
		dob.set(1988, 9, 21);
		Phone p = pm.issuePhone("Jonathan Fairfull", dob, PhoneAccountFactory.UNLIMITED);
		p.call(new PhoneNumber(191, 2815485), 10);
	}

	@Test
	public void testGetCalls() {
		Calendar dob  = Calendar.getInstance();
		dob.set(1988, 9, 21);
		Phone p = pm.issuePhone("Jonathan Fairfull", dob, PhoneAccountFactory.UNLIMITED);
		
		p.call(new PhoneNumber(191, 2815485), 70);
		p.call(new PhoneNumber(191, 2815485), 55);
		p.call(new PhoneNumber(191, 2815485), 3);
		p.call(new PhoneNumber(191, 2815485), 11);
		
		ArrayList<Call> calls = p.getCalls();
		assertEquals(4, calls.size());
		
	}

	@Test
	public void testClearCalls() {
		Calendar dob  = Calendar.getInstance();
		dob.set(1988, 9, 21);
		Phone p = pm.issuePhone("Jonathan Fairfull", dob, PhoneAccountFactory.UNLIMITED);
		
		p.call(new PhoneNumber(191, 2815485), 70);
		p.call(new PhoneNumber(191, 2815485), 55);
		p.call(new PhoneNumber(191, 2815485), 3);
		p.call(new PhoneNumber(191, 2815485), 11);
		
		ArrayList<Call> calls = p.getCalls();
		assertEquals(4, calls.size());
		p.clearCalls();
		calls = p.getCalls();
		assertEquals(0, calls.size());
	}

}
