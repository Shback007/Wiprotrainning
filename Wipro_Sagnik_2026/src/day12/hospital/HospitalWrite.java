package day12.hospital;
import java.io.*;
public class HospitalWrite {
	public static void main(String[] args) {
		try {
			Hospital h1 = new Hospital(101,"Sagnik",23,"Viral Fever");
			h1.addReport("Blood Test: Normal");
			h1.addReport("X-Ray: Clear");
			h1.addTreatment("Paracetamol 650mg");
			h1.addTreatment("Bed Rest for 5 Days");
         
			FileOutputStream file = new FileOutputStream("hospital.ser");
			ObjectOutputStream obj =new ObjectOutputStream(file);
			
			obj.writeObject(h1);
			obj.close();
			file.close();
			System.out.println("Patient Record Saved");

     } catch(Exception e) {
         e.printStackTrace();
     }
		
	}
}
