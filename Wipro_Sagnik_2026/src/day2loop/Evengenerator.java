package day2loop;
import java.util.Scanner;
public class Evengenerator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number:");
		int n= sc.nextInt();
		int i = 2;
		while (i < n) {
		    System.out.println(i);
		    i += 2;
		}
		sc.close();
	}
}
