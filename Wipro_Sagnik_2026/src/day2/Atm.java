package day2;

public class Atm {
	public static void main(String[] args) {
		int balance = 10000;
		int withdraw_amount=10001;
		
		if(withdraw_amount<=balance) {
			System.out.println("Withdraw Sucessfull");
			int newbalance=balance-withdraw_amount;
			System.out.println("Balance Left= "+ newbalance );
		}
		else {
			System.out.println("Insufficent Balance!");
		}
	}
}
