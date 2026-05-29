package day10;

import java.util.HashMap;

public class HashMap_EX {
	public static void main(String[] args) {
		
		HashMap<Integer, String> map = new HashMap<>();
		
		map.put(101, "Vijay");
		map.put(102, "Sonali");
		map.put(103, "Sohail");
		map.put(104, "Ramu");
		
		System.out.println(map.get(101));
		
		map.remove(103);
		
		for(Integer key: map.keySet()) {
			System.out.println(key + " -> " + map.get(key));
		}
	}

}
