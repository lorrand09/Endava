Feature: Create Account succesfully

Narrative: In order to test create account functionality
As a possible client 
I want to create a new account on www.mediagalaxy.ro 

Scenario: Create account
Given I open the new account page
When I submit the form with valid data
Then I should see the data created