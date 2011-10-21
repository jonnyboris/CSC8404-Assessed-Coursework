package uk.ac.ncl.coursework.phonepractice;

final class UnlimitedAccount extends PhoneAccountFactory {

	UnlimitedAccount(PhoneNumber phoneNumber, Person accountHolder) {
		super(phoneNumber, accountHolder);
	}

	@Override
	public Call chargeCall(PhoneNumber toNumber, int duration) {
		if(toNumber == null) {
			throw new IllegalArgumentException("toNumber cannot be null");
		} else if ( duration < 0) {
			throw new IllegalArgumentException("Call duration cannot be negative");
		}  
		return null;
	}

}
