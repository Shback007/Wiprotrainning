package rest;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class GetUsersTest {

	@Test(priority=1)
	public void getUsers() {
		
		ExtentSparkReporter reporter = new ExtentSparkReporter("reports/ExtentReport.html");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		ExtentTest test = extent.createTest("GET Users API Test");
		
		try {
			int statusCode = given()
					.when().get("https://dummyjson.com/users/")
					.then()
					.log().all()
					.extract().statusCode();
			
			Assert.assertEquals(statusCode, 200);
			
			test.pass("API Test Passed");
			test.pass("Status Code is: " + statusCode);
		
		}
		catch(Exception e) {
			test.fail("API Test Failed");
			test.fail(e.getMessage());
		}
		finally {
			extent.flush();
		}
		
	}
	
}
