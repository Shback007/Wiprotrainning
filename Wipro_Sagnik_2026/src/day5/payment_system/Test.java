package day5.payment_system;

import java.util.Scanner;

public class Test implements UPI,CreditCard, Cash {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Test obj = new Test();
		System.out.println("Enter how you want to pay: ");
		 while (true) {
	            System.out.println("\nChoose payment method:");
	            System.out.println("1. UPI");
	            System.out.println("2. Credit Card");
	            System.out.println("3. Cash");
	            System.out.println("4. Cancel Transaction");
	            int choice = sc.nextInt();
	            if (choice == 4) {
	                System.out.println("Transaction Cancelled");
	                break;
	            }
	            if (choice < 1 || choice > 4) {
	                System.out.println("Invalid choice. Try again.");
	                continue;
	            }
	            if (choice == 1) {
	                UPI.upi();
	                obj.useUPI();
	                System.out.print("Enter amount: ");
		            int amt = sc.nextInt();
	                obj.pay(amt);
	                break;
	            } 
	            else if (choice == 2) {
	                CreditCard.cc();
	                obj.usecc();
	                System.out.print("Enter amount: ");
		            int amt = sc.nextInt();
	                obj.paycc(amt);
	                break;
	            } 
	            else if (choice == 3) {
	                Cash.cash();
	                obj.useCash();
	                System.out.print("Enter amount: ");
		            int amt = sc.nextInt();
	                obj.payCash(amt);
	                break;
	            }
	        }
		 sc.close();
	}
	@Override
	public void pay(int amount) {
		System.out.println("Payment of "+amount+ " done through UPI");
	}
	@Override
	public void paycc(int amount) {
		System.out.println("Payment of "+amount+" done through Credit Card");
	}
	@Override
	public void payCash(int amount) {
		System.out.println("Payment of "+amount+" done through Cash");
	}

}
