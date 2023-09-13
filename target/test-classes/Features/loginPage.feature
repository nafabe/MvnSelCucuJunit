
@regression @login
Feature: This feature file will validate Login Page functionality

  Background:
    Given user navigates to HRM Login Page

  @smoke @positive
  Scenario: User should be able to verify successful login with valid credentials
    When user enters "yoll-student" username
    Then user enters "Bootcamp5#" password
    Then user clicks on login button
    And user should be able to verify account name on HRM Homepage

  @negative
  Scenario Outline: User should not be able to login with invalid credentials
    When user enters "<username>" username
    Then user enters "<password>" password
    Then user clicks on login button
    And user validates "<errorMessage>" error message

    Examples:
      | username        | password    | errorMessage             |
      | invalidUsername | invalidPwd  | Invalid credentials      |
      |                 | invalidPwd  | Username cannot be empty |
      | invalidUsername |             | Password cannot be empty |
      |                 |             | Username cannot be empty |









