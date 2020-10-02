@RegressionSuite
Feature: Weather data Testing Scenarios for Services

@SeriveTest1  @positive
Scenario Outline: To check if weather data is present for the provided input city
Given Setting up Rest APi ELements like "<baseURI>","<endPoint>","<apiKey>","<city>"
When Calling Weather API to get weather details
Then Verify if weather data is getting fetched from the API

Examples:
|baseURI|endPoint|apiKey|city|
|baseURI|endPoint|apiKey|city1|
#|baseURI|endPoint|apiKey|city2|
#|baseURI|endPoint|apiKey|city3|

@SeriveTest2  @positive
Scenario Outline: To check if we get valid status code upon providing valid city
Given Setting up Rest APi ELements like "<baseURI>","<endPoint>","<apiKey>","<city>"
When Calling Weather API to get weather details
Then Verify status code should be "<status_code>"

Examples:
|baseURI|endPoint|apiKey|city|status_code|
|baseURI|endPoint|apiKey|city1|200|
#|baseURI|endPoint|apiKey|city2|200|
#|baseURI|endPoint|apiKey|city3|200|


@SeriveTest3  @positive
Scenario Outline: To check the content type of the response
Given Setting up Rest APi ELements like "<baseURI>","<endPoint>","<apiKey>","<city>"
When Calling Weather API to get weather details
Then Verify content type of the response "<content_type>"

Examples:
|baseURI|endPoint|apiKey|city|content_type|
|baseURI|endPoint|apiKey|city1|content_type|
#|baseURI|endPoint|apiKey|city2|content_type|
#|baseURI|endPoint|apiKey|city3|content_type|




@SeriveTest4  @Negative
Scenario Outline: To check if we get valid status code upon providing valid city
Given Setting up Rest APi ELements like "<baseURI>","<endPoint>","<apiKey>","<city>"
When Calling Weather API to get weather details
Then Verify status code should be "<status_code>"

Examples:
|baseURI|endPoint|apiKey|city|status_code|
|baseURI|endPoint|apiKey|amit|404|
|baseURI|endPoint|apiKey|Amt|404|
|baseURI|endPoint|apiKey||400|

