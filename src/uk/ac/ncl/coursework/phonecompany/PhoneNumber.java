package uk.ac.ncl.coursework.phonecompany;

import org.apache.commons.lang3.builder.HashCodeBuilder;

final class PhoneNumber {
	/**
	 * PhoneNumber - Represents a phone account phone number 
	 * 
	 */

	private final int areaCode;
	private final int localNumber;
	
	
	/**
	 * Instantiates a phone number with a given area code and local number
	 * 
	 * @param areaCode The area code for the phone number, cannot contain leading zeros.
	 * @param localNumber the local number of the phone number, cannot contain leading zeros.
	 * 
	 * @throws IllegalArgumentException if 
     * <code>areaCode or localNumber contain a leading 0.</code>
     * Or if <code> areaCode is not 3 or 4 characters or localNumber is not between 6 & 8 characters</code>
	 */
	PhoneNumber(int areaCode, int localNumber) {
		if((areaCode > 100 && areaCode < 9999) && (localNumber >= 100000 && localNumber < 99999999 )) {
			this.areaCode = areaCode;
			this.localNumber = localNumber;
		} else {
			throw new IllegalArgumentException("Invalid phone number format ");
		}
		
	}
	
	/**
	 * @return the area code of the phone number
	 */
	public int getAreaCode() {
		return areaCode;
	}
	
	/**
	 * @return the local number of the phone number
	 */
	public int getLocalNumber() {
		return localNumber;
	}
	
	/** 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return areaCode + " " + localNumber;
	}
	
	/** 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		if(o == this) return true;
		
		if(!(o instanceof PhoneNumber)) return false;
			
		PhoneNumber pn = (PhoneNumber) o;
		if((localNumber == pn.localNumber) && (areaCode == pn.areaCode)) {
			return true;
		} else {
			return false;
		}
	}
	
	/** 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(1567, 1987).append(areaCode).append(localNumber).toHashCode();
	}
	
	/**
	 * @param phoneNumber the string representation of <code>PhoneNumber</code> object
	 * @return a PhoneNumber object from a String representation of a PhoneNumber
	 */
	public static PhoneNumber valueOf(String phoneNumber) {
		String[] parts = phoneNumber.split(" ");
		final int areaCode = Integer.parseInt(parts[0].equals("null") ? null : parts[0]);
		final int localNumber =  Integer.parseInt(parts[1].equals("null") ? null : parts[1]);
		return new PhoneNumber(areaCode, localNumber);
	}
}
