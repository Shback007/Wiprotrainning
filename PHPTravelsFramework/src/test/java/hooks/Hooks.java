package hooks;

import org.openqa.selenium.WebDriver;

import base.DriverFactory;

import io.cucumber.java.*;

import io.cucumber.java.Scenario;

import utilities.*;

import com.aventstack.extentreports.*;

public class Hooks {

    static ExtentReports extent =ExtentManager.getInstance();

    static ExtentTest test;

    @Before
    public void setup(Scenario scenario) {

        test =extent.createTest(scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {

        WebDriver driver =DriverFactory.getDriver();

        if(scenario.isFailed()) {

            String path =ScreenshotUtility.captureScreenshot(
                            driver,
                            scenario.getName());

            test.fail("Test Failed").addScreenCaptureFromPath(path);

        } else {

            test.pass("Test Passed");
        }

        extent.flush();

        DriverFactory.quitDriver();
    }
}