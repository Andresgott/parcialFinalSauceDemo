Feature: Home page

  Background: User login into Sauce Demo
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button

    Scenario Outline: Verify that all products are displayed
      When The home page should be displayed
      Then The product "<products>" should be displayed in the home page
      Examples:
        | products                |
        | Sauce Labs Backpack     |
        | Sauce Labs Bike Light   |
        | Sauce Labs Bolt T-Shirt |
        | Sauce Labs Onesie       |

  Scenario Outline: Verify that all products can be added to the cart
    When The home page should be displayed
    And I add to the cart the product "<products>"
    Then The cart icon should display "1"
    And I remove the product "<products>" from the cart
    Examples:
      | products                |
      | Sauce Labs Backpack     |
      | Sauce Labs Bike Ligsdsd |
      | Sauce Labs Bolt T-Shirt |
      | Sauce Labs Onesie       |

  @run
  Scenario: Verify that the sort combo box for A to Z function properly
    When The home page should be displayed
    And I click on the sort combo box
    And I verify that the order of the products is correct

  @run
  Scenario Outline: Verify that the button Reset app state works properly
    When The home page should be displayed
    And I add to the cart the product "<products>"
    Then I click on three stripes button
    And I click on the Reset App button
    Then I verify if the text from the button changed back
    Examples:
      | products            |
      | Sauce Labs Backpack |


  @run
  Scenario: Verify that the sort combo bo for low to high functions properly
    When The home page should be displayed
    And I click on the sort combo box
    And I verify that the products are ordered from the lowest to the highest price

  @run
  Scenario Outline: Verify that i can see the description of all the products
    When The home page should be displayed
    Given I click on the name of the product "<products>"
    Then The button back to products should be displayed
    And I click on the back to products button
    Examples:
      | products                          |
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |
      | Sauce Labs Fleece Jacket          |

