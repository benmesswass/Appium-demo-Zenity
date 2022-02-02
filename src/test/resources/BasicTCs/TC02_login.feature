@BasicTCs
Feature: As a user I want to login to my account

  @Login
  Scenario Outline: Login scenario
    Given user is on the login page
    When  user tries to connect with his "<mail>" and his "<password>"
    Then  user should be logged in with his "<mail>" and his "<password>"
    Examples:
      | mail                         | password      |
      | gregoryzenity2yopmail.com    | Test12345     |
      #| gregoryzenity2yopmail.com   | Test12345     |
      #| gregoryzenity2@yopmail.com   | Test1         |
      #| gregoryzenity@yopmail.com    | Test22345     |
