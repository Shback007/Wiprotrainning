package com.sdet.day25;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FlightSearchWait {

	public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

 
        driver.get("https://phptravels.net/");

        System.out.println("Website Opened Successfully");
        
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(Exception.class);
       
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acknowledgeDemoWarning"))).click();


        

        WebElement flightTab = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("/html/body/div[2]/div[3]/div/nav/button[2]")));

        flightTab.click();

        System.out.println("Flights Tab Opened");

        
        WebElement fromCity = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("/html/body/div[2]/div[3]/div/div/div[2]/div/div/form/div[1]/div[1]/div/div[1]/input")));

        fromCity.sendKeys("CCU");


        fromCity.sendKeys(Keys.ARROW_DOWN);
        fromCity.sendKeys(Keys.ENTER);

        System.out.println("Departure City Selected");

       
        WebElement toCity = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[@id='arrival_airport_input']")));

        toCity.sendKeys("DEL");


        toCity.sendKeys(Keys.ARROW_DOWN);
        toCity.sendKeys(Keys.ENTER);

        System.out.println("Arrival City Selected");

       
       
        WebElement searchButton = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//button[contains(.,'Search Flights')]")));

        
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", searchButton);


       
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", searchButton);

        System.out.println("Flight Search Started");


//        Thread.sleep(100);
//        driver.quit();

        System.out.println("Browser Closed Successfully");
    }
}

