package TC001;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POST_Request {
	
	@Test
	void registerCustomer() 
	{
				//base URI
				RestAssured.baseURI="https://reqres.in/api";
				
				//Request object
				RequestSpecification httpRequest=RestAssured.given();
				
								
				//Request payload or Request body
				JSONObject requestParams = new JSONObject();
				requestParams.put("name","morpheus");
				requestParams.put("job", "leader");
				
				//while sending request three parts will be shared (header,body and request method)
				//Response response=httpRequest.header("Content-Type","application/json").body(requestParams.toJSONString()).post("/users");
				
				//request header type
				httpRequest.header("Content-Type","application/json");
				
				//attach data to json string
				httpRequest.body(requestParams.toJSONString());
				
				//Response object
				Response response = httpRequest.post("/users");
				
				//print response in console window
				String responseBody = response.getBody().asString();
				System.out.println("Response Body is : "+responseBody);
				
				//status code validation
				int statusCode = response.getStatusCode();
				System.out.println("Status code is : "+statusCode);
				Assert.assertEquals(statusCode, 201);
				
				//created validation
				String created = response.jsonPath().get("createdAt");
				System.out.println("created At : "+created);
				
	}
}
