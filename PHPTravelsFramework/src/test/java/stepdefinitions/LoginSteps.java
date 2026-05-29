package stepdefinitions;

import org.testng.Assert;

import base.DriverFactory;
import io.cucumber.java.en.*;
import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage;

    @Given("user launches browser")
    public void user_launches_browser() {

        DriverFactory.initDriver();

        loginPage = new LoginPage(DriverFactory.getDriver());
        
        loginPage.clickContinuePopup();
    }

    @When("user enters {string} and {string}")
    public void user_enters_and(String username, String password) {

        loginPage.enterEmail(username);

        loginPage.enterPassword(password);
    }

    @And("clicks on login button")
    public void clicks_on_login_button() {

        loginPage.clickLogin();
    }

    @Then("validate login result as {string}")
    public void validate_login_result_as(String expected) {

        String currentUrl = DriverFactory.getDriver().getCurrentUrl();

        if(expected.equalsIgnoreCase("success")) {
        	Assert.assertTrue(currentUrl.contains("dashboard"));       	
        }else {
        	Assert.assertTrue(currentUrl.contains("login"));
        }
    }
}