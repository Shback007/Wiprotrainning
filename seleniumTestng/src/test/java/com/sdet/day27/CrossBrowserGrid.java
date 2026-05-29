package com.sdet.day27;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;

import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserGrid {

    WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws Exception {

     
        String gridURL = "http://localhost:4444";

        if(browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();

            driver = new RemoteWebDriver(
                    new URL(gridURL),
                    options);

        }
        else if(browser.equalsIgnoreCase("edge")) {

            EdgeOptions options = new EdgeOptions();

            driver = new RemoteWebDriver(
                    new URL(gridURL),
                    options);
        }

        driver.manage().timeouts()
              .implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");
    }

    @Test(priority = 1)
    public void verifyLoginPageTitle() {

        String actTitle = driver.getTitle();

        Assert.assertEquals(actTitle, "Swag Labs");

        System.out.println(
                "Title Validation Passed by Thread: "
                + Thread.currentThread().getId());
    }

    @Test(priority = 2)
    @Parameters({"username", "password"})
    public void loginTest(String uname, String pass) {

        driver.findElement(By.id("user-name"))
              .sendKeys(uname);

        driver.findElement(By.id("password"))
              .sendKeys(pass);

        driver.findElement(By.id("login-button"))
              .click();

        String currentURL = driver.getCurrentUrl();

        Assert.assertTrue(currentURL.contains("inventory"));

        System.out.println(
                "Login Successful by Thread: "
                + Thread.currentThread().getId());
    }

    @Test(priority = 3)
    public void verifyProductPage() {

        String productText =
                driver.findElement(By.className("title"))
                      .getText();

        Assert.assertEquals(productText, "Products");

        System.out.println(
                "Product Page Passed by Thread: "
                + Thread.currentThread().getId());
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
    	
    	Thread.sleep(20000);
        System.out.println(
                "Closing Browser by Thread: "
                + Thread.currentThread().getId());

        driver.quit();
    }
}