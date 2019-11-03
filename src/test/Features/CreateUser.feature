@FunctionalTest
Feature: Verify Home Page details

  Scenario Outline: Verify list of users in Home Page and create new user
    Given I load web page
    When I enter username and password
    Then I verify loginname
    And I click on create button
    And I enters firstname "<firstName>" and lastname "<lastName>" and startDate "<startDate>" and email "<email>"
    And I click on Submit form

    # Display added name
    When I select name from the list"<firstName>", "<lastName>"
    Then I verify correct user details "<firstName>", "<lastName>", "<startDate>","<email>"

    Examples:
      |firstName       |lastName   |startDate     |email            |
      |sample1         |Test1      |2019-11-02    |test@xyr.com     |
      |sample2         |Test2      |2019-11-04    |testemail@tes.com|



