package TC001;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_request_Authorisation {

	@Test
	public void authorisationTest() 
	{
		//Base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
		
		//Base Authentication
		PreemptiveBasicAuthScheme basicAuth = new PreemptiveBasicAuthScheme();
		basicAuth.setUserName("ToolsQA");
		basicAuth.setPassword("TestPassword");
		
		RestAssured.authentication=basicAuth;
		
		//Request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response object
		Response response = httpRequest.get("/");
		
		//printing response body on console
		String responseBody = response.getBody().asString();
		
		System.out.println("response body : "+responseBody);
		
		response.getStatusCode();
		Assert.assertTrue(false);
		
		
	}
}
