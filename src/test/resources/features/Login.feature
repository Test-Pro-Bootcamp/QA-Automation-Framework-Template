Feature: Login feature

  Scenario: Login Success
    Given I open Login Page
    When I enter email "demo@class.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I am logged in

  Scenario: Login incorrect password
    Given I open Login Page
    When I enter email "demo@class.com"
    And I enter incorrect password "pass"
    And I submit
    Then I am logged out


