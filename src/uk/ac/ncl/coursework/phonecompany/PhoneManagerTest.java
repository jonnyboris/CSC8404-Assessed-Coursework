package uk.ac.ncl.coursework.phonecompany;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

public class PhoneManagerTest {
	PhoneManager pm = new PhoneManager();
	@Test
	public void testIssuePhone() {
	
		Calendar dob  = Calendar.getInstance();
		dob.set(1988, 9, 21);
		Phone p = pm.issuePhone("Jonathan Fairfull", dob, PhoneAccountFactory.UNLIMITED);
		dob.set(1998, 9, 21);
		Phone pOne = pm.issuePhone("Billy Mays", dob, PhoneAccountFactory.PAY_AS_YOU_GO);
		assertTrue(p.getNumber() != pOne.getNumber());
		
		dob.set(1999, 9, 21);
		Phone pTwo = pm.issuePhone("Richard Stallman", dob, PhoneAccountFactory.UNLIMITED);
		//Person not old enough
		assertNull(pTwo);
	}

	@Test
	public void testGetAccount() {
		
		Calendar dob  = Calendar.getInstance();
		dob.set(1988, 9, 21);
		Phone p = pm.issuePhone("Boris Johnson", dob, PhoneAccountFactory.UNLIMITED);
		PhoneNumber pn = p.getNumber();
		
		PhoneAccount pOne = pm.getAccount(pn);
		assertEquals(p.getNumber(), pOne.getNumber());
		
	}

	@Test
	public void testGetAllAccounts() {
		PhoneManager pm = new PhoneManager();
		Map<PhoneNumber, PhoneAccount> phoneAccs = pm.getAllAccounts();
		//accounts are stored by a static hashmap in phone account factory
		assertEquals(3, phoneAccs.size());
	}

	@Test
	public void testReturnPhone() {
		Calendar dob  = Calendar.getInstance();
		dob.set(1968, 9, 21);
		Phone p = pm.issuePhone("Joe B", dob, PhoneAccountFactory.UNLIMITED);
		PhoneNumber pn = p.getNumber();
		
		pm.returnPhone(pn);
		
		assertTrue(pm.getAccount(pn).isBlocked());
	}

	@Test
	public void testDeleteAccount() {
		Calendar dob  = Calendar.getInstance();
		dob.set(1958, 9, 21);
		Phone p = pm.issuePhone("Dan L", dob, PhoneAccountFactory.UNLIMITED);
		PhoneNumber pn = p.getNumber();
		assertTrue(!pm.deleteAccount(pn));
		pm.returnPhone(pn);
		assertTrue(pm.deleteAccount(pn));
	}

}
