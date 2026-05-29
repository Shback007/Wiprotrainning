package day21;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;



public class LoadAmazon {
	public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.amazon.in");

		driver.manage().window().maximize();

		Thread.sleep(2000);
		
		FileInputStream fileIn = new FileInputStream("amazonCookies.data");
		ObjectInputStream in = new ObjectInputStream(fileIn);
		
		@SuppressWarnings("unchecked")
		Set<Cookie> cookies = (Set<Cookie>) in.readObject();
		
		in.close();
		fileIn.close();
		
		for(Cookie cookie: cookies) {
			driver.manage().addCookie(cookie);
		}
		driver.navigate().refresh();
		
		Thread.sleep(5000);
		
		System.out.println("Login Restored");
		
		driver.get("https://amzn.in/d/069bZg2d");
		
		Thread.sleep(20000);
		
		driver.quit();
	}

}
