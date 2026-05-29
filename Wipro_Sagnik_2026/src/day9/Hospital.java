package day9;

import java.util.LinkedList;

public class Hospital {
	LinkedList<String> list = new LinkedList<>();
	
	void addPatient(String name) {
		list.addLast(name);
		System.out.println(name + " added");
	}
	
	void addEmergencyPatient(String name) {
		list.addFirst(name);
		System.out.println(name + " added as Emergency");
	}
	
	void removePatient() {
		if(list.isEmpty()) System.out.println(" No Patients left");
		else {
			String removed = list.removeFirst();
			System.out.println(removed + " has been treated and removed");
		}
	}
	
	void viewPatient() {
		if(list.isEmpty()) System.out.println("Patient List is empty.");
		else System.out.println("Current patient " + list);
	}
	
	void checkFirst() {
        if (list.isEmpty()) System.out.println("Patient List is empty.");
        else System.out.println("First patient: " + list.getFirst());
    }

    void checkLast() {
        if (list.isEmpty()) System.out.println("Patient List is empty.");
        else System.out.println("Last patient: " + list.getLast());
        
    }
    
    public static void main(String[] args) {
    	Hospital h1 = new Hospital();
    	
    	h1.addPatient("Rahul");
    	h1.addPatient("Vikas");
    	h1.addPatient("Alex");
    	
    	h1.viewPatient();
    	
    	h1.addEmergencyPatient("Suman");
    	
    	h1.viewPatient();
    	
    	h1.checkFirst();
    	h1.checkLast();
    	h1.removePatient();
    	h1.viewPatient();
	}
}
