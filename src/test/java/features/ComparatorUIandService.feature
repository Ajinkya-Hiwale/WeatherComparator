@RegressionSuite
Feature: Compare Data received from UI and response received from Service

#            Description:In this feature we are comparing values such as Temperature,Humidity,
#            CityName,Humidity and Weather condition received from UI and Services

#			Note:Here some test cases will fail if variance logic(mention in TestData.proprties) is
#           less than the difference between value retrived from UI and WebService

@ComparatorUIandService     @UIandService1
Scenario Outline: Comparing Temperature from UI with Temprature received from Service with provided variance
Given Launch NDTV weather website "<url>" and enter city "<city>"
When Retrive the weather data from the UI
And Call Weather API and fetch all the weather details "<baseURI>","<endPoint>","<apiKey>","<city>"
Then verify if the Temperature retrived from UI and Service is matching with Variance "<variance>"

Examples:
|url|baseURI|endPoint|apiKey|city|variance|
|url|baseURI|endPoint|apiKey|city1|tempvariance|
|url|baseURI|endPoint|apiKey|city2|tempvariance|
|url|baseURI|endPoint|apiKey|city3|tempvariance|



@ComparatorUIandService  @UIandService2
Scenario Outline: Comparing City from UI with City received from Service
Given Launch NDTV weather website "<url>" and enter city "<city>"
When Retrive the weather data from the UI
And Call Weather API and fetch all the weather details "<baseURI>","<endPoint>","<apiKey>","<city>"
Then verify if the City retrived from UI and Service is matching

Examples:
|url|baseURI|endPoint|apiKey|city|
|url|baseURI|endPoint|apiKey|city1|
|url|baseURI|endPoint|apiKey|city2|
|url|baseURI|endPoint|apiKey|city3|


@ComparatorUIandService  @UIandService3
Scenario Outline: Comparing Humidity from UI with Humidity received from Service with provided variance
Given Launch NDTV weather website "<url>" and enter city "<city>"
When Retrive the weather data from the UI
And Call Weather API and fetch all the weather details "<baseURI>","<endPoint>","<apiKey>","<city>"
Then verify if the Humidity retrived from UI and Service is matching with Variance "<variance>"

Examples:
|url|baseURI|endPoint|apiKey|city|variance|
|url|baseURI|endPoint|apiKey|city1|humidityvariance|
|url|baseURI|endPoint|apiKey|city2|humidityvariance|
|url|baseURI|endPoint|apiKey|city3|humidityvariance|



@ComparatorUIandService  @UIandService4
Scenario Outline: Comparing Weather condition from UI with Weather condition received from Service
Given Launch NDTV weather website "<url>" and enter city "<city>"
When Retrive the weather data from the UI
And Call Weather API and fetch all the weather details "<baseURI>","<endPoint>","<apiKey>","<city>"
Then verify if the weather condition retrived from UI and Service is matching


Examples:
|url|baseURI|endPoint|apiKey|city|
|url|baseURI|endPoint|apiKey|city1|
|url|baseURI|endPoint|apiKey|city4|



@ComparatorUIandService  @UIandService5
Scenario Outline: Comparing Wind Speed from UI with Humidity received from Service with provided variance
Given Launch NDTV weather website "<url>" and enter city "<city>"
When Retrive the weather data from the UI
And Call Weather API and fetch all the weather details "<baseURI>","<endPoint>","<apiKey>","<city>"
Then verify if the Wind Speed retrived from UI and Service is matching with Variance "<variance>"

Examples:
|url|baseURI|endPoint|apiKey|city|variance|
|url|baseURI|endPoint|apiKey|city1|windvariance|
|url|baseURI|endPoint|apiKey|city2|windvariance|
|url|baseURI|endPoint|apiKey|city3|windvariance|



