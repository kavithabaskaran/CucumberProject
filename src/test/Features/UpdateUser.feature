@FunctionalTest
Feature: Verify Update user details functionality

    Scenario Outline: Verify editing existing user in Home Page
      Given I load web page
      When I enter username and password
      Then I verify loginname
      Then I click on user list
      And I click on edit button
      And I update firstname "<firstName>" and lastname "<lastName>" and startDate "<startDate>" and email "<email>"
      And I click on Update button
      # Display updated user details
      When I select updated details from the list"<firstName>", "<lastName>"
      Then I verify updated user details "<firstName>", "<lastName>", "<startDate>","<email>"

    Examples:
    |firstName       |lastName   |startDate     |email            |
    |edit123         |last1      |2019-11-02    |test@xyr.com     |
    |edit456         |Test1      |2019-11-04    |testemail@tes.com|