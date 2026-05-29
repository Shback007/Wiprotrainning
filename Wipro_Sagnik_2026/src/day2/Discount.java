package day2;

public class Discount {
	public static void main(String[] args) {
		double price=9999;
		double discount;
		
		if(price <5000) {
			System.out.println("Sorry No Discount");
			System.out.println("Your price is: " +price);
		}
		else if(price <7500) {
			discount=0.05;
			price = price-discount*price;
			System.out.println("Your price is: "+ price);
		}
		else if(price <10000) {
			discount=0.1;
			price = price-discount*price;
			System.out.println("Your price is: "+ price);
		}
		else {
			discount=0.15;
			price = price-discount*price;
			System.out.println("Your price is: "+ price);
		}
		
	}

}
