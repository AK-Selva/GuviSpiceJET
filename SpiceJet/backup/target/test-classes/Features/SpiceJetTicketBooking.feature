@Smoke

Feature: Book Ticket

  I want to book a ticket in SpiceJet

  @Test1

  Scenario: Book Ticket from Delhi to Bengaluru

    Given I Open URL "https://www.spicejet.com/" and launch driver

    When I search ticket from "Delhi" to "Bengaluru" Depart on "10-April-2021" return on "11-June-2021"

    Then I close driver