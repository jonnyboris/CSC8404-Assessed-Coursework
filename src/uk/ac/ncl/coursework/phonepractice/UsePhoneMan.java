package uk.ac.ncl.coursework.phonepractice;

import java.util.Calendar;
import java.util.Date;

public class UsePhoneMan {
	public static void main(String args[]) {
		Calendar dob  = Calendar.getInstance();
		dob.set(1958, 10, 20);
		
		PhoneAccount pa = PhoneAccountFactory.getInstance(new PhoneNumber(191, 2815532), new Person("Jonathan Fairfull", new Date(dob.getTimeInMillis())), PhoneAccountFactory.UNLIMITED);
		
		Calendar now = Calendar.getInstance();
		System.out.println(now.get(Calendar.YEAR));

	}

}
