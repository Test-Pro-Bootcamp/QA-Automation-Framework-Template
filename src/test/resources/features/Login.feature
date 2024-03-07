Feature: Login Feature

  Scenerio: Login success
    Given I open browser
    And I open Login
    When I enter email "vlad.sadokha@testpro.io"
    And I enter password "democlass"
    And I submit
    Then I am logged in