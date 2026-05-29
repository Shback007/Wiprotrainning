package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="", 
		features= {"src/test/resources/Features/login.feature"},
		glue= {"stepDefinitions"},
		
		plugin= {"pretty","html:target/htmlreport.html"}
		)



public class TestRunner extends AbstractTestNGCucumberTests {

}
