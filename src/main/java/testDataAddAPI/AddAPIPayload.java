package testDataAddAPI;

import java.util.ArrayList;
import java.util.List;

import POJO.Location;
import POJO.RequestPayload;

public class AddAPIPayload {

	public static RequestPayload AddPayload(String name, String language, String address)
	{
    	RequestPayload rp = new RequestPayload();
    	
    	rp.setAccuracy(50);
    	rp.setAddress(address);
    	rp.setLanguage(language);
    	rp.setPhone_number("(+91) 983 893 3937");
    	rp.setName(name);
    	rp.setWebsite("https://rahulshettyacedemy.com");
    	
    	List<String> list = new ArrayList<String>();
    	list.add("Shoe Park");
    	list.add("Shoe");
    	
    	rp.setTypes(list);
    	
    	Location l = new Location();
    	
    	l.setLat(23.4);
    	l.setLng(23.08);
    	
    	rp.setLocation(l);

    	return rp;
	}
	
	
	public static String DeletePlacePayLoad(String placeid)
	{
		return "{\r\n    \"place_id\":\""+placeid+"\"          \r\n}\r\n";
	}
	
}
