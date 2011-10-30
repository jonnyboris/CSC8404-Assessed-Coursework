package uk.ac.ncl.coursework.phonecompany;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

public class PhoneManager {
	
	private static int CURRENT_AREA_CODE_INDEX = 0;
	private final int[] areaCodes = {7927 , 7928 , 7929};
	private static int CURRENT_LOCAL_NUMBER = 100000;
	
	private static final Logger LOG = Logger.getLogger("uk.ac.ncl.coursework");
	
	/**
	 * Issues a phone account to a given person.
	 * 
	 * @param accountHolderName the name of the account holder
	 * @param accountHolderDob the date of birth of the account holder
	 * @param accountType the type of account required
	 * @return The phone account created for the given person
	 */
	public Phone issuePhone(String accountHolderName, Calendar accountHolderDob, String accountType){
		if(accountHolderName == null || accountType == null || accountHolderDob == null) {
			LOG.warning("Bad parameter sent. name:" + accountHolderName + " account type: " + accountType + " DOB: " + accountHolderDob.toString());
			throw new IllegalArgumentException("All parameters must be none null");
		}
		
		if(accountHolderDob.after(Calendar.getInstance())) {
			LOG.warning("Date of birth passed was in the future");
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
				LOG.warning("Customer is not old enough for this account: " + accountHolderName);
				return null;
			} else {
				Person accountHolder = new Person(accountHolderName, new Date(accountHolderDob.getTimeInMillis()));
				pa = PhoneAccountFactory.getInstance(getNewPhoneNumber(), accountHolder, accountType);
			}
			
		} else {
			throw new IllegalArgumentException("Invalid Phone Account type");
		}
		LOG.info("New Account Created: " + pa.getNumber().toString());
		return new Phone(pa);
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
		PhoneNumber pn = new PhoneNumber(areaCodes[CURRENT_AREA_CODE_INDEX], CURRENT_LOCAL_NUMBER);
		
		CURRENT_LOCAL_NUMBER += 1;
		if(CURRENT_LOCAL_NUMBER > 999999 && CURRENT_AREA_CODE_INDEX != 2) {
				CURRENT_AREA_CODE_INDEX += 1;
				CURRENT_LOCAL_NUMBER = 100000;
		} else {
			//TODO: logging	
			//A real system would look for numbers to reallocate.
		}
		
		return pn;
	}	
}
