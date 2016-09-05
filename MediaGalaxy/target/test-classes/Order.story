Narrative: In order to test the order functionality
As a possible client 
I want to log in first and then order a specific product on mediagalaxy.ro

Scenario: Order - happy flow

Given Login fields registration
When I submit fields with valid data and then I should be loged into my account
Then I should be able to order a specific product