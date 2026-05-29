package rest;

import org.testng.Assert;
import org.testng.annotations.*;
import static io.restassured.RestAssured.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.ExcelUtil;

public class UserAPITest {
	
	ExtentReports extent;
	
	@BeforeSuite
	public void setupReport() {
		
		ExtentSparkReporter reporter = new ExtentSparkReporter("reports/ExtentReport.html");
		
		extent = new ExtentReports();
		
		extent.attachReporter(reporter);
	}
	
	@Test(priority=1)
	public void getUsers() {
		ExtentTest test = extent.createTest("GET Users API Test");
		test.info("Sending GET Request to Fetch All Users");
		
		try {
			int statusCode = given()
					.when()
					.get("https://dummyjson.com/users")
					.then()
					.log().all()
					.extract()
					.statusCode();
			
			Assert.assertEquals(statusCode, 200);
			
			 test.pass("GET Users API Passed");
	         test.pass("Status Code: " + statusCode);
		}
		catch(Exception e) {
			test.fail("GET Users API Failed");
			test.fail(e.getMessage());
		}
	}
	
	@Test(priority=2)
	public void loginUser() {
		ExtentTest test =extent.createTest("Login API Test");
		test.info("Preparing Login Request Body");
		
		
		try {
			String[] loginData = ExcelUtil.getLoginData();
			test.info("Sending Login API Request");
			
			String username = loginData[0];
	        String password = loginData[1];
	        String age=loginData[2];
	        
	        String requestBody = "{"
	                + "\"username\":\"" + username + "\","
	                + "\"password\":\"" + password + "\","
	                + "\"age\":" + age + ","
	                + "\"expiresInMins\":30"
	                + "}";
	        
			int statusCode = given()
					
					.header("Content-Type", "application/json")			
					.body(requestBody)
					.when()
					.post("https://dummyjson.com/user/login")
					.then()
					.log().all()
					.extract()
					.statusCode();
			
			Assert.assertEquals(statusCode, 200);
			
			test.pass("Login API Passed");
			test.pass("Status Code:" + statusCode);
								
		}catch(Throwable e) {
			test.fail("Login API Failed");
			test.fail(e.getMessage());
		}
	}
	
	@Test(priority=3)
	public void getAuthenticatedUser() {
		
		 ExtentTest test =extent.createTest("Authenticated User API Test");
		 
		 String[] loginData = ExcelUtil.getLoginData();
		 
		 String username = loginData[0];
	     String password = loginData[1];
	     String age=loginData[2];
	     
	     String requestBody = "{"
	    	        + "\"username\":\"" + username + "\","
	    	        + "\"password\":\"" + password + "\","
	    	        + "\"age\":" + age + ","
	    	        + "\"expiresInMins\":30"
	    	        + "}";


		 try {
			 test.info("Generating Access Token");
			 String token = given()
					 .header("Content-Type", "application/json")	 
					 .body(requestBody)
					 .when()
					 .post("https://dummyjson.com/user/login")
					 .then()
					 .extract()
					 .path("accessToken");
			 test.info("Token Generated Successfully");
			 int statusCode = given()
					 .header("Authorization",
							 "Bearer " + token)
					 .when()
					 .get("https://dummyjson.com/user/me")
					 .then()
					 .log().all()
					 .extract()
					 .statusCode();

			 Assert.assertEquals(statusCode, 200);

	         test.pass("Authenticated User API Passed");
	         test.pass("Status Code: " + statusCode);
					 							 
		 } catch (Throwable  e) {
			 test.fail("Authenticated User API Failed");
	          test.fail(e.getMessage());
	          Assert.fail(e.getMessage());
	     }
	}
	
	@Test(priority=4)
	public void getSingleUser() {
		ExtentTest test =extent.createTest("Get Single User API Test");
		
		try {
			test.info("Fetching User With ID = 1");
            int statusCode = given()
                    .when()
                    .get("https://dummyjson.com/users/2")
                    .then()
                    .log().all()
                    .extract()
                    .statusCode();
            Assert.assertEquals(statusCode, 200);

            test.pass("Get Single User API Passed");
            test.pass("Status Code: " + statusCode);
        }
        catch (Exception e) {
            test.fail("Get Single User API Failed");
            test.fail(e.getMessage());
        }
	}
	
	@Test(priority=5)
	public void searchUsers() {
		ExtentTest test = extent.createTest("Search Users API Test");
		
		try {
			test.info("Searching Users With Query = John");
			int statusCode = given()
					.when()
					.get("https://dummyjson.com/users/search?q=John")
					.then()
					.log().all()
					.extract().statusCode();
			
			Assert.assertEquals(statusCode, 200);
			
			test.pass("Search Users API Passed");
			test.pass("Status COde: " + statusCode);
		}catch(Exception e) {
			test.fail("Search Users API Failed");
			test.fail(e.getMessage());
		}
	}
	
	@Test(priority=6)
	public void filterUsers() {
		ExtentTest test = extent.createTest("Filter Users API Test");
		
		try {
			test.info("Filtering Users Where hair.color = Brown");
			int statusCode = given()
					.when()
					.get("https://dummyjson.com/users/filter?key=hair.color&value=Brown")
					.then()
					.log().all()
					.extract()
					.statusCode();
			
			Assert.assertEquals(statusCode, 200);

            test.pass("Filter Users API Passed");
            test.pass("Status Code: " + statusCode);
                  									
		}catch(Exception e) {
			test.fail("Filter Users API Failed");
			test.fail(e.getMessage());
		}
	}
	
