package day10;

import java.util.ArrayList;
import java.util.Arrays;

public class MegingList {
	public static void main(String[] args) {
		ArrayList<String> list1 = new ArrayList<>(Arrays.asList("Sagnik", "Arpan"));
		ArrayList<String> list2 = new ArrayList<>(Arrays.asList("Arpan","Arijit","Kumar"));
		ArrayList<String> list3 = new ArrayList<>();
		for(String s :list1) {
			if(!list3.contains(s)) {
				list3.add(s);
			}
		}
		for(String s :list2) {
			if(!list3.contains(s)) {
				list3.add(s);
			}
		}
		System.out.println(list3);
		
	}
	

}
