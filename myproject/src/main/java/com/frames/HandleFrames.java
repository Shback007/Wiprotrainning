package com.frames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HandleFrames {
	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://demoqa.com/frames");
		
		driver.manage().window().maximize();
		
		
		//frame 1 
//		driver.switchTo().frame("frame1");
		
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@src='/sample.html' and @id='frame1']"));
		
		driver.switchTo().frame(frame1);
		
		System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
		
		
		driver.switchTo().defaultContent();
		
		
		//frame 2
		
//		driver.switchTo().frame("frame2");
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@src='/sample.html' and @id='frame2']"));
		
		driver.switchTo().frame(frame2);
		
		
		
		System.out.println(driver.findElement(By.xpath("//*[@id=\"sampleHeading\"]")).getText());
		
		driver.quit();
	}
}
