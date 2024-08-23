Feature: Login Ui and Functionality
  As a user of the movies names website
  I want to be able to log in to my account
  So that I can access personalized features and make purchases

  Scenario: Login Page UI

    Given I am on the login page
    When I checked login logo is displayed
    Then I checked username and Password label


  Scenario Outline: Login functionality with Valid Credentials

    Given I am on the login page
    When I enter valid <username> and <password>
    And click login page
    Then I should be get to the home page

    Examples:
    |username  |  password      |
    |praneetha |  praneetha@2021|
    |rahul     |  rahul@2021    |
    |karun     |  karun@2021    |
    |appu      |  appu@2021     |
    |myra      |  karun@2021    |
    |afruza    |  appu@2021     |



  Scenario: Login with empty input fields

    Given I am on the login page
    When I click on the login button
    Then an error message for empty input should be visible

  Scenario: Login with empty username fields

    Given I am on the login page
    When I enter password
    And click login page
    Then an error message for empty input should be visible

  Scenario: Login with empty password fields

    Given I am on the login page
    When I enter username
    And click login page
    Then an error message for empty input should be visible


  Scenario: Login with invalid inputs

    Given I am on the login page
    When I enter username
    And I enter an invalid pass
    And click login page
    Then an error message 'invalid user ID' should be visible

