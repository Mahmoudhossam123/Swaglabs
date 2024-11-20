Feature: Verify Product Price
@regression
Scenario: Verify prices of multiple products
 Given the user is on the homepage
 When  the user can navigate to the home page
  Then the prices of the products should match the following:
    | Product Name                    | Expected Price |
    | Sauce Labs Backpack             | $29.99         |
    | Sauce Labs Bike Light           | $9.99          |
    | Sauce Labs Bolt T-Shirt         | $15.99         |
    | Sauce Labs Fleece Jacket        | $49.99         |
    | Sauce Labs Onesie               | $7.99          |
    |Test.allTheThings() T-Shirt (Red)|$15.99          |
