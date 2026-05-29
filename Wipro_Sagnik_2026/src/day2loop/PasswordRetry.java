package day2loop;
import java.util.*;
public class PasswordRetry {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String password = "Sagnik1234";
		int attemps =3;
		
		while(attemps != 0) {
			System.out.println("Enter Password");
			String in = sc.nextLine();
			
			if(in.equals(password)) {
				System.out.println("Access Granted");
				break;
			}
			else {
				attemps--;
				if(attemps > 0) {
					System.out.println("Wrong password. Attemps left: " + attemps);
				}else {
					System.out.println("Account locked. No attempts remaining");
				}
			}
		}
		sc.close();
	}
}
