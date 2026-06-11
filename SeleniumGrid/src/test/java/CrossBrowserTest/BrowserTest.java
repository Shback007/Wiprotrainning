package CrossBrowserTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.net.URL;
import java.time.Duration;

public class BrowserTest {

    // ✅ ThreadLocal makes it safe to run in parallel
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();

    private static final String GRID_URL = "http://localhost:4444";

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws Exception {

        WebDriver webDriver;

        if (browser.equalsIgnoreCase("Chrome")) {
            ChromeOptions options = new ChromeOptions();
            webDriver = new RemoteWebDriver(new URL(GRID_URL), options);
            System.out.println("Browser opened on Grid: Chrome");

        } else if (browser.equalsIgnoreCase("Edge")) {
            EdgeOptions options = new EdgeOptions();
            webDriver = new RemoteWebDriver(new URL(GRID_URL), options);
            System.out.println("Browser opened on Grid: Edge");

        } else {
            throw new Exception("Unsupported browser: " + browser);
        }

        webDriver.manage().window().maximize();

        // Store in ThreadLocal
        driver.set(webDriver);
        wait.set(new WebDriverWait(webDriver, Duration.ofSeconds(10)));

        driver.get().get("https://www.saucedemo.com/");
    }

    // Helper methods
    public WebDriver getDriver() { return driver.get(); }
    public WebDriverWait getWait() { return wait.get(); }

    @Test
    public void loginTest() {

        // Wait for page to load then enter credentials
        WebElement usernameField = getWait().until(
            ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))
        );
        usernameField.sendKeys("standard_user");

        getDriver().findElement(By.id("password"))
                   .sendKeys("secret_sauce");

        getDriver().findElement(By.id("login-button")).click();

        // ✅ Assert login success
        getWait().until(ExpectedConditions.urlContains("inventory"));

        Assert.assertTrue(
            getDriver().getCurrentUrl().contains("inventory"),
            "Login failed!"
        );

        WebElement header = getWait().until(
            ExpectedConditions.visibilityOfElementLocated(By.className("title"))
        );

        Assert.assertEquals(header.getText(), "Products");
        System.out.println("Login Successful | Browser: " + 
                            getDriver().getTitle());
    }

    @AfterTest
    public void closeBrowser() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove(); // ✅ Clean up ThreadLocal to prevent memory leaks
            System.out.println("Browser Closed");
        }
    }
}
