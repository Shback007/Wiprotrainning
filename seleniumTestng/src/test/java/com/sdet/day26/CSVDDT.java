package com.sdet.day26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CSVDDT {

    static WebDriver driver;

    public static void main(String[] args)throws IOException,InterruptedException {

        InputStream fis =CSVDDT.class.getClassLoader().getResourceAsStream("users.csv");

        BufferedReader br =new BufferedReader(new InputStreamReader(fis));

        String line;
        br.readLine();
        
        while((line = br.readLine()) != null) {

         
            String[] data =line.split(",");

            String username =data[0];

            String password =data[1];


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

        br.close();
    }
}