package day3;

public class EmpSal {
	public static void main(String[] args) {
		Employee e1= new Employee();
		e1.name="Sagnik Hore";
		e1.age=23;
		e1.setSalary(25000);
		e1.printdetails();
	}

}
class Employee{
	String name;
	int age;
	private double salary;
	public void setSalary(double salary) {
		this.salary=salary;
	}
	public void getSalary() {
		System.out.println("Salary is: "+ this.salary);
	}
	public void printdetails() {
		System.out.println(this.name);
		System.out.println(this.age);
		this.getSalary();
	}
}
