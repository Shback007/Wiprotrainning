package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="@smoke and @regression and @acceptance or @perf",
		features= {"src/test/resources/FeatureWithTags"},
		glue= {"stepDefinitions"},
		
		plugin= {"pretty","html:target/htmlreport.html"}
		)



public class TestRunnerForTags extends AbstractTestNGCucumberTests {

}
