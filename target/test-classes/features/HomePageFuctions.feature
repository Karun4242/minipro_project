Feature: Homepage Ui
  As a user of the movies names website
  I want to be able to log in to my account
  So that I can access personalized features and make purchases


  Scenario: Test the Contact Us Section

    Given I am on the Home page
    When i checked contact Icon
    Then I checked contact Us text

  Scenario: HomePage texts of each section

    Given I am on the Home page
    When I checked trend text
    And   I checked TopMenu text
    Then I Test whether the play button is displayed or not


  Scenario: Test whether the Website logo is displayed and nav bar

    Given I am on the Home page
    When I checked app logo
    Then I checked nav bar elements

#  Scenario: Test the navigation to the account page through elements in the header section
#
#    Given I am on the Home page
#    When I click on home
#    And I checked trends movies displayed or not
#    Then I checked nav bar to accounts page





#  Scenario: Test whether the Movies are displayed, in the corresponding movies sections
#
#    Given I am on the login page
#    When I checked
#    Then an error message 'valid user ID' should be visible

