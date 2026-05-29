package day3;

public class PaitentInfo {
	public static void main(String[] args) {
		Paitent p1 = new Paitent();

        p1.setName("Sagnik");
        p1.setAge(30);
        p1.setDisease("Flu");

        System.out.println("Patient Name: " + p1.getName());
        System.out.println("Age: " + p1.getAge());
        System.out.println("Disease: " + p1.getDisease());
	}
}

class Paitent{
	private String name;
    private int age;
    private String disease;
    
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getDisease() {
        return disease;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }
    public void setDisease(String disease) {
        this.disease = disease;
    }
}
