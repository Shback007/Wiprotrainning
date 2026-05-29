package day4;

public class Main {
	public static void main(String[] args) {
		PaitentService ps= new PaitentService();
		Paitent p1= new Paitent();
		p1.setId(1);
		p1.setName("Sagnik");
		p1.setAge(23);
		p1.setIllness("fever");
		
		Paitent p2 = new Paitent();
		p2.setId(2);
		p2.setName("Ram");
		p2.setAge(25);
		p2.setIllness("heart");
		
		ps.registerPaitent(p1);
		ps.registerPaitent(p2);
		
		ps.showPaitent(p1.getId());
		ps.showPaitent(p2.getId());
		
		Doctors d1 = new Doctors("Ganesh","general");
		Doctors d2 = new Doctors("Ramesh","cardiologist");
		
		d1.diagnose(p1);
		d2.diagnose(p1);
		
		d1.diagnose(p2);
		d2.diagnose(p2);
	}
}
