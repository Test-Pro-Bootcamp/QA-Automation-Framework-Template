Feature: Song Favoriting

  Scenario: Like Multiple Songs to Add To Favorites Playlist
    Given I am logged in
    When I add songs to favorites
    Then I can see the song I liked in Favorites Playlist

  # Background:
  # Given I open login page