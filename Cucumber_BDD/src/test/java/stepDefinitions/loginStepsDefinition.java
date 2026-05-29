package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;

public class loginStepsDefinition {
	
	static WebDriver driver;
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	   driver=new EdgeDriver();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   
	   driver.get("https://www.saucedemo.com/");
	}

	@When("User enters valid username and password")
	public void user_enters_valid_username_and_password() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.id("user-name")).sendKeys("standard_user");
	    
	    driver.findElement(By.id("password")).sendKeys("secret_sauce");
	}

	@And("Clicks on Login Button")
	public void clicks_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.id("login-button")).click();
	}

	@Then("user is navigated to Home Page")
	public void user_is_navigated_to_home_page() {
		
		WebElement text = driver.findElement(By.xpath("//div[@class='app_logo']"));
		
		Assert.assertEquals(text.getText(), "Swag Labs","User is in home page");
			
	    Assert.assertTrue(driver.findElements(By.xpath("//div[@class='app_logo']")).size()>0,"User is in home page");
	}

	@And("Close the browser")
	public void close_the_browser() {
	    driver.quit();
	}



}
