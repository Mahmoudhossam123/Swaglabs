Feature: F01_Login | Users can use the login functionality to access their accounts
  As a user
  I want to log in using various email and password combinations
  So that I can verify the login functionality and error handling
@smoke
  Scenario: Successful login with valid username and password
    Given user navigate to "login" page
    When the user enter a valid username
    And  the user enter a valid password
    Then the user can navigate to the home page
@smoke
    Scenario: Successful login with invalid username and password
      Given user navigate to "login" page
      When the user enter a invalid username
      And  the user enter a invalid password
      Then the user can not navigate to the home page