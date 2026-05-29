package pages;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.WaitUtility;

public class HotelSearchPage {

    WebDriver driver;

    WaitUtility waitUtility;

    public HotelSearchPage(WebDriver driver) {

        this.driver = driver;

        waitUtility = new WaitUtility(driver);
    }


    By continueBtn =
            By.id("acknowledgeDemoWarning");

    By destinationField =
            By.xpath("//form[@action='https://phptravels.net/hotels']//input[@placeholder='Search By City']");
  
    By nationalityDropdown =
            By.xpath("//div[@x-data='nationalityDropdown()']//div[contains(@class,'cursor-pointer')]");

    By nationalitySearchBox =
            By.xpath("//input[@placeholder='Search country...']");
    
    By searchBtn =
            By.xpath("/html/body/div[2]/div[3]/div/div/div[1]/div/div/form/div[2]/div[3]/button");

    By hotelResults =
            By.xpath("//div[contains(@class,'rounded-xl')]");



    public void clickContinuePopup() {

        waitUtility.waitForClickable(continueBtn);

        driver.findElement(continueBtn).click();
    }

    public void enterDestination(String city) {

        waitUtility.waitForVisible(destinationField);

        WebElement dest =
                driver.findElement(destinationField);

        dest.sendKeys(city);

        By dynamicCityOption =
                By.xpath("//span[text()='"
                        + city +
                        "']");

        waitUtility.waitForClickable(dynamicCityOption);

        driver.findElement(dynamicCityOption)
                .click();
    }
    
    public void selectNationality(String nationality) {

        // Open dropdown
        waitUtility.waitForClickable(nationalityDropdown);

        driver.findElement(nationalityDropdown)
                .click();

        // Search input
        waitUtility.waitForVisible(nationalitySearchBox);

        WebElement searchBox =
                driver.findElement(nationalitySearchBox);

        searchBox.sendKeys(nationality);

        // Dynamic option
        By dynamicNationality =
                By.xpath("//div[contains(@class,'input-dropdown-item')]//span[text()='"
                        + nationality +
                        "']");

        waitUtility.waitForClickable(dynamicNationality);

        driver.findElement(dynamicNationality).click();
    }
    public void clickSearch() {

        waitUtility.waitForClickable(searchBtn);

        driver.findElement(searchBtn).click();
    }

    public int getHotelResultsCount() {

        List<WebElement> allDivs = driver.findElements(By.tagName("div"));

        return allDivs.size();
    }
    public boolean isSearchResultDisplayed() {

        return getHotelResultsCount() > 0;
    }
}