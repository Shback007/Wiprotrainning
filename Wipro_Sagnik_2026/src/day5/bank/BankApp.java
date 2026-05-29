package day5.bank;

public class BankApp {
	public static void main(String[] args) {
		Customer c1= new Customer(921010026201699L, "Sagnik");
		
		System.out.println("Account Number: "+c1.getAccountNumber());
		System.out.println("Name: " + c1.getName());
		
		c1.setName("Ram");
		System.out.println("Updated Name: " + c1.getName());
	}

}
