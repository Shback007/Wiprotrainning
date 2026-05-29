package day12.ecommerce;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class EcommerceRead {
	public static void main(String[] args) {
		try {
			FileInputStream file = new FileInputStream("ecommerce.ser");
			ObjectInputStream obj = new ObjectInputStream(file);
			
			Ecommerce e = (Ecommerce) obj.readObject();
			Ecommerce e2 = (Ecommerce) obj.readObject();
		
			e.showDetials();
			e2.showDetials();
			obj.close();
			file.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
