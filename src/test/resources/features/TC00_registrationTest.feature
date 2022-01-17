@non-reg
Feature: As a user I want to register to my account and disconnect after

  @Login
  Scenario Outline: Login scenario
    Given user is on the home page
    When user clicks on register button
    And  user enters his "<mail>" and his "<password>"
    Then  user should be registered
    Examples:
      | mail                         | password      |
      | appiumtestzenity@yopmail.com | Test12345     |


  @Disconnect
  Scenario Outline: disconnect scenario
    Given user is logged in
    When user wants to disconnect from his account
    Then  user should be able to disconnect
    Examples:
      | mail                         | password      |
      | appiumtestzenity@yopmail.com | Test12345     |
