package uk.ac.ncl.coursework.phonepractice;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class PhoneManager {
	
	private int currentAreaCodeIndex = 0;
	private final int[] areaCodes = {7927 , 7928 , 7929};
	private int currentLocalNumber = 100000;
	
	/**
	 * Issues a phone account to a given person.
	 * 
	 * @param accountHolderName the name of the account holder
	 * @param accountHolderDob the date of birth of the account holder
	 * @param accountType the type of account required
	 * @return The phone account created for the given person
	 */
	public PhoneAccount issuePhone(String accountHolderName, Calendar accountHolderDob, String accountType){
	
		if(accountHolderName == null || accountType == null || accountHolderDob == null) {
			throw new IllegalArgumentException("All parameters must be none null");
		}
		
		if(accountHolderDob.after(Calendar.getInstance())) {
			throw new IllegalArgumentException("Date of birth cannot not be in the future");
		}
		
		PhoneAccount pa;
		if(accountType.equals(PhoneAccountFactory.PAY_AS_YOU_GO)) {
			
			Person accountHolder = new Person(accountHolderName, new Date(accountHolderDob.getTimeInMillis()));			
			pa =PhoneAccountFactory.getInstance(getNewPhoneNumber(), accountHolder, accountType);
			
		} else if(accountType == PhoneAccountFactory.UNLIMITED) {
			
			Calendar ageLimit = Calendar.getInstance();
			ageLimit.set(Calendar.YEAR, (ageLimit.get(Calendar.YEAR) - 18));
			
			if(ageLimit.before(accountHolderDob)) {
				return null;
			} else {
				Person accountHolder = new Person(accountHolderName, new Date(accountHolderDob.getTimeInMillis()));
				pa = PhoneAccountFactory.getInstance(getNewPhoneNumber(), accountHolder, accountType);
			}
			
		} else {
			throw new IllegalArgumentException("Invalid Phone Account type");
		}
		
		return pa;
	}

	/**
	 * Gets the account of a given phone number
	 * 
	 * @param phoneNumber the phone number of the account
	 * @return the account associated with phoneNumber
	 */
	public PhoneAccount getAccount(PhoneNumber phoneNumber) {
		return PhoneAccountFactory.getAccount(phoneNumber);
	}
	
	/**
	 * Get all accounts
	 * 
	 * @return All accounts from the system
	 */
	public Map<PhoneNumber, PhoneAccount> getAllAccounts() {
		return PhoneAccountFactory.getAllAccounts();
	}
	
	/**
	 * Returns and blocks an account
	 * 
	 * @param phoneNumber the phone number of the account to be 
	 * blocked
	 * @return true if the account is blocked
	 */
	public boolean returnPhone(PhoneNumber phoneNumber) {
		PhoneAccount pa = getAccount(phoneNumber);
		pa.block();
		return pa.isBlocked();
	}
	
	/**
	 * Deletes a phone account from the system
	 * 
	 * @param phoneNumber the phone number of the account to be deleted
	 */
	public boolean deleteAccount(PhoneNumber phoneNumber) {
		return PhoneAccountFactory.removeAccount(phoneNumber);
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
