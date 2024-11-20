Feature: :F02_Shopping Cart | Users can manage their shopping cart
 @smoke
  Scenario: Verify adding a product to the cart
    Given the user is on the homepage
    When the user add product to cart
    And the user navigates to their shopping cart
    Then the selected product should be visible in the shopping cart
@smoke
  Scenario: Verify removing an item from the shopping cart
    Given the user is on the homepage
    When the user add product to cart
    And the user navigates to their shopping cart
    When the user removes an item
    Then the item should no longer appear in the shopping cart
@smoke
   Scenario: verify check out successfully
     Given the user is on the homepage
     When the user add product to cart
     And the user navigates to their shopping cart
     When the user click on checkout button
     And  the user enter valid credentials
     And the user click continue
     And the user click finish
     Then the user should see a confirmation message that the order has been successfully placed
