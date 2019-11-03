@FunctionalTest
Feature: Verify Login functionality

  Scenario: Verify for successful login with valid credentials
    Given I load web page
    When I enter username and password
    Then I verify loginname
    Then I logout of application

  Scenario Outline: Login with invalid credentials
    Given I load web page
    And Login form displayed
    When user enters username "<userName>" and password "<password>"
    And user clicks the Login button
    Then user should see "<errorMessage>"

    Examples:
      |userName     |password   |errorMessage|
      |Luke         |12         |Invalid username or password!	|


