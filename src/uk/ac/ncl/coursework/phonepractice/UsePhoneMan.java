package uk.ac.ncl.coursework.phonepractice;

public class UsePhoneMan {
	public static void main(String args[]) {
		 
		PhoneAccount pa = PhoneAccountFactory.getInstance(new PhoneNumber(191, 2815532), new Person(), PhoneAccountFactory.UNLIMITED);
		//System.out.println(pa.getBalance());
		pa.credit(30);
		System.out.println(pa.getBalance());
		pa.chargeCall(new PhoneNumber(191, 2813255), 75);
		pa.chargeCall(new PhoneNumber(191, 2813255), 75);
		pa.chargeCall(new PhoneNumber(191, 2813255), 75);
		pa.chargeCall(new PhoneNumber(191, 2813255), 75);
		pa.chargeCall(new PhoneNumber(191, 2813255), 75);
		pa.chargeCall(new PhoneNumber(191, 2813255), 75);
		//System.out.println(pa.getBalance());
	}

}
