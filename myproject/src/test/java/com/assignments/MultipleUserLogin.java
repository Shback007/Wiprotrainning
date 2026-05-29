package com.assignments;

import java.time.Duration; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver; 
import org.testng.Assert; 
import org.testng.annotations.AfterSuite; 
import org.testng.annotations.BeforeSuite; 
import org.testng.annotations.DataProvider; 
import org.testng.annotations.Test; 
import io.github.bonigarcia.wdm.WebDriverManager; 
// Extent Report 
import com.aventstack.extentreports.ExtentReports; 
import com.aventstack.extentreports.ExtentTest; 
import com.aventstack.extentreports.reporter.ExtentSparkReporter; 
// Log4j2 
import org.apache.logging.log4j.LogManager; 
import org.apache.logging.log4j.Logger; 
public class MultipleUserLogin { 
    // Logger 
    static Logger log = 
            LogManager.getLogger(MultipleUserLogin.class); 
    // Extent Report 
    static ExtentReports extent; 
    // Report Setup 
    @BeforeSuite 
    public void setupReport() { 
        // Create Spark Report 
        ExtentSparkReporter spark = 
                new ExtentSparkReporter("ExtentReport.html"); 
        // Attach Report 
        extent = new ExtentReports(); 
        extent.attachReporter(spark); 
        System.out.println("Extent Report Initialized"); 
        log.info("Extent Report Initialized"); 
    } 
    // DataProvider 
    @DataProvider(name = "LoginData") 
    public Object[][] getData() { 
       return new Object[][] { 
               { "admin", "admin123" }, 
                { "user", "user123" }, 
                {"test","test123"}, 
                { "student", "Password123" } 
 
        }; 
    } 
    // Test Method 
    @Test(dataProvider = "LoginData")
    public void loginTest(String Username,
                          String Password)
            throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        try {

            ExtentTest test =
                    extent.createTest(
                            "Login Test : " + Username);

            driver.manage().window().maximize();

            driver.manage().timeouts()
                    .implicitlyWait(Duration.ofSeconds(10));

            driver.get(
                    "https://practicetestautomation.com/practice-test-login/");

            driver.findElement(By.id("username"))
                    .sendKeys(Username);

            driver.findElement(By.id("password"))
                    .sendKeys(Password);

            driver.findElement(By.id("submit"))
                    .click();

            Thread.sleep(2000);

            String currentURL =
                    driver.getCurrentUrl();

            if(currentURL.contains(
                    "logged-in-successfully")) {

                test.pass("Login Successful");

            } else {

                test.fail("Login Failed");
            }

            Assert.assertTrue(
                    currentURL.contains(
                            "logged-in-successfully"),
                    "Login Failed");

        }

        finally {

            driver.quit();

            System.out.println("Browser Closed");

            log.info("Browser Closed");
        }
    }
    // Flush Report 
    @AfterSuite 
   public void closeReport() { 
        extent.flush(); 
        System.out.println( 
                "Extent Report Generated"); 
        log.info( 
                "Extent Report Generated"); 
    } 
} 