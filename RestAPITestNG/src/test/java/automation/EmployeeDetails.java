package automation;

import org.testng.annotations.Test;

import DataDriven.base;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EmployeeDetails extends base {

	@Test
	public void getEmployeeDetails () throws InterruptedException {
		
		//Logger log = Logger.getLogger(EmployeeDetails.class);
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.get("/employee/1");
		
		Thread.sleep(5000);
		
		String responseBody = response.getBody().asString();
		
		log.info("responseBody : "+responseBody);
		
		JsonPath jsonpath = response.jsonPath(); 
		
		log.info("json path status : "+jsonpath.get("data.id"));
		
		log.info(response.getHeader("Content-Length"));
		
		log.info("Headers : "+response.getHeaders());
	}
}
