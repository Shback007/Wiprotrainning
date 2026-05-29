package day1;
import java.util.Scanner;
public class Studentinfosystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Student s1 = new Student();
		
		System.out.print("Enter Name:");
		s1.name=sc.next();
		
		System.out.print("Enter Age:");
		s1.age=sc.nextInt();
		
		System.out.print("Enter number of subjects:");
		int n = sc.nextInt();
		
		s1.marks=new float[n];
		System.out.print("Enter Marks:");
		for(int i=0;i<n;i++) {
			s1.marks[i]=sc.nextFloat();
		}
		System.out.print("Enter Grade:");
		s1.grade=sc.next();
		
		s1.getaverage();
		
		sc.close();
	}
	
}

class Student{
	String name;
	int age;
	float[] marks;
	String grade;
	
	   public void getaverage() {
		float sum =0;
		for(int i=0;i<marks.length;i++) {
			sum+=marks[i];
		}
		float avg=sum/marks.length;
		System.out.print("Average Marks: " + avg);
	}
}
