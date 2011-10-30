package uk.ac.ncl.coursework.phonepractice;

import java.util.Calendar;
import java.util.Date;

public class UsePhoneMan {
	public static void main(String args[]) {
		Calendar dob  = Calendar.getInstance();
		dob.set(1998, 9, 21);
		
		PhoneAccount pa = PhoneAccountFactory.getInstance(new PhoneNumber(191, 2815532), new Person("Jonathan Fairfull", new Date(dob.getTimeInMillis())), PhoneAccountFactory.UNLIMITED);
		
		PhoneManager pm = new PhoneManager();
		
		pa = pm.issuePhone("jonny f", dob, PhoneAccountFactory.UNLIMITED);
		
		System.out.println(pa.getHolder().getName());
		System.out.println(pa.getNumber().toString());
		
		PhoneNumber pn = pa.getNumber();// new PhoneNumber(7927, 100000);
		System.out.println(pm.deleteAccount(pn));
		
		System.out.println(pm.returnPhone(pn));
		
		System.out.println(pm.deleteAccount(pn));
		
		/*Calendar ageLimit = Calendar.getInstance();
		ageLimit.set(Calendar.YEAR, (ageLimit.get(Calendar.YEAR) - 18));
		System.out.println(ageLimit.get(Calendar.YEAR));
		System.out.println(ageLimit.before(dob));*/
	}

}
