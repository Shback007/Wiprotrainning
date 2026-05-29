package com.assignments;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CompleteAutomationDemo {

    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        // 1. TEXT FIELD

        driver.findElement(By.id("userName")).sendKeys("Sagnik Hore");
        driver.findElement(By.id("userEmail")).sendKeys("shback007@gmail.com");
        driver.findElement(By.id("currentAddress")).sendKeys("Kolkata, West Bengal, India");
        driver.findElement(By.id("permanentAddress")).sendKeys("Kolkata, West Bengal, India");
        Thread.sleep(2000);

        // 8. SCROLL PAGE

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        // 2. BUTTON

        driver.findElement(By.id("submit")).click();
        Thread.sleep(2000);

        // 3. RADIO BUTTON

        driver.get("https://demoqa.com/radio-button");

        driver.findElement(By.id("yesRadio")).click();
        driver.findElement(By.id("impressiveRadio")).click();
        Thread.sleep(2000);

        // 7. CHECK BOX

        driver.get("https://demoqa.com/checkbox");

        WebElement element = driver.findElement(By.className("rc-tree-checkbox"));
		element.click();
		Thread.sleep(3000);

        // 5. DROPDOWN BUTTON

        driver.get("https://demoqa.com/select-menu");

        driver.findElement(By.id("react-select-2-input")).sendKeys("Group 1, option 1");
        driver.findElement(By.id("react-select-2-input")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("react-select-3-input")).sendKeys("Dr.");
        driver.findElement(By.id("react-select-3-input")).sendKeys(Keys.ENTER);
        WebElement dropdown = driver.findElement(By.id("oldSelectMenu"));
		Select select = new Select(dropdown);		
		select.selectByVisibleText("Purple");
		driver.findElement(By.id("react-select-4-input")).sendKeys("Black");
		driver.findElement(By.id("react-select-4-input")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("react-select-4-input")).sendKeys("Red");
		driver.findElement(By.id("react-select-4-input")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("cars")).sendKeys("Audi");
		Thread.sleep(5000);

        // 5. List Box

		driver.findElement(By.id("cars")).sendKeys("Audi");
		Thread.sleep(5000);

        // 6. IMAGE HANDLING
		
        driver.get("https://demoqa.com/broken");

        WebElement image = driver.findElement(By.xpath("//img[@src='/images/Toolsqa.jpg']"));

        if(image.isDisplayed()) {
            System.out.println("Image is displayed successfully");
        }
        else {
            System.out.println("Image is not displayed");
        }

        Thread.sleep(2000);

        // =============================
        // 10. ACTIONS CLASS
        // =============================

        Actions act = new Actions(driver);

        // DOUBLE CLICK
        driver.get("https://demoqa.com/buttons");

        WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));
        act.doubleClick(doubleClick).perform();

        Thread.sleep(2000);

        // RIGHT CLICK
        WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
        act.contextClick(rightClick).perform();

        Thread.sleep(2000);

        // DYNAMIC CLICK
        WebElement dynamicClick = driver.findElement(By.xpath("//button[text()='Click Me']"));
        dynamicClick.click();

        Thread.sleep(2000);

        // MOUSE HOVER
        driver.get("https://demoqa.com/menu");

        WebElement menu = driver.findElement(By.xpath("//a[text()='Main Item 2']"));
        act.moveToElement(menu).perform();

        Thread.sleep(2000);

        // DRAG AND DROP
        driver.get("https://demoqa.com/droppable");

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        act.dragAndDrop(source, target).perform();

        Thread.sleep(2000);

        // SLIDER
        driver.get("https://demoqa.com/slider");

        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));

        act.dragAndDropBy(slider, 50, 0).perform();

        Thread.sleep(2000);

        // 11. ALERT HANDLING

        driver.get("https://demoqa.com/alerts");

        // SIMPLE ALERT
        
        driver.findElement(By.id("alertButton")).click();
        Alert alert1 = driver.switchTo().alert();
        System.out.println(alert1.getText());
        alert1.accept();
        Thread.sleep(2000);
        
        // TIMER ALERT
        
        driver.findElement(By.id("timerAlertButton")).click();
        Thread.sleep(5500);
        Alert alert4 = driver.switchTo().alert();
        
        System.out.println(alert4.getText());
        alert4.accept();
        

        // CONFIRMATION ALERT
        
        driver.findElement(By.id("confirmButton")).click();
        Alert alert2 = driver.switchTo().alert();
        System.out.println(alert2.getText());
        alert2.dismiss();
        Thread.sleep(2000);

        // PROMPT ALERT
        driver.findElement(By.id("promtButton")).click();
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("Hello Selenium");
        alert3.accept();
        Thread.sleep(2000);

        // 9. TAKE SCREENSHOT

        TakesScreenshot ts = (TakesScreenshot) driver;

        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        File destinationFile = new File("./Screenshots/finalpage.png");

        FileUtils.copyFile(sourceFile, destinationFile);

        System.out.println("Screenshot captured successfully");

        Thread.sleep(2000);

        // CLOSE BROWSER
        driver.quit();
    }
}