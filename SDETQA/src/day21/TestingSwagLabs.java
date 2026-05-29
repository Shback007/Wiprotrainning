package day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestingSwagLabs{
	public static void main(String[] args)throws InterruptedException  {
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("login-button")).click();
		
		Thread.sleep(2000);
		
		// Add backpack product to cart
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		
		Thread.sleep(2000);
		
		//open cart
		driver.findElement(By.id("shopping_cart_container")).click();
		
		Thread.sleep(2000);
		
		//checkout
		driver.findElement(By.id("checkout")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("first-name")).sendKeys("Sagnik");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("last-name")).sendKeys("Hore");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("postal-code")).sendKeys("700102");
		
		Thread.sleep(2000);
		
		//continue checkout
		driver.findElement(By.id("continue")).click();
		
		//finish order
		driver.findElement(By.id("finish")).click();
		
		
		Thread.sleep(2000);
		
		String confirmationMessage = driver.findElement(By.className("complete-header")).getText();
		
		System.out.println("Order Status:" + confirmationMessage);
		
		Thread.sleep(3000);
		
		driver.quit();
		
	}
}
