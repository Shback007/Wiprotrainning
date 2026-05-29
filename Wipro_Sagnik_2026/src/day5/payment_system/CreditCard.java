package day5.payment_system;

public interface CreditCard {
	void paycc(int amount);
	default void usecc() {
		System.out.println("Using Credit Card");
	}
	static void cc(){
		System.out.println("Payment to be done using Credit Card");
	}
}
