Feature: As a user I would like to log in my account with my e-mail and password.

  Scenario: User logs in with email and password

    Given I am on the main page https://trello.com/
    And I go to Login Page
    And I input correct email address
    And I input password
    When I click “Log in”
    Then I am logged in
    And I am on dashboard page

  Scenario: User login from registration page

    Given I am on the main page https://trello.com/
    And I click “Sign up” button
    And I click “Sign in to your account”
    And I input correct email address
    And I input password
    When I click “Log in”
    Then I am logged in
    And I am on dashboard page

  Scenario: User try to log in with wrong password

    Given I am on the main page https://trello.com/
    And I go to Login Page
    And I input correct email address
    And I input incorrect password
    When I click “Log in”
    Then I get prompt message “Invalid password”

  Scenario: User try to log in with wrong email

    Given I am on the main page https://trello.com/
    And I go to Login Page
    And I input incorrect email address
    And I input password
    When I click “Log in”
    Then I get prompt message “There isn't an account for this email”

#  Scenario: User logs in after trying to create new account with email of existing user
#
#    Given I am on the main page https://trello.com/
#    And I click “Sign up” button
#    And I input email of existing user
#    And I input new password
#    When I click “Create new account”
#    Then I get prompt message about existing user
#    When I click "Log in" link in the message
#    Then I am on login page
