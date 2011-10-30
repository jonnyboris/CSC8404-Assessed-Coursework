package uk.ac.ncl.coursework.phonecompany;

final class UnlimitedAccount extends PhoneAccountFactory {

	UnlimitedAccount(PhoneNumber phoneNumber, Person accountHolder) {
		super(phoneNumber, accountHolder);
	}

	public boolean credit(int amount) {
		if(!isBlocked()) {
			if (amount <= 0) {
				throw new IllegalArgumentException("Amount must be positive: " + amount);
			} else if (amount >= 30) {
				amount = amount * 100;
				updateBalance(getBalance() + amount);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/** 
	 * Charges a call at different rates depending on the balance of the account.
	 * 
	 * @see uk.ac.ncl.coursework.phonecompany.PhoneAccount#chargeCall(uk.ac.ncl.coursework.phonecompany.PhoneNumber, int)
	 */
	public Call chargeCall(PhoneNumber toNumber, int duration) {
		if(toNumber == null) {
			throw new IllegalArgumentException("toNumber cannot be null");
		} else if ( duration <= 0) {
			throw new IllegalArgumentException("Call duration cannot be negative or zero");
		}  
		
		int bal = getBalance(), 
			cost =0,
			tempCost = 0,
			balanceOverBoundary = 0,
			timeOverBoundary = 0,
			tempDuration = duration;
		
		if(bal > 1500) {
			tempCost = 10 * tempDuration;
			
			if(bal - tempCost < 1500) {
				balanceOverBoundary = bal - 1500;
				timeOverBoundary = balanceOverBoundary / 10;
				cost += balanceOverBoundary;
				bal -= balanceOverBoundary;
				tempDuration -= timeOverBoundary;
			} else {
				cost += tempCost;
			}
		}
		
		if((bal > 0  && bal <= 1500) && tempDuration > 0) {
			tempCost = 20 * tempDuration;
			
			if(bal - tempCost < 0 ) {
				balanceOverBoundary = bal;
				timeOverBoundary = balanceOverBoundary / 20;
				
				cost += balanceOverBoundary;
				bal -= balanceOverBoundary;
				tempDuration -= timeOverBoundary;
			} else {
				cost += tempCost;
			}
		}
		
		if(bal <= 0 && tempDuration > 0) {
			tempCost = tempDuration * 50;
			cost += tempCost;
		}
		updateBalance((getBalance() - cost));
		return new Call(toNumber, duration, cost);
	}
	
}
