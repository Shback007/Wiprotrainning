package day5.payment_system;

public interface UPI {
	void pay(int amount);
	default void useUPI() {
		System.out.println("Using UPI");
	}
	static void upi(){
		System.out.println("Payment to be done using UPI");
	}

}
