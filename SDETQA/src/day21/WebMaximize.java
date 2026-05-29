package day21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebMaximize {
	public static void main(String[] args) throws InterruptedException{
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.google.com");
		
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		System.out.println(driver.getTitle());
		driver.quit();
	}
}
