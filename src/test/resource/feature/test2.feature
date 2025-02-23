Feature: Test iFrame Scenario

	@test
	Scenario: Test iFrame
	
		Given User is on Home Page
		When User enters "test@email.com" and "abcabc"
		And Clicks Go button
		Then He can visit the practice page
		Then Check iFrame functionality
		
		
		