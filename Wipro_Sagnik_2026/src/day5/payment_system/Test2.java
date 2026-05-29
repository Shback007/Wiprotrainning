package day5.payment_system;

public class Test2 extends Payment{

	@Override
	public void pay(int amount) {
		System.out.println("Processing payment: " + amount);
		
	}
	 public static void main(String[] args) {
	        Test2 obj = new Test2();
	        obj.processPayment(500);
	    }
}