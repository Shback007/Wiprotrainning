package com.sdet;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhpTravelsFlightBooking {

    static WebDriver driver;
    static WebDriverWait wait;

    public static void main(String[] args) throws InterruptedException {
    	
        driver = new EdgeDriver();

        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));


        driver.get("https://phptravels.net/");
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acknowledgeDemoWarning"))).click();
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/div[1]/div/div[2]/div[2]/button/span[1]"))).click();
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/div[1]/div/div[2]/div[2]/div[2]/div/a[7]"))).click();
        
        WebElement flightTab = wait.until(
                ExpectedConditions.elementToBeClickable(
                		By.xpath("(//button[@role='tab'])[3]")));

        flightTab.click();

        
        WebElement from = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//input[@x-ref='fromInput']")));

        from.click();
        from.sendKeys("Delhi");
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(text(),'Delhi')]"))).click();
    

        WebElement to = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//input[@x-ref='toInput']")));

        to.click();
        to.sendKeys("Mumbai");

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(text(),'Mumbai')]"))).click();

        WebElement date = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.name("flights_departure_date")));

        date.click();
        WebElement day = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("/html/body/div[7]/div[1]/table/tbody/tr[5]/td[4]/div")));

        day.click();
        
        
        WebElement traveller = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//input[@name='passengers']/following-sibling::div")));

        traveller.click();
        
        WebElement adultPlus = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("/html/body/div[2]/div[3]/div/div/div[3]/div/div/form/div[3]/div[2]/div/div[2]/div[1]/div[2]/button[2]")));

        
        WebElement childPlus = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("/html/body/div[2]/div[3]/div/div/div[3]/div/div/form/div[3]/div[2]/div/div[2]/div[2]/div[2]/button[2]")));
        
        int adults = 3;
        int children = 2;
        for (int i = 1; i < adults; i++) {

            adultPlus.click();
        }

        
        for (int i = 0; i < children; i++) {

            childPlus.click();
        }
        
        
        wait.until(ExpectedConditions.elementToBeClickable(
        		By.xpath("/html/body/div[2]/div[3]/div/div/div[3]/div/div/form/div[3]/div[3]/button")))
        .click();
        
        wait.until(ExpectedConditions.elementToBeClickable(
        		By.xpath("/html/body/div[2]/div/div/div[3]/div/main/div[2]/div[2]/div[1]/div/div[1]/div[2]/div[1]/div[3]/button")))
        .click();
        
        Thread.sleep(50000000);
     

        driver.quit();
    }
}