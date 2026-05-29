package stepdefinitions;

import org.testng.Assert;

import base.DriverFactory;

import io.cucumber.java.en.*;

import pages.HotelSearchPage;

public class HotelSearchSteps {

    HotelSearchPage hotelPage;

    @Given("user launches hotel booking page")
    public void user_launches_hotel_booking_page() {

        DriverFactory.initDriver();

        DriverFactory.navigateTo("hotelUrl");

        hotelPage =
                new HotelSearchPage(
                        DriverFactory.getDriver());

        hotelPage.clickContinuePopup();
    }

    @When("user enters destination {string}")
    public void user_enters_destination(String city) {

        hotelPage.enterDestination(city);
    }
    
    @And("user selects nationality {string}")
    public void user_selects_nationality(String nationality) {

        hotelPage.selectNationality(nationality);
    }

    @And("clicks on search button")
    public void clicks_on_search_button() {

        hotelPage.clickSearch();
    }

    @Then("validate hotel search results")
    public void validate_hotel_search_results() {

        int count =hotelPage.getHotelResultsCount();

        System.out.println("Available Hotels: " + count);

        Assert.assertTrue(hotelPage.isSearchResultDisplayed());
    }
}