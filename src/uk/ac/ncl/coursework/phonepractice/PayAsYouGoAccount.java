package uk.ac.ncl.coursework.phonepractice;

final class PayAsYouGoAccount extends PhoneAccountFactory {

	PayAsYouGoAccount(PhoneNumber phoneNumber, Person accountHolder) {
		super(phoneNumber, accountHolder);
	}
	
	public boolean credit(int amount) {
		if(!isBlocked()) {
			if(amount <= 0) {
				throw new IllegalArgumentException("Amount must be positive: " + amount);
			} else {
				amount = amount * 100;
				updateBalance(getBalance() + amount);
				return true;
			}
		} else {
			return false;
		}
	}

	@Override
	public Call chargeCall(PhoneNumber toNumber, int duration) {
		int currentBalance = getBalance();
		
		if (currentBalance < 20) {
			return null;
		} else if(toNumber == null) {
			throw new IllegalArgumentException("toNumber cannot be null");
		} else if ( duration < 0) {
			throw new IllegalArgumentException("Call duration cannot be negative");
		}  
		final int cost = duration * 20; 
		updateBalance(getBalance()- cost);
		return new Call(toNumber, duration, cost);
	}
	
}
