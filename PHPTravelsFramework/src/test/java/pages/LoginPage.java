package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.WaitUtility;

public class LoginPage {

    WebDriver driver;

    WaitUtility waitUtility;

    // Constructor
    public LoginPage(WebDriver driver) {

        this.driver = driver;

        waitUtility = new WaitUtility(driver);
    }


    By continueBtn = By.id("acknowledgeDemoWarning");

    By email = By.name("email");

    By password = By.name("password");

    By loginBtn = By.xpath("//button[@type='submit']");


    public void clickContinuePopup() {

        waitUtility.waitForClickable(continueBtn);

        driver.findElement(continueBtn).click();
    }

    public void enterEmail(String userEmail) {

        waitUtility.waitForVisible(email);

        driver.findElement(email).clear();

        driver.findElement(email).sendKeys(userEmail);
    }

    public void enterPassword(String userPass) {

        waitUtility.waitForVisible(password);

        driver.findElement(password).clear();

        driver.findElement(password).sendKeys(userPass);
    }

    public void clickLogin() {

        waitUtility.waitForClickable(loginBtn);

        driver.findElement(loginBtn).click();
    }


    public String getCurrentURL() {

        return driver.getCurrentUrl();
    }

    public boolean isDashboardPageDisplayed() {

        return getCurrentURL().contains("dashboard");
    }

    public boolean isLoginPageDisplayed() {

        return getCurrentURL().contains("login");
    }
}