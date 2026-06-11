package handlingdropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;



public class SelectDropDown {
	WebDriver driver;
	
	Select drpCountry;
	
	
	@BeforeMethod
	public void setUp() {
		
		driver = new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement drpCountryEle = driver.findElement(By.xpath("//select[@id='country']"));
		
		drpCountry = new Select(drpCountryEle);
	}
	
	@Test(priority=1)
	public void select_dropDown_byVisibleText() {	
		
		//select option from dropdown by VisibleText	
		drpCountry.selectByVisibleText("France");
					
	}
	@Test(priority=2)
	public void select_dropDown_bySelectByValue() {	
		
		//select option from dropdown by selectbyValue		
		drpCountry.selectByValue("japan");
		
	}
	@Test(priority=3)
	public void select_dropDown_bySelectByIndex() {	
		
		//select option from dropdown by selectbyValue		
		drpCountry.selectByIndex(2);
		
	}
	@Test(priority=4)
	public void select_dropDown_bySelectByContainsVisibleText() {	
		
		//select option from dropdown by SelectByContainsVisibleText		
		drpCountry.selectByContainsVisibleText("pan");
		
	}
	@Test(priority=5)
	public void count_dropdowns() {
		List<WebElement> options = drpCountry.getOptions();
		int count=0;
		for(WebElement option:options) {
			System.out.println(option.getText());
			count++;
		}
		System.out.println("Total Number of Countries are: "+count);
	}
	
	@Test(priority=6)
	public void click() throws InterruptedException {
		
		
		driver.findElement(By.xpath("//ul[@class='pagination']/li[2]")).click();
		
		WebElement clickSection = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[3]/td[4]/input[@type='checkbox']"));
		
		clickSection.click();
		Thread.sleep(2000);
		clickSection.click();
		
	}
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		if(driver!=null)
			driver.quit();
	}
	

}
