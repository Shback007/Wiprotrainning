package day5.payment_system;

public interface Cash {
	void payCash(int amount);
	default void useCash() {
		System.out.println("Using Cash");
	}
	static void cash(){
		System.out.println("Payment to be done using Cash");
	}

}
