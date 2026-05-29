package day12;

import java.io.*;

public class ObjectRead {
	public static void main(String[] args) {
		try {
			FileInputStream f = new FileInputStream("animal.ser");
			ObjectInputStream obj = new ObjectInputStream(f);
			
			Animal a = (Animal) obj.readObject();
			
			System.out.println(a.getName());
			
			obj.close();
			f.close();
		}catch(Exception e ) {
			System.out.println(e);
		}
	}
}
