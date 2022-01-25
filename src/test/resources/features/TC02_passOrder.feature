@non-reg
Feature: As a user I want to pass an order

  @PassOrder
  Scenario Outline: passOrder scenario
    Given user is connected to his account with his "<mail>" and his "<password>"
    When  user wants to add a specified "<product>" to his cart
    Then  user should be able to confirm his order using his card information: "<cardNbre>" "<expirationDate>" and "<code>"
    Examples:
      | cardNbre                         | expirationDate      |code| mail                       | password  | product    |
      | 4242424242424242                 | 11/24               |123 | gregoryzenity@yopmail.com  | Test12345 | Gloves     |
      | 4242424242424                    | 11/24               |123 | gregoryzenity@yopmail.com  | Test12345 | PS4        |
      | 4242424242424242                 | 18/24               |123 | gregoryzenity2@yopmail.com | Test12345 | Nike       |
      | 4242424242424242                 | 12/21               |123 | gregoryzenity3@yopmail.com | Test12345 | PS4        |
