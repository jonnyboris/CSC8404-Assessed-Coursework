package uk.ac.ncl.coursework.phonepractice;

import java.util.HashMap;
import java.util.Map;

public abstract class PhoneAccountFactory implements PhoneAccount {
	/**
	 * Pay as you go account type
	 */
	public static final String PAY_AS_YOU_GO = "pay_as_you_go";
	/**
	 * Unlimited calls account type
	 */
	public static final String UNLIMITED = "unlimited";
	
	private int balance;
	private Person accountHolder;
	private PhoneNumber phoneNumber;
	private boolean blocked;
	private static final Map<PhoneNumber, PhoneAccount> phoneAccounts = new HashMap<PhoneNumber, PhoneAccount>();
	
	PhoneAccountFactory(PhoneNumber phoneNumber, Person accountHolder) {
		this.phoneNumber = phoneNumber;
		this.accountHolder = accountHolder;
	}
	
	/**
	 * Return a phone account of the given type with the given
	 * phone number
	 * 
	 * @param areaCode the area code of the accounts phone number
	 * @param localNumber the local number of the accounts area code
	 * @param type the type of account to be created 
	 * @return
	 */
	public static PhoneAccount getInstance(PhoneNumber phoneNumber, Person accountHolder, String type) {
		PhoneAccount pa = phoneAccounts.get(phoneNumber); 
		
		if(pa != null) {
			return pa; 
		}
		
		if(type.equals(PAY_AS_YOU_GO)) {
			pa = new PayAsYouGoAccount(phoneNumber, accountHolder);
		} else if(type.equals(UNLIMITED))  {
			pa = new UnlimitedAccount(phoneNumber, accountHolder);
		} else {
			throw new IllegalArgumentException("Invalid Phone Account type: " + type);
		}
		
		phoneAccounts.put(phoneNumber, pa);
		return pa;
	}
	
	/* (non-Javadoc)
	 * @see uk.ac.ncl.coursework.phonepractice.PhoneAccount#block()
	 */
	public void block() {
		this.blocked = true;
	}
	
	/* (non-Javadoc)
	 * @see uk.ac.ncl.coursework.phonepractice.PhoneAccount#credit(int)
	 */
	public boolean credit(int pounds) {
		//TODO move implementation to subclasses
		if(pounds < 0) {
			throw new IllegalArgumentException("Cannot credit a negative amount");
		} else if(blocked != true) {
			pounds = pounds  * 100;
			balance += pounds;
			return true;
		} else {
			return false;
		}
	}
	
	/* (non-Javadoc)
	 * @see uk.ac.ncl.coursework.phonepractice.PhoneAccount#getBalance()
	 */
	public int getBalance() {
		return balance;
	}
	
	/* (non-Javadoc)
	 * @see uk.ac.ncl.coursework.phonepractice.PhoneAccount#getHolder()
	 */
	public Person getHolder(){
		//TODO defnsive copy
		return accountHolder;
	}

	/* (non-Javadoc)
	 * @see uk.ac.ncl.coursework.phonepractice.PhoneAccount#getNumber()
	 */
	public PhoneNumber getNumber() {
		return new PhoneNumber(phoneNumber.getAreaCode(), phoneNumber.getLocalNumber());
	}
	
	public boolean isBlocked(){
		return blocked;
	}
	
	void debit(int amount){ 
		balance -= amount;
	}
}