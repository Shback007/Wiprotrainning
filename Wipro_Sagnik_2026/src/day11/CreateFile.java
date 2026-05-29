package day11;
import java.io.*;
public class CreateFile {
	public static void main(String[] args) {
		try {
			File file = new File("src/day11/sagnik.txt");
			System.out.println(file.getAbsolutePath());
			if(file.createNewFile()) {
				System.out.println("File Created: " +file.getName());
			}else {
				System.out.println("File already exists");
			}
		}catch(IOException e) {
			System.out.println(e);
		}
	}
}
