Feature: Login page Automation of saucedemo App
Scenario: Check login is successful with valid creds
Given User is on login page
When User enters valid "<username>" and "<password>"
And Clicks on Login Button
Then user is navigated to Home Page
And Close the browser 


Examples:
| username | password |
| standard_user | secret_sauce |
| problem_user | secret_sauce |
| performance_glitch_user | secret_sauce |
| visual_user | secret_sauce |

