package com.sdet;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ResourceBundle;

public class LoadAmazon {
	
	static WebDriver  driver;
	static WebDriverWait wait;
	static ResourceBundle rb = ResourceBundle.getBundle("amz_Cred");
	static String amz_email = rb.getString("amz_email");
	static String amz_pass = rb.getString("amz_pass");
	
	public static void launchBrowser() {
		driver = new EdgeDriver();
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in");
	}
	
	public static void loginAmazon() {
		wait.until(ExpectedConditions
				.elementToBeClickable(
						By.id("nav-link-accountList")))
		.click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("ap_email_login")))
		.sendKeys(amz_email);
		
		
		 driver.findElement(By.id("continue"))
		 .click();
		 
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(
				 By.id("ap_password")))
		 .sendKeys(amz_pass);
		 
		 
		 driver.findElement(By.id("signInSubmit"))
		 .click();
		 
		 
		 System.out.println("Login Successful");
	}
	
	public static void searchProduct(String productName) {
		wait.until(ExpectedConditions
        		.visibilityOfElementLocated(By.id("twotabsearchtextbox")))
        .sendKeys(productName,Keys.ENTER);
		
		System.out.println("Product Searched");
	}
	
	public static void addToCart(String productName) {

	    wait.until(ExpectedConditions
	            .elementToBeClickable(
	                    By.xpath(
	                            "(//span[contains(text(),'" +
	                            productName +
	                            "')]/ancestor::div[@data-component-type='s-search-result']" +
	                            "//button[@name='submit.addToCart'])[1]"
	                    )))
	        .click();

	    System.out.println(productName +
	            " added to cart");
	}
	 public static void goToCart() {
		 wait.until(ExpectedConditions.visibilityOfElementLocated(
			        By.xpath("//a[contains(text(),'Go to Cart')]")))
			    .click();
		 
		 System.out.println("Cart Opened");
	 }
	 
	 public static void proceedToCheckout() {
		  wait.until(ExpectedConditions.elementToBeClickable(
		           By.cssSelector("input[name='proceedToRetailCheckout']")))
		  .click();

		    System.out.println("Proceeding To Checkout");

		    
		   wait.until(ExpectedConditions.elementToBeClickable(
		            By.xpath("//span[contains(.,'Cash on Delivery/Pay on Delivery')]" +
		                     "/ancestor::label[1]" +
		                     "//input[@type='radio']"
		                    )))
		   .click();

		    System.out.println("Cash On Delivery Selected");
		}
	 
	 public static void PlaceOrder() {
		 wait.until(ExpectedConditions.elementToBeClickable(
				 By.cssSelector("input[data-testid='bottom-continue-button']")))
		 .click();
		 
		 wait.until(ExpectedConditions.elementToBeClickable(
				 By.id("placeOrder")))
		 .click();
		 
		 System.out.println("Order Placed Successfully");
		 
	 }
	 
	 public static void closeBrowser() {
		 
		 driver.quit();

	     System.out.println("Browser Closed");
	 }
	
	
    public static void main(String[] args) throws InterruptedException {
        
    	String product = "iPhone 17";
    	
    	launchBrowser();
    	
    	loginAmazon();
          
    	searchProduct(product);
      
    	addToCart(product);
    	
    	goToCart();
    	
    	proceedToCheckout();
        
    	PlaceOrder();
    	
    	Thread.sleep(1000000);
    	
    	closeBrowser();
        
    }
}       
//        WebElement codOption = wait.until(ExpectedConditions.presenceOfElementLocated(
//        		By.xpath(
//                        "//span[contains(.,'Cash on Delivery/Pay on Delivery')]" +
//                        "/ancestor::label[1]" +
//                        "//input[@type='radio']"
//                    ) 
//            ));
//
//        JavascriptExecutor js =
//                (JavascriptExecutor) driver;
//
//        js.executeScript(
//                "arguments[0].scrollIntoView(true);",
//                codOption
//        );
//        Thread.sleep(2000);
//
//        js.executeScript(
//                "arguments[0].click();",
//                codOption
//        );
      
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout-primary-continue-button-id-announce"))).click();
        
     
