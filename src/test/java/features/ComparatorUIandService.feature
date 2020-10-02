@RegressionSuite
Feature: Compare Data received from UI and response received from Service


#@Comparator
#Scenario Outline: Comparing Temperature from UI with Temprature received from Service with provided variance
#Given Launch NDTV weather website "<url>" and enter city "<city>"
#When Retrive the weather data from the UI
#And Call Weather API and fetch all the weather details "<baseURI>","<endPoint>","<apiKey>","<city>"
#Then verify if the Temperature retrived from UI and Service is matching with Variance "<variance>"
#
#
#Examples:
#|url|baseURI|endPoint|apiKey|city|variance|
#|url|baseURI|endPoint|apiKey|city1|variance|
#|url|baseURI|endPoint|apiKey|city2|variance|
#|url|baseURI|endPoint|apiKey|city3|variance|



@Comparator
Scenario Outline: Comparing City from UI with City received from Service with provided variance
Given Launch NDTV weather website "<url>" and enter city "<city>"
When Retrive the weather data from the UI
And Call Weather API and fetch all the weather details "<baseURI>","<endPoint>","<apiKey>","<city>"
Then verify if the City retrived from UI and Service is matching


Examples:
|url|baseURI|endPoint|apiKey|city|
|url|baseURI|endPoint|apiKey|city1|
|url|baseURI|endPoint|apiKey|city2|
|url|baseURI|endPoint|apiKey|city3|


@Comparator
Scenario Outline: Comparing City from UI with City received from Service with provided variance
Given Launch NDTV weather website "<url>" and enter city "<city>"
When Retrive the weather data from the UI
And Call Weather API and fetch all the weather details "<baseURI>","<endPoint>","<apiKey>","<city>"
Then verify if the Temperature retrived from UI and Service is matching with Variance "<variance>"

Examples:
|url|baseURI|endPoint|apiKey|city|variance|
|url|baseURI|endPoint|apiKey|city1|variance|
|url|baseURI|endPoint|apiKey|city2|variance|
|url|baseURI|endPoint|apiKey|city3|variance|