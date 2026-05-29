package day1wipro;

public class Simpleinterest {
    public static void main(String[] args) {

        int principal = 10000;
        float rate = 5;
        int time = 2;

        double SI = (principal * rate * time) / 100;

        System.out.println("Simple Interest is: ");
        System.out.println(SI);
    }
}