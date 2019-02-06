
Feature: Customer management feature
  
 
  Scenario: List customer
    Given that I logged into the application
    And go to the list customer
    Then I should see customer list with pagination
  