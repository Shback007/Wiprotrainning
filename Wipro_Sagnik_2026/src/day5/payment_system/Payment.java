package day5.payment_system;

public abstract class Payment {
	final void processPayment(int amount) {
		System.out.println("Secure Processing started");
		
		pay(amount);
		
		System.out.println("Payment Sucessfull");
	}
	 public abstract void pay(int amount);
}
