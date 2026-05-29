package com.assignments.day21;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SearchFunctionalityTest {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demowebshop.tricentis.com/");
	}
	
	//TC 01 - Valid Search KeyWord
	@Test(priority=1)
	public void validSearchTest() {
		
		driver.findElement(By.id("small-searchterms")).sendKeys("Laptop");
		
		driver.findElement(By.cssSelector("input[value='Search']")).click();
		
		String pageTitle = driver.findElement(By.xpath("//a[normalize-space()='14.1-inch Laptop']")).getText();
		
		Assert.assertTrue(pageTitle.contains("14.1-inch Laptop"));
				
		System.out.println("Valid Search Test Passed");
	}
	
	//TC 02 - No Result Found
	@Test(priority=2)
	public void noResultFoundTest() {
		
		driver.findElement(By.id("small-searchterms")).sendKeys("abcdefgh");
		
		driver.findElement(By.cssSelector("input[value='Search']")).click();
		
		String message = driver.findElement(By.cssSelector(".result")).getText();
		
		Assert.assertTrue(message.contains("No products were found that matched your criteria."));
		
		System.out.println("No Result Found Test Passed");
	}
	
	//TC 03 - Special Characters Input
	@Test(priority = 3)
	public void specialCHaractersSearchTest() {
		
		String chars = "@#$$%^!!#";
		
		driver.findElement(By.id("small-searchterms")).sendKeys(chars);
		
		driver.findElement(By.cssSelector("input[value='Search']")).click();
		
		String input = driver.findElement(By.id("Q")).getAttribute("value");
		
		String message = driver.findElement(By.cssSelector(".result")).getText();
		
		if(input.equals(chars)) {
			
			Assert.assertTrue(message.contains("No products were found that matched your criteria."));
			
			System.out.println("Special Characters Search Test Passed");
		}
		else {
			System.out.println("Test Failed");
		}
	}
	
	//TC 04 - Case Sensitivity
	@Test(priority=4)
	public void caseSensitivityTest() {
		
		driver.findElement(By.id("small-searchterms")).sendKeys("laptop");
		
		driver.findElement(By.cssSelector("input[value='Search']")).click();
		
		String lowerCaseResult =driver.findElement(By.cssSelector(".search-results")).getText();
		 
		driver.navigate().back();
		
		WebElement searchBox = driver.findElement(By.id("small-searchterms"));
		
		searchBox.clear();
		
		searchBox.sendKeys("LAPTOP");
		
		driver.findElement(By.cssSelector("input[value='Search']")).click();
		
		String upperCaseResult = driver.findElement(By.cssSelector(".search-results")).getText();
		
		Assert.assertEquals(lowerCaseResult, upperCaseResult);
		
		System.out.println("Case Sensitivity Test Passed");
				
	}
	
	//TC 05 - Search with Filters
	@Test(priority=5)
	public void searchWithFiltersTest() throws InterruptedException {
		
		driver.findElement(By.id("small-searchterms")).sendKeys("book");
		
		driver.findElement(By.cssSelector("input[value='Search']")).click();
		
		driver.findElement(By.id("As")).click();
		
		driver.findElement(By.id("Cid")).sendKeys("Books");
		
		driver.findElement(By.cssSelector("input[class='button-1 search-button']")).click();
		
		String result = driver.findElement(By.cssSelector(".search-results")).getText();
		
		System.out.println(result);
		
		Assert.assertTrue(result.contains("book") || result.contains("Book"));
		
		System.out.println("Search With Filters Test Passed");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
