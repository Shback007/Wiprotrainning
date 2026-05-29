package day3;

public class Car {
	public static void main(String[] args) {
		CarDetails c1= new CarDetails();
		c1.setEngineStatus(true);
		c1.setSpeed(140);
		c1.setFuelLevel(25);
		c1.getDetails();
		
	}
}

class CarDetails{
	private boolean enginestatus;
	private int speed;
	private int fuelLevel;
	
	public void setEngineStatus(boolean status) {
		this.enginestatus=status;
	}
	public void setSpeed(int speed) {
		this.speed=speed;
	}
	public void setFuelLevel(int fuel) {
		this.fuelLevel=fuel;
	}
	
	public void getEngineStatus() {
		System.out.println(this.enginestatus);
	}
	public void getSpeed() {
		System.out.println(this.speed);
	}
	public void getFuelLevel() {
		System.out.println(this.fuelLevel);
	}
	public void getDetails() {
		this.getEngineStatus();
		this.getSpeed();
		this.getFuelLevel();
	}
}
