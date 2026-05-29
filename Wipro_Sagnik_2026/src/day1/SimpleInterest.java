package day1;
import java.util.Scanner;
public class SimpleInterest {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter Principal:");
		int principal = sc.nextInt();
		
		System.out.print("Enter rate:");
		float rate = sc.nextFloat();
		
		System.out.print("Enter Time (in years):");
		int time = sc.nextInt();
		
		double SI =(principal * rate * time)/100;
		System.out.println("Simple Interest is: ");
		
		System.out.println(SI);
		sc.close();
	}

}
