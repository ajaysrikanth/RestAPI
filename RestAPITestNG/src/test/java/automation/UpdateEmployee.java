package automation;

import org.testng.annotations.Test;

import DataDriven.base;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateEmployee extends base {
	
	int empID = base.empID;
	
	@Test
	public void putUpdateEmployee() throws InterruptedException {
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification request = RestAssured.given();
		
		String body = "{\"name\":\"Ajay\",\"salary\":\"100000\",\"age\":\"28\"}";
		
		request.header("Content-Type","application/json").body(body);
		
		Response response = request.put("/update/"+this.empID);
		
		Thread.sleep(5000);
		
		String responseBody = response.getBody().asString();
		
		log.info("responseBody : "+responseBody);
		
		log.info(response.getStatusCode());
		
	}

}
