package day21;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TechademyLogin {
public static void main(String[] args) throws InterruptedException, AWTException {
		
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://skill-assist.ai");
		
        driver.manage().window().maximize();

        Thread.sleep(2000);
        
        driver.findElement(By.id("signin-email"))
              .sendKeys(Credentials.email);
        
        Thread.sleep(2000);

        driver.findElement(By.id("signin-password"))
              .sendKeys(Credentials.password);
        
        Thread.sleep(5000);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(15000);
		
		driver.findElement(By.id("radix-:ra:-trigger-live-sessions")).click();
		Thread.sleep(9000);
		
		driver.findElement(By.xpath("//button[contains(text(),'Join Now')]")).click();
		Thread.sleep(5000);
		
		for (String windowHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(windowHandle);
		}
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//button[@data-tid='joinInApp']"))
	      .click();
		
		Thread.sleep(3000);

		// Press Enter on popup 
		Thread.sleep(5000);

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(10000);
		
		driver.quit();
	}
}

