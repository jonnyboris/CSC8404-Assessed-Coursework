package uk.ac.ncl.coursework.phonepractice;

/**
 * Call - Represents a call placed from an account
 * 
 * @author Jonathan Fairfull
 * $date 17-10-2011
 *
 */
final class Call {
	private final PhoneNumber toNumber;
	private final int duration;
	private final int cost;
	private final long time;
	
	/**
	 * Instantiate a call with a given phone number, duration and cost.
	 * 
	 * @param toNumber the number the call was made to
	 * @param duration the length of the call in seconds
	 * @param cost the cost of the call in pence
	 */
	Call(PhoneNumber toNumber, int duration, int cost) {
		this.toNumber = new PhoneNumber(toNumber.getAreaCode(), toNumber.getLocalNumber());
		this.duration = duration;
		this.cost = cost;
		this.time = System.currentTimeMillis();
	}
	
	/**
	 * Returns the phone number from the call.
	 * 
	 * @return the <code>PhoneNumber</code> from the call. 
	 */
	public PhoneNumber getPhoneNumber() {
		return new PhoneNumber(toNumber.getAreaCode(), toNumber.getLocalNumber());
	}
	
	/**
	 * Returns the duration of the call
	 * 
	 * @return the duration of the call
	 */
	public int getDuration() {
		return duration;
	}
	
	/**
	 * Returns the cost of the call
	 * 
	 * @return the cost of the call
	 */
	public int getCost() {
		return cost;
	}
	
	/**
	 * Returns the time of the call in milliseconds (epoch)
	 * 
	 * @return
	 */
	public long getTime() {
		return time;
	}
}
