package day9;

import java.util.ArrayList;
import java.util.Scanner;

class Paitent{
	int id;
	String name;
	int age;
	
	Paitent(int id,String name,int age){
		this.id=id;
		this.name=name;
		this.age=age;
	}
	 public void display() {
	        System.out.println("ID: " + id + ", Name: " + name +
	                ", Age: " + age);
	    }
}

public class PaitentManager {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Paitent> list = new ArrayList<>();
		
		while(true) {
			System.out.println("\n1. Add Paitent");
			System.out.println("2. Display Paitent");
			System.out.println("3. Search Paitent");
			System.out.println("4. Exit");
			
			int choice=sc.nextInt();
			sc.nextLine();
			
			if(choice ==1) {
				System.out.print("Enter Id: ");
				int id = sc.nextInt();
				sc.nextLine();
				
				System.out.print("Enter Name:");
				String name = sc.nextLine();
				
				System.out.print("Enter Age:");
				int age =sc.nextInt();
				
				list.add(new Paitent(id,name,age));
				System.out.println("Paitent Added");
			}
			else if (choice ==2) {
				for(Paitent p :list) {
					p.display();
				}
			}
			else if(choice ==3) {
				System.out.print("Enter name to search: ");
                String search = sc.nextLine();
                boolean found = false;
                for (Paitent p : list) {
                    if (p.name.equalsIgnoreCase(search)) {
                        p.display();
                        found = true;
                    }
                }
                if(!found) System.out.println("Paitent Not Found");
			}
			else if (choice ==4) break;
			else System.out.println("Invalid Choice");

		}
		sc.close();
	}
}
