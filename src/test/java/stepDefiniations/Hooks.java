package stepDefiniations;

import java.io.IOException;

import cucumber.api.java.Before;


public class Hooks {

	@Before("@DeletePlace")
	public void beforScenario() throws IOException
	{
		if(placeAPIValidationsstep.place_id==null)
		{
		placeAPIValidationsstep stdef = new placeAPIValidationsstep();
		stdef._requests_payload_are_avaialble_with_something_something_something("Sanjay Choudhary", "Hindi", "Railway station Garero ki dhani");
		stdef.user_calls_with_http_reuest("AddPlaceAPI", "Post");
		stdef.verify_place_id_is_created_maps_to_using("Sanjay Choudhary", "GetPlaceAPI");
		
		}
	}
	
}
