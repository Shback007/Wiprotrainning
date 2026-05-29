package day5.bank;

class Customer {
	private final long accountNumber;
	private String name;
	
	public Customer(long accountNumber,String name) {
		this.accountNumber = accountNumber;
		this.name= name;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name= name;
	}


}
