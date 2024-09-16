Feature: Cart Page
  Background: User login into Sauce Demo and click on the cart button
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button


  Scenario: Verify that you can't go to checkout with no products in your cart
    When I click on the cart button
    And The title is displayed
    And  The title text equals Your Cart with "Your Cart"
    And I click on the checkout button
    And A error message that says "Epic sadface: You have no products to checkout" should be displayed


