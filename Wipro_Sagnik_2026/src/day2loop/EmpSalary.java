package day2loop;
import java.util.*;
public class EmpSalary {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no. of Employees:");
		int n = sc.nextInt();
		double[]salaries =new double[n];
		
		for(int i=0;i<n;i++) {
			System.out.print("Enter salary for Employee " + (i+1) + " :");
			salaries[i]=sc.nextDouble();
		}
		double increment=0.20;
		for(int i=0;i<n;i++) {
			salaries[i]=salaries[i]+salaries[i]*increment;
		}
		for(int i=0;i<n;i++) {
			System.out.print("New Salary of " + (i+1) + ": " );
			System.out.println(salaries[i]);
		}
		sc.close();
	}
	
}
