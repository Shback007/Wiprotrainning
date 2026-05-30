package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.LoginPage;

public class POMLoginStepDefinition {
	WebDriver driver;
	LoginPage login;
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	   driver=new EdgeDriver();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   
	   driver.get("https://www.saucedemo.com/");
	}

	@When("User enters valid {string} and {string}")
	public void user_enters_valid_username_and_password(String username, String password) {
	    // Write code here that turns the phrase above into concrete actions
	    login = new LoginPage(driver);
	    login.enterUsername(username);
	    login.enterPass(password);
	}

	@And("Clicks on Login Button")
	public void clicks_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
	    login = new LoginPage(driver);
	    login.clickLogin();
	}

	@Then("user is navigated to Home Page")
	public void user_is_navigated_to_home_page() {
		login.isLogoDisplayed();		
	}

	@And("Close the browser")
	public void close_the_browser() {
	    driver.quit();
	}
}
