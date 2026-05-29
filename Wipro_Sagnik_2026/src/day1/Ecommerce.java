package day1;
import java.util.*;
public class Ecommerce {
public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	Product p1 = new Product();
	System.out.print("Enter Product Name:");
	p1.name=sc.next();
	
	System.out.print("Enter price:");
	p1.price=sc.nextDouble();
	
	System.out.print("Enter Quantity:");
	p1.quantity=sc.nextInt();
	
	p1.setavilability();
	p1.printdetails();
	
	sc.close();
}
}
class Product{
	String name;
	double price;
	int quantity;
	private boolean availability=true;;
	
	public void printdetails() {
		System.out.println();
		System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Available: " + availability);
	}
	public void setavilability() {
		if (quantity == 0) {
	        availability = false;
	    } else {
	        availability = true;
	    }
	}
}

