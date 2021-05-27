package Util;

import static org.hamcrest.Matchers.equalTo;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {

	public static RequestSpecification req;
	
	public static RequestSpecification requestSpec() throws IOException
	{	
		if(req==null)
		{
		PrintStream prints = new PrintStream(new FileOutputStream("IOlogs.txt"));
	    req=	new RequestSpecBuilder().
	    addFilter(RequestLoggingFilter.logRequestTo(prints)).
	    addFilter(ResponseLoggingFilter.logResponseTo(prints)).
		setBaseUri(getProprty("baseURI")).
		setContentType(ContentType.JSON).
		addQueryParam("key", "qaclick123").
		build();
		return req;
		}
		return req;
	}

	public static ResponseSpecification responseSpec()
	{
		ResponseSpecification res = new ResponseSpecBuilder().
	    			expectStatusCode(200).
					expectContentType(ContentType.JSON).
					expectBody("scope", equalTo("APP")).
					build();
		 return res;
	}
	
	public static String getProprty(String Key) throws IOException {
		
		Properties pro = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\sanjay.choudhary\\eclipse-workspace\\E2EFramework_Module16\\src\\main\\java\\Config\\property");
		pro.load(file);
		return pro.getProperty(Key);
		
	}
	
	public static String getValueResponse(Response res, String str2)
	{
		JsonPath js = new JsonPath(res.asString());
		return js.get(str2).toString();
		
	}
}
