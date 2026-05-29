package day10;

import java.util.TreeMap;

public class PatientService2 {
	TreeMap<Integer, Patient2> map = new TreeMap<>();
	
	public void addPatient(Patient2 p) {
		if(map.containsKey(p.getId()))
			System.out.println("Patient already exists!");
		else {
			map.put(p.getId(), p);
			System.out.println("Patient added....");
		}
	}
	
	public void updatePatient(int id,String name) {
		Patient2 p = map.get(id);
		if(p!=null) {
			map.replace(id, new Patient2(id,name));
			System.out.println("Patient updated Successfully");
		}else System.out.println("Patient not found");
	}
	
	public void getPatient(int id) {
		Patient2 p = map.get(id);
		if(p!=null) System.out.println(p);
		else System.out.println("Patient not found.");
	}
	public void removePatient(int id) {
		if(map.remove(id)!=null) System.out.println(" Patient removed sucessfully");
		else System.out.println("Patient not found");
	}
	
	public void listPatients() {
		for(Patient2 p :map.values()) {
			System.out.println(p);
		}
	}
	
	public void exists(int id) {
		System.out.println(map.containsKey(id)? " Exists " : "Not Exists");
	}
	
	public void count() {
		System.out.println("Total Patient: " + map.size());
	}
	 public void clearAll() {
	        map.clear();
	        System.out.println("All records cleared.");
	 }
	 
	 public Integer displayFirst() {
		return map.firstKey();
	 }
	 public Integer displayLast() {
		 return map.lastKey();
	 }
	
	
	 public static void main(String[] args) {
		 PatientService2 serv = new PatientService2();
		 
		 serv.addPatient(new Patient2(4,"Sagnik"));
		 serv.addPatient(new Patient2(200,"Rahul"));
		 serv.addPatient(new Patient2(245,"Aman"));
		 
		 serv.getPatient(serv.displayFirst());
		 
		 serv.getPatient(serv.displayLast());
		 
		 System.out.println();
		 
		 serv.listPatients();
		 
		 System.out.println();
		 
		 serv.getPatient(200);
		 
		 System.out.println();
		 
		 serv.updatePatient(2, null);
		 
		 System.out.println();
		 
		 serv.exists(245);
		 
		 System.out.println();
		 
		 serv.count();
		 
		 System.out.println();
		 
		 serv.removePatient(200);
		 
		 System.out.println();
		 
		 serv.listPatients();
		 
		 System.out.println();
		 
		 serv.clearAll();
		 
		 System.out.println();
		 
		 serv.count();
		 
	}
	
}
