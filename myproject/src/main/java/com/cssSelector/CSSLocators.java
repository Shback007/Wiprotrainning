package com.cssSelector;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


public class CSSLocators {

    public static void main(String[] args) throws InterruptedException {

        EdgeOptions options = new EdgeOptions();

        options.addArguments("--disable-blink-features=AutomationControlled");

        WebDriver driver = new EdgeDriver(options);
    	
    	

        driver.manage().window().maximize();

        driver.get("https://demo.opencart.com/");

        Thread.sleep(15000);
        
        
        //tag id  tag#id
//        driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("T-shirts");
        
        
        //tag class  tag.className
//        driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("Laptop");
        
        //tag attribute tag[attribute=\"value\"]
//        driver.findElement(By.cssSelector("input[placeholder=\"Search store\"]")).sendKeys("Mobile");
        
        //tag class attribute  tag.className[attribute=\"value\"]
        driver.findElement(By.cssSelector("input[name=\"search\"]")).sendKeys("Mobile");
    }
}