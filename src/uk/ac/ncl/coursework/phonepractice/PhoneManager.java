package uk.ac.ncl.coursework.phonepractice;

import java.util.Calendar;
import java.util.Date;

public class PhoneManager {
	
	private int currentAreaCodeIndex = 0;
	private final int[] areaCodes = {7927 , 7928 , 7929};
	private int currentLocalNumber = 100000;
	
	public PhoneAccount issuePhone(String accountHolderName, Calendar accountHolderDob, String accountType){
	
		//TODO add exceptions
		
		if(accountType == PhoneAccountFactory.PAY_AS_YOU_GO) {
			Person accountHolder = new Person(accountHolderName, new Date(accountHolderDob.getTimeInMillis()));
			
			PhoneAccountFactory.getInstance(getNewPhoneNumber(), accountHolder, accountType);
		} else if(accountType == PhoneAccountFactory.UNLIMITED) {
			
			
		}
		
		return null;
	}
	
	private PhoneNumber getNewPhoneNumber(){
		PhoneNumber pn = new PhoneNumber(areaCodes[currentAreaCodeIndex], currentLocalNumber);
		
		currentLocalNumber += 1;
		if(currentLocalNumber > 999999 && currentAreaCodeIndex != 2) {
				currentAreaCodeIndex += 1;
				currentLocalNumber = 100000;
		} else {
			//TODO: logging	
			//A real system would look for numbers to reallocate.
		}
		
		return pn;
	}
	
}
