@Login @Regression
Feature: Login

  Scenario: Successful Login with valid credentials
    When user login with credentials "TC001"
    Then the product page should displayed

  Scenario: Unsuccessful Login with locked out credentials
    When user login with credentials "TC002"
    Then an error message "TC002" should displayed

  Scenario Outline: Unsuccessful Login with invalid invalid credentials
    When user login with credentials <testCase>
    Then an error message <testCase> should displayed

    Examples:
      | testCase |
      | "TC003"  |
      | "TC004"  |
      | "TC005"  |

  Scenario: Unsuccessful Login with empty credentials
    When user select login button
    Then an error message "TC006" should displayed

  Scenario: Unsuccessful Login with empty password
    When user type username "TC007"
    And user select login button
    Then an error message "TC007" should displayed
