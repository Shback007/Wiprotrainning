package day7;

class Order extends Thread{

	@Override
	public void run() {
		try {
			for(int i=1;i<=5;i++) {
				System.out.println("Order is being Processed");
				Thread.sleep(1000);
			}
		}catch(InterruptedException e) {
			System.out.print(e.getMessage());
		}
	}
	
}

class Payment extends Thread{
	
	@Override
	public void run() {
		System.out.println("Payment to be done");
	}
}


public class Multis {
	public static void main(String[] args) throws InterruptedException {
		Order o = new Order();
		o.start();
//		o.join();
		Payment p = new Payment();
		p.start();
	}
	
	
	

}
