package day10;

import java.util.Scanner;

import java.util.TreeSet;

class Patient implements Comparable<Patient> {
    int id;
    String name;
    int age;
    
    Patient(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
	@Override
	public int compareTo(Patient obj) {
		return this.id - obj.id;
	}
	
	 public void display() {
	        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
	    }
}

public class PatientManager {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		TreeSet<Patient> patients = new TreeSet<>();
		
		while (true) {
            System.out.println("\n1. Register Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int n = sc.nextInt();
            if (n == 1) {
                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Age: ");
                int age = sc.nextInt();

                Patient newPatient = new Patient(id, name, age);

                if (patients.add(newPatient)) {
                    System.out.println("Patient added successfully!");
                } else {
                    System.out.println("Patient with this ID already exists!");
                }

            } else if (n == 2) {
                if (patients.isEmpty()) 
                    System.out.println("No patients registered.");
                 else {
                    System.out.println("\n--- Patient List ---");
                    for (Patient p : patients) 
                        p.display();
                 }
            } else if (n == 3) {
            	System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
        sc.close();
	}

}
