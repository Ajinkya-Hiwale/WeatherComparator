@RegressionSuite
Feature: Weather data Testing Scenarios for NDTV weather UI

		# Description:Validating if we getting all the data such as Temperature,Humidity,
		# weather condition,wind speed from the UI upon providing valid input city and
		# getting expected error message when enter invalid city name

@UITest @UITest1 
Scenario Outline: To check if weather data is present for the provided input city
Given Launch NDTV weather website "<url>"
When Enter city name "<city>"
Then verify if weather data is displayed

Examples:
|url|city|
|url|city1|
|url|city2|
|url|city3|



@UITest @UITest2
Scenario Outline: To check if get error message upon entering wrong city name
Given Launch NDTV weather website "<url>"
When Enter city name "<city>"
Then verify error message when city is not valid "<error_msg>"

Examples:
|url|city|error_msg|
|url|invalidcity1|errormsg|
|url|invalidcity2|errormsg|
|url|invalidcity1|errormsg|

	