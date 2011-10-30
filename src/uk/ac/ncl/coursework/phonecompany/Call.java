package uk.ac.ncl.coursework.phonecompany;

import java.util.Date;

import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Call - Represents a call placed from an account
 * 
 * @author Jonathan Fairfull
 * $date 17-10-2011
 *
 */
final class Call implements  Comparable<Call>{
	private final PhoneNumber toNumber;
	private final int duration;
	private final int cost;
	private final Date time;
	
	/**
	 * Instantiate a call with a given phone number, duration and cost.
	 * 
	 * @param toNumber the number the call was made to
	 * @param duration the length of the call in seconds
	 * @param cost the cost of the call in pence
	 */
	Call(PhoneNumber toNumber, int duration, int cost) {
		if(toNumber == null || duration == 0 || cost == 0) {
			throw new IllegalArgumentException("Parameters can not be null or 0");
		}
		this.toNumber = new PhoneNumber(toNumber.getAreaCode(), toNumber.getLocalNumber());
		this.duration = duration;
		this.cost = cost;
		this.time = new Date();
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
	public Date getTime() {
		return time;
	}
	
	/** 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		if(o == this) return true;
		
		if(!(o instanceof PhoneNumber)) return false;
		Call c = (Call) o;
		
		if((time.equals(c.getTime()) && toNumber.equals(c.getPhoneNumber())) && (duration == c.getDuration() && cost == c.getCost())) {
			return true;
		} else {
			return false;
		}
	}
	
	/** 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(2777, 1987).append(time).append(toNumber).append(duration).append(cost).toHashCode();
	}

	@Override
	public int compareTo(Call c) {
		int comparison;
		if (this == c) return 0;
		
		comparison = this.time.compareTo(c.time);
		if(comparison != 0) {
			return comparison;
		}
		
		assert this.equals(c) : "Invalid comparison of phone objects. compareTo inconsistent with equals.";
		
		return 0;
	}
}
