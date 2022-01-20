@non-reg
Feature: As a user I want to pass an order

  @PassOrder
  Scenario Outline: passOrder scenario
    Given user is connected to his account with his "<mail>" and his "<password>"
    When  user wants to add products to his cart
    Then  user should be able to confirm his order using his card information: "<cardNbre>" "<expirationDate>" and "<code>"
    Examples:
      | cardNbre                         | expirationDate      |code| mail                      | password  |
      | 4242424242424242                 | 12/24               |123 | gregoryzenity@yopmail.com | Test12345 |
      | 4242424242424242                 | 12/24               |123 | gregoryzenity2@yopmail.com | Test12345 |
      | 4242424242424242                 | 12/24               |123 | gregoryzenity3@yopmail.com | Test12345 |
