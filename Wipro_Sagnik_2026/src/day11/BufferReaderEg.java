package day11;
import java.io.*;
public class BufferReaderEg {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/day11/sagnik.txt"));
			String line;
			
			while((line = br.readLine())!=null) {
				System.out.println(line);
			}
			br.close();
		}catch(IOException e) {
			System.out.println(e);
		}
	}
}
