Feature: Hotel Search Module

  Scenario: Validate Hotel Search

    Given user launches hotel booking page

    When user enters destination "Dubai"
    
    And user selects nationality "India"

    And clicks on search button

    Then validate hotel search results