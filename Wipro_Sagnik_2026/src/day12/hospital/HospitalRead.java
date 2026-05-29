package day12.hospital;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class HospitalRead {
	public static void main(String[] args) {
		try {
			FileInputStream file = new FileInputStream("hospital.ser");
			ObjectInputStream obj = new ObjectInputStream(file);
			
			Hospital h = (Hospital) obj.readObject();
			h.showDetails();
			obj.close();
			file.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
