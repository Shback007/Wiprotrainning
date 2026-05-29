package com.stepdefinition;

import com.base.BaseClass;

import io.cucumber.java.en.*;

public class LoginSteps extends BaseClass {

    @Given("user launches browser")
    public void launch_browser() {

        System.out.println("Browser launched successfully");
    }

    @Given("user opens login page")
    public void open_login_page() {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        System.out.println("Application opened");
    }

    @When("user enter username {string}")
    public void enter_username(String username) {

        System.out.println("Username: " + username);
    }

    @When("user enter password {string}")
    public void enter_password(String password) {

        System.out.println("Password: " + password);
    }

    @When("clicks on login button")
    public void enter_login() {

        System.out.println("Clicked login button");
    }

    @Then("user should navigate to dashboard")
    public void dashboard() {

        System.out.println("Dashboard Displayed");
    }

    @Then("error message should display")
    public void error_message() {

        System.out.println("Invalid credentials");
    }
}