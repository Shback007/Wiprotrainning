Feature: This is Background Demo


Background: User is logged in to saucedemo app
Given  User is accessing saucedemo login page
When User enters valid username and password
Then User should be able to navigate to Home Page


Scenario: Test Menu Items

And Clicks on breadcrum icon
Then User should be able to see the menu items

Scenario: Verify add to cart functionality

And Clicks on Add to button
Then Items should be addeed to the cart
 