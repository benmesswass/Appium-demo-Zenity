@Scenario1
Feature: As a user I want to register a user account

  Scenario Outline: Registration scenario
    Given user is on the login page
    When user clicks on register button
    And  user enters his "<mail>" his "<password>" and "<confirmPassword>"
    Then  user should be registered with his "<mail>" and his "<password>"
    Examples:
      | mail                         | password      | confirmPassword |
      | gregoryzenity@yopmail.com    | Test12345     | Test12345       |
      #| gregoryzenity@yopmail.com    | Test12345     | Test12345       |
      #| gregoryzenity@yopmail.com    | Test12345     | Test123         |

  #@Disconnect
  #Scenario Outline: disconnect scenario
  #  Given user is logged in
  #  When user wants to disconnect from his account
  #  Then  user should be able to disconnect
  #  Examples:
  #    | mail                         | password      |
  #    | appiumtestzenity@yopmail.com | Test12345     |
