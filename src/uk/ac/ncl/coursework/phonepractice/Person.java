package uk.ac.ncl.coursework.phonepractice;
/**
 * Person - Represents a phone account holder
 * 
 * @author Jonathan Fairfull
 * $date 17-10-2011
 *
 */
import java.util.Date;

final class Person {
	private final String name;
	private final Date dateOfBirth;
	
	/**
	 * Instantiate a person with a given name
	 * and date of birth
	 * 
	 * @param name The name of the person
	 * @param dateOfBirth The date of birth of the person 
	 */
	Person(String name, Date dateOfBirth) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}
	
	/**
	 * Returns the name of the person.
	 * 
	 * @return the name of the person
	 */
	String getName() {
		return name;
	}
	
	/**
	 * Returns the person's date of birth
	 * 
	 * @return the date of birth of the person
	 */
	Date getDate() {
		return dateOfBirth;
	}
	
	

}
