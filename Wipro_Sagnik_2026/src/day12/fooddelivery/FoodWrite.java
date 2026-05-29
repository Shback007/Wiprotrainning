package day12.fooddelivery;

import java.io.*;

public class FoodWrite {
	public static void main(String[] args) {
		try {
			FoodDelivery f1 = new FoodDelivery("Biriyani_House","Sagnik");
			
			f1.placeOrder("Biriyani", 1, 169);
			f1.placeOrder("Mutton", 2, 239);
			f1.placeOrder("Butter Chicken", 1, 169);
		
			
			FileOutputStream file = new FileOutputStream("food.ser");
			ObjectOutputStream obj = new ObjectOutputStream(file);
			System.out.println("Order Placed");
			
			obj.writeObject(f1);
			obj.close();
			file.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
