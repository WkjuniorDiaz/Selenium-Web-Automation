@Checkout @Regression
Feature: Checkout

  Background: User login
    Given user login with credentials "TC001"

  Scenario: Successful checkout
    When the user adds the product "TC008" to the cart
    And the user navigates to the cart
    And the user proceeds to checkout your information
    And the user fills the checkout information with "TC008" information
    And the user proceeds to checkout overview
    And the user proceeds to checkout complete
    Then verify that the checkout was successfully and logout

  Scenario: Adding multiple items to the cart
    When the user adds multiple products "TC009" to the cart
    And the user navigates to the cart
    And the user proceeds to checkout your information
    And the user fills the checkout information with "TC009" information
    And the user proceeds to checkout overview
    And the user proceeds to checkout complete
    Then verify that the checkout was successfully and logout

  @TestCheckout
  Scenario: Checkout with missing personal information
    When the user adds the product "TC010" to the cart
    And the user navigates to the cart
    And the user proceeds to checkout your information
    And the user fills the checkout information with "TC010" information
    And the user proceeds to checkout overview
    Then an error message "TC010" should displayed on Checkout Your Information screen
