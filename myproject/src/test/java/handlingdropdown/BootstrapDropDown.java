package handlingdropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class BootstrapDropDown {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		driver = new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/select-menu");
	}
	
	@Test(priority=1)
	public void selectValue() {
		WebElement element =driver.findElement(By.xpath("//div[@id='withOptGroup']/div[@class='css-13cymwt-control']"));
		
		element.click();
		List<WebElement> options =
				driver.findElements(By.xpath("//div[@role='option']"));
		
		for(WebElement option: options) {
			System.out.println(option.getText());
		}
		
		driver.findElement(By.xpath("//div[text()='A root option']")).click();
	}
	
	@Test(priority=2)
	public void selectValueSize() {
		WebElement element =driver.findElement(By.xpath("//div[@id='selectOne']/div[@class='css-13cymwt-control']"));
		
		element.click();
		
		List<WebElement> options =
				driver.findElements(By.xpath("//div[@role='option']"));

				System.out.println(options.size());
				
		for(WebElement option: options) {
			System.out.println(option.getText());
			if(option.getText().equals("Dr."))
					option.click();
			
		}
	}
	
	@Test(priority=3)
	public void selectMultipleValue() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"selectMenuContainer\"]/div[7]/div/div/div"));
		
		element.click();
		
		List<WebElement> options = 
				driver.findElements(By.xpath("//div[@role='option']"));
		
		for(WebElement option:options) {
			System.out.println(option.getText());
			
			String op = option.getText();
			
			if(op.equals("Green") || op.equals("Blue"))
				option.click();
		}
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(10000);
		if(driver!=null)
		driver.quit();
	}
}
