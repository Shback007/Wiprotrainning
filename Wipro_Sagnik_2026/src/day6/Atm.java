package day6;

import java.util.Scanner;

@SuppressWarnings("serial")
class InvalidPinException extends Exception{
	public InvalidPinException(String message) {
		super(message);
	}
}

class InsertAtm{
	private int correctPin;
	InsertAtm(){
		correctPin=5434;
	}
	
	void insertCard() {
		System.out.println("Card Inserted");
	}
	
	void enterPin(int pin) throws InvalidPinException{
		if(pin!=correctPin) {
			throw new InvalidPinException("Incorrect Pin");
		}else {
			System.out.println("Pin Verified");
		}
	}
}

public class Atm {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		InsertAtm atm = new InsertAtm();
		try {
			atm.insertCard();
			System.out.print("Enter PIN: ");
			int pin = sc.nextInt();
			atm.enterPin(pin);
			System.out.println("Transaction sucessfull");
		}catch(InvalidPinException e){
			System.out.println("Exception: " +e.getMessage());
		}finally {
			System.out.println("Transaction Logged");
			sc.close();
		}
	}
}
