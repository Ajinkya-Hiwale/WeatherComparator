@RegressionSuite
Feature: Weather data Testing Scenarios

#@Test1   @positive
#Scenario Outline: To check if weather data is present for the provided input city
#Given Launch website "<url>"
#When Enter city name "<city>"
#Then verify if weather data is displayed
#
#Examples:
#|url|city|
#|url|Pune|
#|url|Nagpur|
#|url|Kolkata|



@Test2  @negative
Scenario Outline: To check if get error message upon entering wrong city name
Given Launch website "<url>"
When Enter city name "<city>"
Then verify error message when city is not valid "<error_msg>"

Examples:
|url|city|error_msg|
|url|Amt|errormsg_for_wrong_cityname|
|url|Arvi|errormsg_for_wrong_cityname|
|url|Ashtii|errormsg_for_wrong_cityname|
#
#	
	