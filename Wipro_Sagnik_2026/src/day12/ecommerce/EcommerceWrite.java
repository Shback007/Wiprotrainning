package day12.ecommerce;
import java.io.*;

public class EcommerceWrite {
	public static void main(String[] args) {
		try {
			Ecommerce e1 = new Ecommerce(1,"Sagnik","West Bengal");
			Ecommerce e2 = new Ecommerce(1,"Arpan","West Bengal");
			
			e1.placeOrder("Laptop", 2, 67000);
			e1.placeOrder("Mobile", 3, 25000);
			
			e2.placeOrder("Macbook", 3, 79000);
			
			
			FileOutputStream file = new FileOutputStream("ecommerce.ser");
			
			ObjectOutputStream obj = new ObjectOutputStream(file);
			System.out.println("All Operations Completed");
			
			obj.writeObject(e1);
			obj.writeObject(e2);
			
			obj.close();
			file.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
