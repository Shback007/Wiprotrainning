package day7;

public class Hello {
	public static void main(String[] args) throws InterruptedException {
		
		World t1= new World();//NEW
		t1.start();			  // RUNNABLE
//		t1.join();
//		World world = new World();
//		Thread t1 = new Thread(world);
//		t1.start();
		for(int i=1;i<=5;i++) {
			System.out.println("Hello");
		}
	}
}
