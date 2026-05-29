package day12.bank;

import java.io.*;

public class BankWrite {
	public static void main(String[] args) {
		try {
			Bank b1 = new Bank(1245678945126L,"Sagnik",50000);
			
			b1.deposit(25000);
			b1.withdraw(100000);
			b1.withdraw(-20);
			b1.deposit(50000);
			b1.withdraw(56987);
			
			
			FileOutputStream file = new FileOutputStream("bank.ser");
			ObjectOutputStream obj = new ObjectOutputStream(file);
			System.out.println("All Transaction Recorded");
			
			obj.writeObject(b1);
			obj.close();
			file.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
