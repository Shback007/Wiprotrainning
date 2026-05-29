package day4;

import java.util.HashMap;
interface Paitentserv{
	void registerPaitent(Paitent p);
	void showPaitent(int id);
}
class PaitentService implements Paitentserv {
	
	HashMap<Integer,Paitent> map = new HashMap<>();
	int count=0;
	public void registerPaitent(Paitent p) {
		map.put(p.getId(),p);
		System.out.println("Paitent Registered");
	}
	public void showPaitent(int id) {
		Paitent p = map.get(id);
		if(p!= null) {
			System.out.println("------------------------");
			System.out.println("Paitent ID  : " + p.getId());
			System.out.println("Name : " +p.getName());
			System.out.println("Age : "+ p.getAge());
			System.out.println("Illness: "+p.getIllness());
			System.out.println("-------------------------");
		}else {
			System.out.println("No Paitent registered");
		}
	}

}
