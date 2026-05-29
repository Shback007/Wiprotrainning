package day7;
import java.util.concurrent.*;

class FoodTask implements Runnable{
	private String taskname;
	
	public FoodTask(String taskname) {
		this.taskname=taskname;
	}

	@Override
	public void run() {
		Thread.currentThread().setName(taskname + "-Thread");
		try {
			System.out.println(taskname + " started by " + Thread.currentThread().getName());
			Thread.sleep(2000);
			System.out.println(taskname + " completed by " +Thread.currentThread().getName());;
		}catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}


public class Multi_Three {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = Executors.newFixedThreadPool(3);
		
		Future<?>orderFuture = service.submit(new FoodTask("Order Processing"));
		
		orderFuture.get();
		
		Future<?>kitchenFuture = service.submit(new FoodTask("Food Preparation"));
		
		kitchenFuture.get();
		
		Future<?>deliveryFuture = service.submit(new FoodTask("Delivery"));
		
		deliveryFuture.get();
		service.shutdown();
		
		System.out.println("All tasks completed. App finished");
	}
}
