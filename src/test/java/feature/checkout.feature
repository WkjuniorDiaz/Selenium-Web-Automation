@Checkout @Regression
Feature: Checkout

  Background: User login
    Given user login with credentials "TC001"

  @TestCheckout
  Scenario: Verify Successful Checkout Process
    When the user adds the product "TC008" to the cart
    And the user navigates to the cart
    And the user proceeds to checkout your information
    And the user fills the checkout information with "TC008" information
    And the user proceeds to checkout overview
    And the user proceeds to checkout complete
    Then verify that the checkout was successfully and logout

  @TestMultiple
  Scenario: Adding multiple items to the cart and verifying prices
    When the user adds multiple products "TC009" to the cart
    And the user navigates to the cart
    And the user proceeds to checkout your information
    And the user fills the checkout information with "TC009" information
    And the user proceeds to checkout overview
    And the user proceeds to checkout complete
    Then verify that the checkout was successfully and logout
