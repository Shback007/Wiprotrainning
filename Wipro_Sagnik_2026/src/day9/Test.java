package day9;

import java.util.HashSet;

class Student{
	int id;
	
	Student(int id){
		this.id = id;
	}
	
	public boolean equals(Object obj) {
		Student s =(Student) obj;
		return this.id ==s.id;
	}
	public int hashCode() {
		return id;
	}
}

public class Test {
	public static void main(String[] args) {
		HashSet<Student> set = new HashSet<>();
		set.add(new Student(1));
		set.add(new Student(1));
		
		System.out.println(set.size());
	}

}
