Feature: Testing the Sort Button on the Products Page|
  As a user
  I want to sort products according to a lot of sort options
@regression
  Scenario: Testing sorting items from low to high price
    Given the user is on the homepage
    When the user chooses "option[1]" sort option
    Then the products should be sorted according to "option[1]"
  @regression
  Scenario: Testing sorting items from high to low price
    Given the user is on the homepage
    When the user chooses "option[2]" sort option
    Then the products should be sorted according to "option[2]"
  @regression
  Scenario: Testing sorting items alphabetically from A to Z
    Given the user is on the homepage
    When the user chooses "option[3]" sort option
    Then the products should be sorted according to "option[3]"
  @regression
  Scenario: Testing sorting items alphabetically from Z to A
    Given the user is on the homepage
    When the user chooses "option[4]" sort option
    Then the products should be sorted according to "option[4]"
