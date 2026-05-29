package com.hooks;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks extends BaseClass {
	
	
    @Before
    public void setup() {
    	

        driver = new EdgeDriver();

        driver.manage().window().maximize();

        System.out.println("Browser launched");
    }

    @After
    public void tearDown() {

        if(driver != null) {

            driver.quit();
        }

        System.out.println("Browser Closed");
    }
}