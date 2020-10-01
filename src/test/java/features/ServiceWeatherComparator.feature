@RegressionSuite
Feature: Weather data Testing Scenarios for Services

@SeriveTest1  @positive
Scenario Outline: To check if weather data is present for the provided input city
Given Calling Weather API to get weather details "<baseURI>","<endPoint>","<apiKey>","<city>"
Then Verify if weather data is getting fetched from the API

Examples:
|baseURI|endPoint|apiKey|city|
|baseURI|endPoint|apiKey|Pune|



@SeriveTest2  @positive
Scenario Outline: To check if weather data is present for the provided input city
Given Calling Weather API to get weather details "<baseURI>","<endPoint>","<apiKey>","<city>"
Then Verify status code should be "<status_code>"

Examples:
|baseURI|endPoint|apiKey|city|status_code|
|baseURI|endPoint|apiKey|Pune|200|


