Feature: search page function
  As a user of the movies names website
  I want to be able to log in to my account
  So that I can access personalized features and make purchases



  Scenario: Test the Search Functionality

    Given I am on the Search page
    When I click search Element and enter name
    Then I checked count movies

  Scenario: Test the Search error movie

    Given I am on the Search page
    When I click search Element and OutOf name
    Then I checked Error sms