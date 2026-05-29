package day3;

public class Bank {
	public static void main(String[] args) {
		BankDetails b1= new BankDetails();
		
		b1.name="Sagnik";
		b1.Deposit(20000);
		b1.getBalance();
		b1.withdraw(1000);
		b1.getBalance();
	}
}
class BankDetails{
	String name;
	private double balance=0;
	
	public void Deposit(double balance) {
		this.balance+=balance;
	}
	
	public void withdraw(double balance) {
		if (balance>this.balance)
			System.out.println("Insufficient balance");
		else {
			this.balance-=balance;
		}
	}
	public void getBalance() {
		System.out.println("Current Balance is: " +this.balance);
	}
}
