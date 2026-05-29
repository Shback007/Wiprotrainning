Feature: PHPTravels Login Module

Scenario Outline: Validate Login Functionality

Given user launches browser

When user enters "<username>" and "<password>"

 And clicks on login button
    
 Then validate login result as "<expected>"

Examples:

| username             | password   | expected |
| user@phptravels.com  | demouser   | success  |
| invalid@gmail.com    | invalid    | failure  |
|                      | demouser   | failure  |
| user@phptravels.com  |            | failure  |