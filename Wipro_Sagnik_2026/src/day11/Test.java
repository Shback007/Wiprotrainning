package day11;
import java.io.*;
public class Test {
	public static void main(String[] args){
		try{
			FileWriter fw=new FileWriter("src/day11/sagnik.txt");
			fw.write("Hello Java IO ");
			fw.write("Hi, My Name is Sagnik");
		
			fw.close();
			System.out.println("File written successfully");
		}
		catch(IOException e){
			System.out.println("Error occurred: " + e.getMessage());
		}
}
}
