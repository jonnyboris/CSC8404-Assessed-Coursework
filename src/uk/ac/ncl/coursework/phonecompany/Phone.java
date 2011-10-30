package uk.ac.ncl.coursework.phonecompany;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author jonny
 *
 */
final class Phone {
	private final PhoneAccount pa;
	private ArrayList<Call> callList;
	Phone(PhoneAccount pa) {
		this.pa = pa;
		callList = new ArrayList<Call>();
	}
	
	/**	 * @return The phone number of the account
	 */
	public PhoneNumber getNumber() {
		return this.pa.getNumber();
	} 
	
	/**
	 * Return the balance of the phone account
	 * 
	 * @return the balance of the account
	 */
	public int getBalance() {
		return this.pa.getBalance();
	}
	
	/**
	 * Attempts to make and store a call to given 
	 * phone number
	 * 
	 * @param toNumber the number the call is to
	 * @param duration the length of the call
	 * @return true if the call was successful
	 */
	public boolean call(PhoneNumber toNumber, int duration) {
		Call call = this.pa.chargeCall(toNumber, duration);
		callList.add(call);
		if (call == null) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Returns the list of recent calls ordered by
	 * time of call
	 * 
	 * @return an ArrayList of Calls sorted by time of call
	 */
	public ArrayList<Call> getCalls(){
		Collections.sort(callList);
		ArrayList<Call> defensiveCopyCallList = new ArrayList<Call>();
		defensiveCopyCallList.addAll(callList);
		return defensiveCopyCallList;
	}
	
	/**
	 *Clears the list of recent calls
	 */
	public void clearCalls(){
		callList.clear();
	}
	
	/**
	 * Attempts to add credit to the account
	 * 
	 * @param amount - the amount in pounds to be credited
	 * @return true is the phone could be credited 
	 */
	public boolean credit(int amount) {
		return pa.credit(amount);
	}
	
}
