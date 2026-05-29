package com.assignments;
import org.testng.annotations.Test;

public class SmokeRegressionTest { 
    // Smoke Test 1 
    @Test(groups = { "Smoke" }) 
    public void loginTest() { 
        System.out.println( 
                "Login Smoke Test Executed"); 
    } 
    // Smoke Test 2 
    @Test(groups = { "Smoke" }) 
    public void homePageTest() { 
        System.out.println( 
                "Home Page Smoke Test Executed"); 
    } 
    // Regression Test 1 
    @Test(groups = { "Regression" }) 
    public void addToCartTest() { 
        System.out.println( 
                "Add To Cart Regression Test Executed"); 
    } 
    // Regression Test 2 
    @Test(groups = { "Regression" }) 
    public void paymentTest() { 
        System.out.println( 
                "Payment Regression Test Executed"); 
    } 
}