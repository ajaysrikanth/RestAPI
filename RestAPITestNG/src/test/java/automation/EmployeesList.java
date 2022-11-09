package automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import DataDriven.base;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EmployeesList extends base {

	@Test
	public void getEmployeesList() throws InterruptedException {
		
				
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.get("/employees");
		
		Thread.sleep(5000);
		
		String responseBody = response.getBody().asString();
		
		log.info("Response Body : "+responseBody);
		
		log.info("Status code : "+response.getStatusCode());
		
		log.info("Status line : "+response.getStatusLine());
		
		log.info("Content-Type : "+response.getHeader("Content-Type"));
		
		//Assert.assertEquals(response.getHeader("Content-Type"), "text/html; charset=UTF-8");
		
		log.info("Content-Encoding : "+response.getHeader("Content-Encoding"));
		
		Assert.assertEquals(response.getHeader("Content-Encoding"), "gzip");
		
		//log.info("Content-Length : "+Integer.parseInt(response.getHeader("Content-Length")));

		log.info(response.getHeaders());
		
		
	}
}
