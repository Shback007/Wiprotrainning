package com.sdet.day26;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.*;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DDT {
	 static WebDriver driver;
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		
		
		FileInputStream fis = new FileInputStream("src/test/resources/usernames.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("Sheet1");
		
		int rows = sh.getLastRowNum();
		
	     DataFormatter formatter = new DataFormatter();
		
		for(int i =1;i<=rows;i++) {
//			String username = sh.getRow(i).getCell(0).getStringCellValue();
//			String password = sh.getRow(i).getCell(1).getStringCellValue();
			
			Row row = sh.getRow(i);
			  if (row != null) {
	                String Username =
	                        formatter.formatCellValue(row.getCell(0));
	                String Password =
	                        formatter.formatCellValue(row.getCell(1));
			  
			
	                driver= new EdgeDriver();
			
	                driver.get("https://www.saucedemo.com");
			
	                driver.findElement(By.id("user-name")).sendKeys(Username);
			
	                driver.findElement(By.id("password")).sendKeys(Password);
			
	                driver.findElement(By.id("login-button")).click();
			
	                Thread.sleep(3000);
			
	                driver.quit();
			  }
		}
		wb.close();
		fis.close();
		 
	}

}
