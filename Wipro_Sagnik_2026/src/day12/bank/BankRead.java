package day12.bank;
import java.io.*;
public class BankRead {
	public static void main(String[] args) {
		try {
			FileInputStream file = new FileInputStream("bank.ser");
			ObjectInputStream obj = new ObjectInputStream(file);
			
			Bank b = (Bank) obj.readObject();
			b.showDetails();
			obj.close();
			file.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
