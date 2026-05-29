package com.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions
	(
		features=	"src/test/resources/Features/login.feature",
		
		glue= {"com.stepdefinition", "com.hooks",},
		
		
		plugin= {"pretty", 
				"html:target/cucumber-report.html",
				"json:target/cucumber.json"
				},
		
		monochrome=true,
		tags="@Smoke or @Regression")
			
   public class TestRunner extends AbstractTestNGCucumberTests
   {
		
   }