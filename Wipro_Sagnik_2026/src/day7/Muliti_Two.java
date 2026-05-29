package day7;

class Order1 implements Runnable{

	@Override
	public void run() {
		try {
				System.out.println(Thread.currentThread().getName() +": is being Processed");
				Thread.sleep(3000);
				System.out.println(Thread.currentThread().getName() +": Processed");
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
class Payment1 implements Runnable{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + ": Payment to be done");
	}
}

class Notification implements Runnable{
	@Override
	public void run(){
		System.out.println(Thread.currentThread().getName()+": Notification sent");
	}
}

public class Muliti_Two {
	public static void main(String[] args) throws InterruptedException {
		Order1 o = new Order1();
		Payment1 p = new Payment1();
		Notification n = new Notification();
		
		Thread t1 = new Thread(o);
		Thread t2 = new Thread(p);
		Thread t3 = new Thread(n);
		
		t1.setName("Order Thread");
		t2.setName("Payment Thread");
		t3.setName("Notification Thread");
		
		t1.setPriority(Thread.MAX_PRIORITY);
	    t2.setPriority(Thread.NORM_PRIORITY);
	    t3.setPriority(Thread.MIN_PRIORITY);
		
		System.out.println("\nBefore Start");
		System.out.println(t1.getName() + " alive ? " +t1.isAlive());
		
		t1.start();
		System.out.println("\nAfter Start");
		System.out.println(t1.getName() + " alive ? " +t1.isAlive());
		
		t1.join();
		t2.start();
//		t2.join();
		t3.start();
		
		Thread t4 = new Thread(()->{
			System.out.println();
			System.out.println(Thread.currentThread().getName());
		});
		
		t4.setName("Lambda Thread");
		t4.start();
		System.out.println(t1.getState());
				
	}
	
}