	@Test(priority=7)
	public void limitAndSKipUsers() {
		ExtentTest test = extent.createTest("Limit And Skip Users API Test");
		
		try {
			test.info("Applying Pagination Parameters");
			int statusCode = given()
					.when()
					.get("https://dummyjson.com/users?limit=5&skip=10&select=firstName,age")
					.then()
					.log().all()
					.extract()
					.statusCode();
			
			Assert.assertEquals(statusCode, 200);

            test.pass("Limit And Skip Users API Passed");
            test.pass("Status Code: " + statusCode);

        }

        catch (Exception e) {

            test.fail("Limit And Skip Users API Failed");
            test.fail(e.getMessage());
        }
	}
	@Test(priority = 8)
    public void sortUsers() {

        ExtentTest test =extent.createTest("Sort Users API Test");

        try {
        	test.info("Sorting Users By firstName in Ascending Order");
            int statusCode = given()                    
                    .when()
                    .get("https://dummyjson.com/users?sortBy=firstName&order=asc")
                    .then()
                    .log().all()
                    .extract()
                    .statusCode();

            Assert.assertEquals(statusCode, 200);

            test.pass("Sort Users API Passed");
            test.pass("Status Code: " + statusCode);

        }

        catch (Exception e) {

            test.fail("Sort Users API Failed");
            test.fail(e.getMessage());
        }
    }
	
	 @Test(priority = 9)
	    public void getUsersCartById() {

	        ExtentTest test =extent.createTest("Get User Cart API Test");

	        try {
	        	test.info("Fetching Cart Details for User ID = 6");

	            int statusCode = given()	                 
	                    .when()
	                    .get("https://dummyjson.com/users/6/carts")
	                    .then()
	                    .log().all()
	                    .extract()
	                    .statusCode();

	            Assert.assertEquals(statusCode, 200);

	            test.pass("Get User Cart API Passed");
	            test.pass("Status Code: " + statusCode);

	        }

	        catch (Exception e) {

	            test.fail("Get User Cart API Failed");
	            test.fail(e.getMessage());
	        }
	    }

	 @Test(priority = 10)
	    public void getUsersPostsById() {

	        ExtentTest test =extent.createTest("Get User Posts API Test");

	        try {
	        	test.info("Fetching Posts for User ID = 5");

	            int statusCode = given()	                  
	                    .when()
	                    .get("https://dummyjson.com/users/5/posts")
	                    .then()
	                    .log().all()
	                    .extract()
	                    .statusCode();

	            Assert.assertEquals(statusCode, 200);

	            test.pass("Get User Posts API Passed");
	            test.pass("Status Code: " + statusCode);

	        }

	        catch (Exception e) {

	            test.fail("Get User Posts API Failed");
	            test.fail(e.getMessage());
	        }
	 }
	 @Test(priority = 11)
	    public void getUsersTodosById() {

	        ExtentTest test =
	                extent.createTest("Get User Todos API Test");

	        try {
	        	test.info("Fetching Todos for User ID = 5");

	            int statusCode = given()

	                    .when()
	                    .get("https://dummyjson.com/users/5/todos")
	                    .then()
	                    .log().all()
	                    .extract()
	                    .statusCode();

	            Assert.assertEquals(statusCode, 200);

	            test.pass("Get User Todos API Passed");
	            test.pass("Status Code: " + statusCode);

	        }

	        catch (Exception e) {

	            test.fail("Get User Todos API Failed");
	            test.fail(e.getMessage());
	        }
	    }
	 
	 @Test(priority =12)
	 public void addNewUser() {
		 ExtentTest test = extent.createTest("Add New User API Test");
		 
		 try {
			 test.info("Preparing Request Body for New User");
			 int statusCode = given()
					 .header("Content-Type", "application/json")

	                  .body("{"
	                         + "\"firstName\":\"Muhammad\","
	                         + "\"lastName\":\"Ovi\","
	                         + "\"age\":250"
	                         + "}")
	                    .when()
	                    .post("https://dummyjson.com/users/add")
	                    .then()
	                    .log().all()
	                    .extract()
	                    .statusCode();
			 Assert.assertEquals(statusCode, 201);

	         test.pass("Add New User API Passed");
	         test.pass("Status Code: " + statusCode);
	         
		 }catch(Exception e) {
			 test.fail("Add New USer API Failed");
			 test.fail(e.getMessage());
		 }
		 
		 
			 
		 }
		 
	 @Test(priority=13)
	 public void updateUser() {
		 
		 ExtentTest test = extent.createTest("Update User API Test");
		 
		 try {
			 test.info("Updating lastName Field for User ID = 2");
			 int statusCode = given()
					 .header("Content-Type", "application/json")
					 .body("{"
							 + "\"lastName\":\"Owais\""
							 +"}")
					 .when()
					 .put("https://dummyjson.com/users/2")
					 .then()
					 .log().all()
					 .extract()
					 .statusCode();
			 Assert.assertEquals(statusCode, 200);

	          test.pass("Update User API Passed");
	          test.pass("Status Code: " + statusCode);

	      }

	      catch (Exception e) {

	          test.fail("Update User API Failed");
	          test.fail(e.getMessage());
	      }
	}
	 
	 @Test(priority=14)
	 public void deleteUser() {

	     ExtentTest test =extent.createTest("Delete User API Test");

	     try {
	    	 test.info("Deleting User With ID = 1");

	         int statusCode = given()
	                  .when()
	                  .delete("https://dummyjson.com/users/1")
	                  .then()
	                  .log().all()
	                  .extract()
	                  .statusCode();

	         Assert.assertEquals(statusCode, 200);

	         test.pass("Delete User API Passed");
	         test.pass("Status Code: " + statusCode);

	     }

	     catch (Exception e) {

	         test.fail("Delete User API Failed");
	         test.fail(e.getMessage());
	     }
	} 
	
	
	@AfterSuite
	public void tearDownReport() {
		extent.flush();
	}

}
