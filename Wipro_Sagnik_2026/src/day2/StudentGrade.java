package day2;
import java.util.*;
public class StudentGrade {
	
	public static void main(String[] args) {
		int marks;
		Scanner Sc= new Scanner(System.in);
		System.out.print("Enter marks: ");
		marks=Sc.nextInt();
		if(marks >=90 ) {
			System.out.println("Grade A");
		}
		else if(marks >=70){
			System.out.println("Grade B");
		}
		else if(marks >=50){
			System.out.println("Grade C");
		}
		else if(marks >=30){
			System.out.println("Grade D");
		}
		else {
			System.out.println("Fail");
		}
		Sc.close();
	}

}
