package TC001;

import org.testng.Assert;
import org.testng.annotations.Test;

import DataDriven.base;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_MAP_request {

	@Test
	void googleMap() 
	{
		//base URI
		RestAssured.baseURI="https://maps.googleapis.com";
	
		
		//Request object
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response object
		Response response = httpRequest.request(Method.GET,"/maps/api/place/nearbysearch/xm/?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AlzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
		
		//print response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is : "+responseBody);
		
		//status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is : "+statusCode);
		
		//capture details and validating of headers from response
		
		String contentType=response.getHeader("Content-Type");	//validating content type
		System.out.println("Content-Type : "+contentType);
		Assert.assertEquals(contentType, "text/html; charset=UTF-8");
		

		String contentLength=response.getHeader("Content-Length");	//validating content type
		System.out.println("Content-Length : "+contentLength);
		Assert.assertEquals(contentLength, "1712");

		// captures all headers created in POST request
		// Headers headers=response.getHeaders();			// Headers contain both key and value hence Hashmap format Headers used
		// System.out.println("Headers list : "+ "\n"+ headers);
	
		Headers headers=response.headers();
		for(Header header:headers) {
			System.out.println(header.getName()+ " : "+header.getValue());
		}
		
		
	}
}
