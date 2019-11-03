@FunctionalTest
Feature: Verify Logout functionality

  Scenario: Verify for successful login with valid credentials
    Given I load web page
    When I enter username and password
    Then I verify loginname
    Then I logout of application