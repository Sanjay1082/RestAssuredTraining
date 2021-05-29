package stepDefiniations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import testDataAddAPI.AddAPIPayload;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.runner.RunWith;

import POJO.RequestPayload;
import POJO.ResponseAddReq;
import Util.APIResources;
import Util.Utils;



@RunWith(Cucumber.class)
public class placeAPIValidationsstep {
	

	Response response;
	RequestSpecification ReqSpec;
	ResponseSpecification ResSpec;
	static String place_id;

    
    @Given("^: Requests payload are avaialble with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void _requests_payload_are_avaialble_with_something_something_something(String name, String language, String address) throws IOException  {
        
    	ReqSpec=given().spec(Utils.requestSpec()).body(AddAPIPayload.AddPayload(name, language, address));
    }
    
    @When("^: User calls \"([^\"]*)\" with \"([^\"]*)\" http reuest$")
    public void user_calls_with_http_reuest(String resources, String requestType) throws IOException {
    	
    	APIResources APIRes = APIResources.valueOf(resources);
    	
    	if(requestType.equalsIgnoreCase("Post"))
    	{
    	 response = ReqSpec.
        			when().post(APIRes.getResources());
    	}else if(requestType.equalsIgnoreCase("Get"))
    	{
       	 response = ReqSpec.queryParam("place_id", place_id).
       			 when().get(APIRes.getResources());
    	}
    }
    
    
    @Then("^: User see the \"([^\"]*)\" is \"([^\"]*)\"$")
    public void _user_see_the_something_is_something1(String strArg1, String strArg2){
       
    	assertEquals(Utils.getValueResponse(response, strArg1).toString(), strArg2);
    }
    
    @Then("^: User see the statuscode is (\\d+)$")
    public void user_see_the_statuscode_is(int statuscode){
        assertEquals(response.getStatusCode(), statuscode);
    }
    
    @Then("^: Verify place_id is created maps to \"([^\"]*)\" using \"([^\"]*)\"$")
    public void verify_place_id_is_created_maps_to_using(String name, String resources) throws IOException {
        
    	place_id = Utils.getValueResponse(response, "place_id");
    	ReqSpec=given().spec(Utils.requestSpec()).queryParam("place_id",place_id);
    	user_calls_with_http_reuest(resources,"Get");
		String actualName=Utils.getValueResponse(response,"name");
		assertEquals(actualName,name);
              System.out.println("My name is Sanjay Choudhary");
    }
    
    @Given("^DeletePlace Payload$")
    public void deleteplace_Payload() throws IOException{
    	ReqSpec = given().spec(Utils.requestSpec()).body(AddAPIPayload.DeletePlacePayLoad(place_id));
    	
    }
    
  }

