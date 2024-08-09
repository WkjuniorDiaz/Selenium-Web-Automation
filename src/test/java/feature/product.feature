@Product @Regression
  Feature:Product

    Background: User log in
      Given user login with valid credentials "TC001"

      Scenario: Verify product sorting functionality
        When the user changes the product sort to "Price (low to high)"
        Then the selected sort option should be "Price (low to high)"
        And all product prices on the page should be in ascending order