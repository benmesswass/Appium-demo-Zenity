@non-reg
Feature: As a user I want to register to my account and disconnect after

  @Registration
  Scenario Outline: Registration scenario
    Given user is on the home page
    When user clicks on register button
    And  user enters his "<mail>" and his "<password>"
    Then  user should be registered with his "<mail>" and his "<password>"
    Examples:
      | mail                          | password      |
      | gregoryzenityyopmail.com     | Test12345     |
      | gregoryzenity@yopmail.com    | Test12345     |
      #| gregoryzenity3@yopmail.com   | Test12345     |

  #@Disconnect
  #Scenario Outline: disconnect scenario
  #  Given user is logged in
  #  When user wants to disconnect from his account
  #  Then  user should be able to disconnect
  #  Examples:
  #    | mail                         | password      |
  #    | appiumtestzenity@yopmail.com | Test12345     |
