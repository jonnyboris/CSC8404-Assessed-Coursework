package uk.ac.ncl.coursework.phonecompany;

/**
 * PhoneAccount - Interface to different phone accounts
 * 
 * @author Jonathan Fairfull
 *
 */
public interface PhoneAccount {
	
	/**
	 * Blocks the account, disallows any actions to be
	 * preformed on the account
	 */
	void block();
	
	/**
	 *	Charges a call to the account
	 * 
	 * @param toNumber the number the call was placed to
	 * @param duration the length of time the call lasted in seconds.
	 * @param cost the cost of the call in pence 
	 * @return A <code>Call</code> object representing the call
	 * @throws IllegalAccountBalanceException when the account
	 * 	has insufficient funds to place the call 
	 */
	Call chargeCall(PhoneNumber toNumber, int duration);
	
	/**
	 * Credits the account 
	 * 
	 * @param pounds the amount to be credited to
	 * 	the account
	 * @return true if the account could be credited
	 */
	boolean credit(int pounds);

	/**
	 * Returns the current balance of the account in pence
	 * 
	 * @return The balance of the account in pence.
	 */
	int getBalance();

	/**
	 * Returns the holder of the account
	 * 
	 * @return The <code>Person</code> who the account is registered to.
	 */
	Person getHolder();
	
	/**
	 * Returns the accounts associated phone number 
	 * 
	 * @return The <code>PhoneNumber</code> of the account
	 */
	PhoneNumber getNumber();
	
	/**
	 * Returns the current status of the account, blocked
	 * or normal.
	 * 
	 * @return true if the account is blocked
	 */
	boolean isBlocked();
}