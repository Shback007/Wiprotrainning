package com.sdet.day26;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DDT2 {

    static WebDriver driver;

    public static void main(String[] args)throws EncryptedDocumentException,IOException,InterruptedException {

        InputStream fis = DDT2.class.getClassLoader().getResourceAsStream("usernames.xlsx");

        Workbook wb =WorkbookFactory.create(fis);

        Sheet sh =wb.getSheet("Sheet1");

        int rows =sh.getLastRowNum();

        DataFormatter formatter =new DataFormatter();

        for(int i = 1; i <= rows; i++) {

            Row row =sh.getRow(i);

            if(row != null) {

                String username =formatter.formatCellValue(row.getCell(0));

                String password =formatter.formatCellValue(row.getCell(1));

                
                driver = new EdgeDriver();

                driver.manage().window().maximize();

                driver.get("https://www.saucedemo.com");
                        	
               
                driver.findElement(By.id("user-name")).sendKeys(username);

               
                driver.findElement(By.id("password")).sendKeys(password);

               
                driver.findElement(By.id("login-button")).click();

                System.out.println("Login Attempted With : " + username);

                Thread.sleep(3000);

                driver.quit();
            }
        }

        wb.close();

        fis.close();
    }
}