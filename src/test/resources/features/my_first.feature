Feature: Login Feature


  
  @smoke
  Scenario: Login with the correct user name
    Given that user goto the login page "https://evening-hamlet-13500.herokuapp.com/login/" 
    When I try to enter username "joyrony@gmail.com" and password "Tenergy@123"
    Then I should be able to login
  
  
  Scenario: Login with the incorrect password
    Given that user goto the login page "https://evening-hamlet-13500.herokuapp.com/login/" 
    When I try to enter username "joyrony@gmail.com" and password "tohutnoehunt"
    Then I should see a login failure message "WRONG EMAIL OR PASSWORD."
    
  Scenario: Login with the no username and incorrect password
    Given that user goto the login page "https://evening-hamlet-13500.herokuapp.com/login/" 
    When I try to enter username "" and password "tohutnoehunt"
    Then I should see a validation failure message "Can't be blank"
    
   Scenario: Login with the no password
    Given that user goto the login page "https://evening-hamlet-13500.herokuapp.com/login/" 
    When I try to enter username "joyrony@gmail.com" and password ""
    Then I should see a validation failure message "Can't be blank"
   

   Scenario: Login with Facebook
  	Given that user goto the login page "https://evening-hamlet-13500.herokuapp.com/login/" 
   	When I try to login with facebook username "dhanya.dijoy@gmail.com" and password "aaryan" 
   	Then I should be able to login
     
    
    Scenario: Login with Google test
    Given that user goto the login page "https://evening-hamlet-13500.herokuapp.com/login/" 
    When I try to login with google username "joyrony@gmail.com" and password "Ammuss02"
    Then I should be able to login
    
    
  
