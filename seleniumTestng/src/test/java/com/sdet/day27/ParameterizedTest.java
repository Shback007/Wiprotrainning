package com.sdet.day27;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizedTest {

    @Test
    @Parameters({"username", "password"})
    public void loginTest(String uname, String pass) {

        System.out.println("Username: " + uname);
        System.out.println("Password: " + pass);
    }
    
}