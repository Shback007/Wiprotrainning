package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import utilities.ConfigReader;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {

        return driver;
    }

    public static void initDriver() {

        ConfigReader.loadProperties();

        String browser =ConfigReader.getProperty("browser");

        String url =ConfigReader.getProperty("url");

        if(browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();

        driver.get(url);
    }
    
    public static void navigateTo(String urlKey) {

        String url =
                ConfigReader.getProperty(urlKey);

        driver.get(url);
    }

    public static void quitDriver() {

        if(driver != null) {

            driver.quit();
        }
    }
}