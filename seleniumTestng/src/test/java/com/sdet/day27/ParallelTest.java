package com.sdet.day27;

import org.testng.annotations.Test;

public class ParallelTest {
	
	@Test
	public void loginTest() throws InterruptedException {
		
		System.out.println("Login Test: " +Thread.currentThread().getId());
		
		Thread.sleep(2000);
	}
	
	@Test
	public void searchTest() throws InterruptedException {
		
		System.out.println("Search Test: "+ Thread.currentThread().getId());
		
		Thread.sleep(2000);
	}
	
	@Test
	public void paymentTest() throws InterruptedException {
		
		System.out.println("Payment Test: "+ Thread.currentThread().getId());
		
		Thread.sleep(2000);
	}

}
