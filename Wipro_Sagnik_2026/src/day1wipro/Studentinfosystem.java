package day1wipro;

public class Studentinfosystem {
    public static void main(String[] args) {

        String name = "Sagnik";
        int age = 21;
        float[] marks = {85, 90, 78, 88};
        String grade = "A";

        float sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum += marks[i];
        }

        float avg = sum / marks.length;

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
        System.out.println("Average Marks: " + avg);
    }
}
