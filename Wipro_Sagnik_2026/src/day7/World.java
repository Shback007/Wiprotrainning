package day7;

public class World extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0 ;i<=5;i++) {
			System.out.println("World");
		}
	}
	
}

//public class World implements Runnable{
//
//	@Override
//	public void run() {
//		for( ; ;)
//		System.out.println("World");
//	}
//	
//}
