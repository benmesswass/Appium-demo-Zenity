@Scenario1
Feature: As a user I want to disconnect from my account

  Scenario Outline: disconnect scenario
    Given user is on the home page
    When user wants to disconnect from his account
    Then  user should be able to disconnect
    Examples:
      | mail                         | password      |
      | appiumtestzenity@yopmail.com | Test12345     |
