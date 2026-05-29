package day5.payment_system;

import java.util.Scanner;

public final class Security {

     String encrypt(String data) {
		return data;
    }

    public void decrypt(String data) {
        System.out.println("Decrypting data: " + data);
    }
    public static void main(String[] args) {
    	Security s1 = new Security();
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Enter data for encryption:");
    	String ss = sc.next();
    	System.out.println("Encrypting:"+ ss);
		String abc=s1.encrypt(ss);
		s1.decrypt(abc);
		sc.close();
	}
}

//class Administrator extends Security{
//	
//}
