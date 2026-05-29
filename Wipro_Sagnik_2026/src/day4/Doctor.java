package day4;

abstract class Doctor {
	String name;
	String specialization;
	
	public Doctor(String name,String specialization) {
		this.name=name;
		this.specialization=specialization;
	}
	
	abstract void diagnose(Paitent P);
}
