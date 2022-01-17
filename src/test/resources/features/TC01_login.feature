@non-reg
Feature: As a user I want to login to my account

  @Login
  Scenario Outline: Login scenario
    Given user is on the connexion page
    When  user tries to connect with his "<mail>" and his "<password>"
    Then  user should be logged in
    Examples:
      | mail                         | password      |
      | appiumtestzenity@yopmail.com | Test12345     |