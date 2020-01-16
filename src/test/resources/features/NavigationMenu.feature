@navigate
Feature:  Users should be able to navigate to pages
@vehicle
  Scenario: Navigate to Vehicles under Fleet using the top menu
    Given the user is on the dashboard page
    When the user navigate to Fleet then Vehicles option
    Then the expected url should be https://qa3.vytrack.com/entity/fleet
@campaings
  Scenario: Navigate to Campaigns under Marketing using the top menu
    Given the user is on the dashboard page
    When the user navigate to Marketing then Campaigns option
    Then the expected url should be https://qa3.vytrack.com/campaign/
@calendarEvents
  Scenario: Navigate to Calendar Events under Activities using the top menu
    Given the user is on the dashboard page
    When the user navigate to Activities then Calendar Events option
    Then the expected url should be https://qa3.vytrack.com/calendar/event