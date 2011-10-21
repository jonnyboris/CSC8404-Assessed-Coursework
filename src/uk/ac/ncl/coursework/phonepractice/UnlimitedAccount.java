package uk.ac.ncl.coursework.phonepractice;

final class UnlimitedAccount extends PhoneAccountFactory {

	UnlimitedAccount(PhoneNumber phoneNumber, Person accountHolder) {
		super(phoneNumber, accountHolder);
	}

	@Override
	public Call chargeCall(PhoneNumber toNumber, int duration) {
		//TODO remove sysos
		System.out.println("d " + duration);

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
		final Call call;
		
		if(bal > 1500) {
			tempCost = 10 * tempDuration;
			
			if(bal - tempCost < 1500) {
				balanceOverBoundary = bal - 1500;
				timeOverBoundary = balanceOverBoundary / 10;
				System.out.println("time over 15: " + timeOverBoundary);
				System.out.println("balance over 15: " + balanceOverBoundary);
				
				cost += balanceOverBoundary;
				bal -= balanceOverBoundary;
				tempDuration -= timeOverBoundary;
				
				System.out.println("Duration mins left " + tempDuration);

			} else {
				cost += tempCost;
			}
		}
		
		if((bal > 0  && bal <= 1500) && tempDuration > 0) {
			tempCost = 20 * tempDuration;
			
			if(bal - tempCost < 0 ) {
				balanceOverBoundary = bal;
				timeOverBoundary = balanceOverBoundary / 20;
				System.out.println("time over 0: " + timeOverBoundary);
				System.out.println("balance over 0: " + balanceOverBoundary);
				
				cost += balanceOverBoundary;
				bal -= balanceOverBoundary;
				tempDuration -= timeOverBoundary;
				
				System.out.println("Duration mins left " + tempDuration);
	
			} else {
				cost += tempCost;
			}
		}
		
		if(bal <= 0 && tempDuration > 0) {
			tempCost = tempDuration * 50;
			cost += tempCost;
		}
		debit(cost);
		System.out.println("Cost: " + cost + " Balance = "  + getBalance());
		return new Call(toNumber, duration, cost);
	}
	
	
}
