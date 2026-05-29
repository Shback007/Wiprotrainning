package day2loop;
import java.util.Scanner;
public class ShoppingCart {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double price;
		double total=0;
		System.out.println("Enter Item Prices:(Enter 0 to finish)");
		
		while (true) {
			System.out.print("Enter Price: ");
			price=sc.nextDouble();
			if(price==0)
				break;
			
			total+=price;
		}
		System.out.print("Total Price is: " + total);
		sc.close();
	}
}
