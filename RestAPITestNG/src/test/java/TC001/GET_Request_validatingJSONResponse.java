package TC001;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_Request_validatingJSONResponse {

	@Test
	public void validatingJSONbody() 
	{
		//specify base URI
		RestAssured.baseURI = "https://reqres.in/api/users";
		
		//Request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response object
		Response response=httpRequest.get("/2");
		
		//printing responsebody on console converting to string from JSON format
		String responseBody=response.getBody().asString();
		System.out.println("Response Body : \n "+responseBody);
		
		Assert.assertEquals(responseBody.contains("Janet"), true);
		
		JsonPath jsonpath = response.jsonPath();
		
		
		System.out.println("ID : "+jsonpath.get("data.id"));	//json response under data tag
		System.out.println("email : "+jsonpath.get("data.email"));
		System.out.println("first_name : "+jsonpath.get("data.first_name"));
		System.out.println("last_name : "+jsonpath.get("data.last_name"));
		System.out.println("avatar : "+jsonpath.get("data.avatar"));
		
		System.out.println("url : "+jsonpath.get("support.url"));	//json response under support tag
		System.out.println("text : "+jsonpath.get("support.text"));
		
		Assert.assertEquals(jsonpath.get("data.email"), "janet.weaver@reqres.in","email not matches");
		
		
	}
}
