Feature: Account page Ui
  As a user of the movies names website
  I want to be able to log in to my account
  So that I can access personalized features and make purchases


  Scenario: Test the account Us Section

    Given I am on the Account page
    When I click on Account element
    Then I checked all Account movies displayed or not

  Scenario: Test the account logOut Section

    Given I am on the Account page
    When I click on Account element
    Then I click on Logout Element