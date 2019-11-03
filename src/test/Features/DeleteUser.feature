@FunctionalTest
Feature: Verify Delete user functionality

  Scenario Outline: Verify successful delete user functionality
      Given I load web page
      When I enter username and password
      Then I verify loginname
      Then I select name from the list"<firstName>", "<lastName>"
      And I click on delete button
      And I agree with the alert
      Then I should not see the details "<firstName>", "<lastName>" in the list

  Examples:
      | firstName | lastName |
      | sample1   | Test1    |
