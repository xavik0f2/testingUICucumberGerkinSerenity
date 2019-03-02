Feature: Main search

  Narrative:
  In order find available flights
  As a client of https://www.vueling.com/es
  I want to be able to search flights

  Scenario: Initial search
    Given I'm main page
    When I try to find a fly
      | Origin  | Destination | Outbound  | _return |passengers |
      | Almería | Alicante    | NEXT_WEEK |        |     1     |
    Then I get available flight
