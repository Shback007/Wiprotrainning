package day7;

class Kitchen{
	synchronized void cook(String orderName) {
		System.out.println();
		System.out.println(orderName + " entered Kitchen");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Cooking interrupted");
		}
		System.out.println(orderName + " finished cooking");
	}
}


class FoodDelivery extends Thread{
	
	Kitchen kitchen;
	public FoodDelivery(String name, Kitchen kitchen){
		setName(name);
		this.kitchen = kitchen;
	}
	public void run(){
	
//		System.out.println(getName() + " is ready to cook");
		kitchen.cook(getName());
//		System.out.println(getName() + " is leaving kitchen");
	}
}
public class Multi1 {

@SuppressWarnings("static-access")
public static void main(String[] args) throws InterruptedException {
	
	Kitchen kitchen = new Kitchen();

	FoodDelivery order1=new FoodDelivery(" Cook 1",kitchen);

	FoodDelivery order2=new FoodDelivery(" Cook 2",kitchen);

	FoodDelivery order3=new FoodDelivery(" Cook 3",kitchen);
	
	order1.start();
//	order1.join();
	order2.start();
//	order2.join();
	System.out.println(order2.getState());
	order3.start();
	
	}
}
