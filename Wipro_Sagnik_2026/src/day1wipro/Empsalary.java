package day1wipro;

public class Empsalary {
    public static void main(String[] args) {

        String name = "Sagnik";
        int salary = 30000;
        int bonus = 2000;
        double tax = 0.15;

        double netsalary = salary + bonus - (tax * salary);

        System.out.print("Net salary of " + name + " is: ");
        System.out.println(netsalary);
    }
}