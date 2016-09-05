Feature: Test Register Account functionality 

Narrative: In order to test register account functionality
As a possible client 
I want to create a new account on mediagalaxy.ro

Scenario: Register account - happy flow

Given I open registration account page 
When I submit form with valid data
Then I should see the data created