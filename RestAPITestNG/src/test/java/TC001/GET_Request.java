package TC001;

import org.testng.Assert;
import org.testng.annotations.Test;

import DataDriven.base;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_Request {

	@Test
	void getWeatherDetails() 
	{
		//base URI
		RestAssured.baseURI="https://reqres.in/api/users";
		
		//Request object
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response object
		Response response = httpRequest.request(Method.GET,"");
		
		//print response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is : "+responseBody);
		
		//status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is : "+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//status line verification
		String statusLine=response.getStatusLine();
		System.out.println("status line is : "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
}
