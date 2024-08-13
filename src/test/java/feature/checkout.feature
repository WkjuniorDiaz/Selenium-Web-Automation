@Checkout @Regression
Feature: Checkout

  Background: User login
    Given user login with valid credentials "TC001"

  Scenario: Verify Successful Checkout Process
    When the user adds the product "TC008" to the cart
    And the user navigates to the cart
    And the user proceeds to checkout
    And the user fills the checkout information with first name "TC008", last name "TC008" and postal code "TC008"
    And the user clicks on the continue button
    And the user clicks on the finish button to complete the checkout
    Then verify that the checkout was successfully and logout

  @Test
  Scenario: Adding multiple items to the cart and verifying prices and cart count
    When the user adds the product "Sauce Labs Fleece Jacket" to the cart
    And the user adds the product "Sauce Labs Onesie" to the cart
    And the user navigates to the cart
    And validate the prices from product page and cart page
    And the user remove product "Sauce Labs Onesie" from Your cart page
    And capture the quantity of "Sauce Labs Fleece Jacket" from the Your Cart page
    And the user proceeds to checkout
    And the user fills the checkout information with first name "Jose", last name "Perez" and postal code "0700"
    And the user clicks on the continue button
    And validate price from product "Sauce Labs Fleece Jacket" to price of Item Total
    And the user clicks on the finish button to complete the checkout
    Then verify that the checkout was successfully and logout
