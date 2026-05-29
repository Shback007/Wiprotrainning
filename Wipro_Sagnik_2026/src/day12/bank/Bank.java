package day12.bank;

import java.io.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Bank implements Serializable{
	private long acc_no;
	private String name;
	private double balance;
	
	ArrayList<String> transaction= new ArrayList<>();
	
	Bank(long acc_no, String name, double balance){
		this.acc_no = acc_no;
		this.name = name;
		this.balance = balance;
	}
	
	public void deposit(double amount) {
		if(amount <= 0) {
	        transaction.add("Failed Deposit Attempt(Invalid Amount): " + amount+"| Balance: "+balance);
	        return;
	    }
		balance+=amount;
		transaction.add("Depositted: " + amount + " | Balance: " +balance);
	}
	
	public void withdraw(double amount) {
		if(amount <=0) {
			transaction.add("Failed WIthdrawl Attempt(Invalid Amount): " + amount+" | Balance: " +balance);
			return;
		}
		if(amount > balance) {
			transaction.add("Failed WIthdrawl Attempt(Insufficient Balance): " + amount+" | Balance: " +balance);
			return;
		}
		else {
			balance-=amount;
			transaction.add("Withdrawn: " +amount+" | Balance: " +balance);
		}
	}
	
	public void showDetails() {
		System.out.println("Account No: " + acc_no);
		System.out.println("Name: " + name);
		System.out.println("Balance: " + balance);
		
		System.out.println("\nTransaction History");
		for(String t : transaction) {
			System.out.println(t);
		}
	}
}
