Feature: Place API's Validations

@AddPlace @Regression
Scenario Outline: Add place requests validation
Given : Requests payload are avaialble with "<name>" "<language>" "<address>"
When : User calls "AddPlaceAPI" with "Post" http reuest
Then : User see the statuscode is 200
And : User see the "status" is "OK"
And : User see the "scope" is "APP"
And : Verify place_id is created maps to "<name>" using "GetPlaceAPI"

Examples: 
|name             |language |address               |
|Sanjay Choudhary1|English1 |Garero ki dhani chomu1|
|Sanjay Choudhary2|English2 |Garero ki dhani chomu2|
|Sanjay Choudhary3|English3 |Garero ki dhani chomu3|
|Sanjay Choudhary4|English4 |Garero ki dhani chomu4|
|Sanjay Choudhary5|English5 |Garero ki dhani chomu5|



@DeletePlace @Regression
Scenario: Verify if Delete Place functionality is working
Given DeletePlace Payload
When : User calls "DeletePlaceAPI" with "Post" http reuest
Then : User see the statuscode is 200
And : User see the "status" is "OK"
