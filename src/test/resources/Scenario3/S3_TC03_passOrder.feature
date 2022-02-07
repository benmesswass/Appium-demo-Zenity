@non-reg
@Scenario3
Feature: As a user I want to pass an order

  Scenario Outline: passOrder scenario
    Given user is on the home page
    When  user wants to add a specified "<product>" and "<number>"to his cart
    Then  user should be able to confirm his order using his card information: "<cardNbre>" "<expirationDate>" and "<code>"
    Examples:
      | cardNbre                         | expirationDate      |code| number    |  product    |
      | 4242424242424                    | 11/24               |123 | 2         |  Gloves     |
      | 4242424242424242                 | 11/25               |123 | 3         | Gloves        |
      #| 42424242424                      | 18/24               |123 | gregoryzenity2@yopmail.com | Test12345 | Nike       |
