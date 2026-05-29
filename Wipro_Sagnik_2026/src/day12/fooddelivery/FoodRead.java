package day12.fooddelivery;
import java.io.*;

public class FoodRead {
	public static void main(String[] args) {
		try {
			FileInputStream file = new FileInputStream("food.ser");
			ObjectInputStream obj = new ObjectInputStream(file);
			
			FoodDelivery f = (FoodDelivery) obj.readObject();
			f.showDetails();
			obj.close();
			file.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
