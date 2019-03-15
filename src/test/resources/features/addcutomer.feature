
Feature: Add Customer Feature

@wip
 Scenario: Save Customer
 Given that when I goto add customer page
 When I entered all the required information and submit
 Then Customer is saved
 
@wip
Scenario: Show Error messages 
 Given that when I goto add customer page
 When I skipped contact person mandatory fields to enter
 Then I should get "Contact Person" required error when I submit the details
 
