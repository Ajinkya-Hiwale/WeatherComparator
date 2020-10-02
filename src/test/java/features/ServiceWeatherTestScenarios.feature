@RegressionSuite
Feature: Weather data Testing Scenarios for NDTV Services

#		Description:Here we are hitting NDTV weather service .We are verifying 
#		if we are getting correct response,reponse code,content type and 
#		uppon providing invalid city names if we getting expected error codes

@SeriveTest  @SeriveTest1
Scenario Outline: To check if weather data is present for the provided input city
Given Setting up Rest APi ELements like "<baseURI>","<endPoint>","<apiKey>","<city>"
When Calling NDTV Weather API to get weather details
Then Verify if weather data is getting fetched from the API

Examples:
|baseURI|endPoint|apiKey|city|
|baseURI|endPoint|apiKey|city1|
|baseURI|endPoint|apiKey|city2|
|baseURI|endPoint|apiKey|city3|

@SeriveTest   @SeriveTest2
Scenario Outline: To check if we get valid status code upon providing valid city
Given Setting up Rest APi ELements like "<baseURI>","<endPoint>","<apiKey>","<city>"
When Calling NDTV Weather API to get weather details
Then Verify status code should be "<status_code>"

Examples:
|baseURI|endPoint|apiKey|city|status_code|
|baseURI|endPoint|apiKey|city1|200|
|baseURI|endPoint|apiKey|city2|200|
|baseURI|endPoint|apiKey|city3|200|


@SeriveTest @SeriveTest3
Scenario Outline: To check the content type of the response
Given Setting up Rest APi ELements like "<baseURI>","<endPoint>","<apiKey>","<city>"
When Calling NDTV Weather API to get weather details
Then Verify content type of the response "<content_type>"

Examples:
|baseURI|endPoint|apiKey|city|content_type|
|baseURI|endPoint|apiKey|city1|content_type|
|baseURI|endPoint|apiKey|city2|content_type|
|baseURI|endPoint|apiKey|city3|content_type|




@SeriveTest @SeriveTest4
Scenario Outline: To check if we get expected error code upon providing invalid city
Given Setting up Rest APi ELements like "<baseURI>","<endPoint>","<apiKey>","<city>"
When Calling NDTV Weather API to get weather details
Then Verify status code should be "<status_code>"

Examples:
|baseURI|endPoint|apiKey|city|status_code|
|baseURI|endPoint|apiKey|invalidcity1|404|
|baseURI|endPoint|apiKey|invalidcity2|404|
|baseURI|endPoint|apiKey|invalidcity3|400|

