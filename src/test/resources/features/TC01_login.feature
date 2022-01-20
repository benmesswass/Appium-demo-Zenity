@non-reg
Feature: As a user I want to login to my account

  @Login
  Scenario Outline: Login scenario
    Given user is on the connexion page
    When  user tries to connect with his "<mail>" and his "<password>"
    Then  user should be logged in
    Examples:
      | mail                         | password      |
      | gregoryzenity@yopmail.com    | Test12345     |
      | gregoryzenity2@yopmail.com   | Test12345     |
      | gregoryzenity3@yopmail.com    | Test12345     |
