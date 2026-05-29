package day1;
import java.util.Scanner;
public class Tempconv {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter Temp in celcius:");
		double celcius = sc.nextDouble();
		
		double farhenheit = (celcius * 1.8) +32;
		System.out.print("Temp from celcius to farenheit is: " + farhenheit);
		sc.close();
		
	}
}
