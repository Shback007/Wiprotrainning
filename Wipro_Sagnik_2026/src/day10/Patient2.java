package day10;

 public class Patient2{
	private int id;
	private String name;
	public Patient2(int id,String name) {
		this.id = id;
		this.name= name;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "ID :" +id + ", Name: " + name;
	}
	
}

