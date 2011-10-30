package uk.ac.ncl.coursework.phonecompany;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class PersonTest {

	@Test(expected = IllegalArgumentException.class)
	public void testPerson() {
		Calendar dob  = Calendar.getInstance();
		dob.set(1998, 9, 21);
		Person p1 = new Person("Jonathan Fairfull", new Date(dob.getTimeInMillis()));
		dob.set(2108, 9, 21);
		Person p2 = new Person("Jonathan Fairfull", new Date(dob.getTimeInMillis()));
	}

	@Test
	public void testGetName() {
		Calendar dob  = Calendar.getInstance();
		dob.set(1998, 9, 21);
		Person p1 = new Person("Jonathan Fairfull", new Date(dob.getTimeInMillis()));
		
		assertEquals("Jonathan Fairfull", p1.getName());
	}

	@Test
	public void testGetDate() {
		Calendar dob  = Calendar.getInstance();
		dob.set(1998, 9, 21);
		Person p1 = new Person("Jonathan Fairfull", new Date(dob.getTimeInMillis()));
		
		assertEquals(new Date(dob.getTimeInMillis()), p1.getDate());
	}

}
