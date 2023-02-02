Feature: Booking search tests
  Scenario: Search for Premiere Classe Wroclaw Centrum
    Given I am at https://www.booking.com/searchresults.en-gb.html page
    When I set 'Premiere Classe Wroclaw Centrum' into search bar
    And I click to search button
    Then 'Premiere Classe Wroclaw Centrum' should be present in first search result title
    And 'Premiere Classe Wroclaw Centrum' raiting should be '7.4'