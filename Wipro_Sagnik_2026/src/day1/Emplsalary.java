package day1;
import java.util.*;
public class Emplsalary {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Emp e1 = new Emp();
		System.out.print("Enter Employee Name:");
		e1.name=sc.next();
		
		System.out.print("Enter Your Salary:");
		e1.salary=sc.nextInt();
		
		System.out.print("Net salary of "+ e1.name + " is: ");
		e1.getnetsalary();
		
		sc.close();
	}
}

class Emp{
	String name;
	int salary;
	private int bonus=2000;
	private double tax = 0.15;
	
	public void getnetsalary() {
		double netsalary =salary+bonus -(tax*salary);
		System.out.println(netsalary);
	}
}
