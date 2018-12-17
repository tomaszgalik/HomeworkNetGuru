Feature: Register new account

  Scenario: User registration with language choosing
    Given I am on the main page https://trello.com/
    And I click “Sign up” button
    And	I choose proper language from dropdown
    And	I input Name
    And	I input new email address
    And	I input new password
    When I click “Create new account”
    Then New account is created
    And I am logged in
    And I am on tutorial page

  Scenario: User registration with Google account

    Given I am on the main page https://trello.com/
    And I click “Sign up” button
    When I click “Sign up with Google”
    And	I log in to google with proper credentials
    Then New account is created
    And I am logged in
    And I am on tutorial page

  Scenario: User registration from login page

    Given I am on the main page https://trello.com/
    And I go to Login Page
    And I input Name
    And I input new correct email address
    And	I input new password
    When I click “Create new account”
    Then New account is created
    And I am logged in
    And I am on tutorial page

  Scenario: User registration fails because of wrong email

    Given I am on the main page https://trello.com/
    And I go to Login Page
    And I input Name
    And I input email address with wrong syntax
    And	I input password
    When I click “Create new account”
    Then I get error message 
