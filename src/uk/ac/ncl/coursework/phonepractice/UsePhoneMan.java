package uk.ac.ncl.coursework.phonepractice;

public class UsePhoneMan {
	public static void main(String args[]) {
		 
		PhoneAccount pa = PhoneAccountFactory.getInstance(new PhoneNumber(191, 2815532), new Person(), PhoneAccountFactory.PAY_AS_YOU_GO);
		System.out.println(pa.getBalance());
		pa.credit(10);
		System.out.println(pa.getBalance());
		pa.chargeCall(new PhoneNumber(191, 2813255), 7);
		System.out.println(pa.getBalance());
	}

}
