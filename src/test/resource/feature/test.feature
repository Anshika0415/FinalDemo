Feature: Login

@test2
Scenario Outline: Successful Login with Valid Credentials
Given User is on Home Page
When User enters "<name>" and "<pass>"
And Clicks Go button
Then He can visit the practice page
And A message is displayed
Then Context click on mouse hover button and select "top" option
And just for the sake of learning pass <num>


Examples:
|name         |pass  |num|
|test@email.com|abcabc|1|
|xyz           |def   |2|

@test1
Scenario Outline: Successful Login with InValid Credentials
Given User is on Home Page
When User enters "<name>" and "<pass>"
And Clicks Go button
Then He can visit the practice page
And A message is displayed
Then Context click on mouse hover button and select "top" option

Examples:
|name         |pass  |
|xyz           |def   |