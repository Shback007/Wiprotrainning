package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/*@CucumberOptions(tags="", 
features= {"src/test/resources/background/background.feature"},
glue= {"backgroundStepDefinitions"},

plugin= {"pretty","html:target/htmlreport.html"}
)

*/

public class TestRunnerBackground extends AbstractTestNGCucumberTests{

}
