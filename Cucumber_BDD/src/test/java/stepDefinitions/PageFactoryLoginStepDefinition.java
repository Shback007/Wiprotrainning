package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageFactory.HomePageFactory;
import pageFactory.LoginPageFactory;

public class PageFactoryLoginStepDefinition {

	static WebDriver driver;

	LoginPageFactory login;

	HomePageFactory home;

	@Given("User is on login page")
	public void user_is_on_login_page() {

		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.saucedemo.com/");

		login = new LoginPageFactory(driver);
		home = new HomePageFactory(driver);
	}

	@When("User enters valid {string} and {string}")
	public void user_enters_valid_username_and_password(String username, String password) {
		// Write code here that turns the phrase above into concrete actions
		login.enterUsername(username);
		login.enterPassword(password);
	}

	@And("Clicks on Login Button")
	public void clicks_on_login_button() {

		login.clickLogin();
	}

	@Then("user is navigated to Home Page")
	public void user_is_navigated_to_home_page() {
		home.isCartDisplayed(); //
		Assert.assertTrue(driver.findElements(By.xpath("//div[@class='app_logo']")).size() > 0, "User is in home page");
	}

	@And("Close the browser")
	public void close_the_browser() {
		driver.quit();
	}

}
