package day12;

import java.io.*;
class Animal implements Serializable{
	private static final long serialVersionUID = 1L;
	  private String name;
	
	Animal(String name){
		this.name=name;
	}
	public String getName() {
		return name;
	}
}

public class ObjectWrite{
	public static void main(String[] args) {
		try {
			Animal a1 = new Animal("Lion");
			FileOutputStream f = new FileOutputStream("animal.ser");
			ObjectOutputStream obj = new ObjectOutputStream(f);
			
			obj.writeObject(a1);
			obj.close();
			f.close();
			System.out.println("Object Written");
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
