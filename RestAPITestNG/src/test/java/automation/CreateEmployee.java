package automation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import DataDriven.base;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.RestUtils;

public class CreateEmployee extends base {
	
	String empName = RestUtils.empName();
	double empSalary = RestUtils.empSalary();
	int empAge = RestUtils.empAge();

	@Test
	public void postCreate() throws InterruptedException {
		
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		
		RequestSpecification request = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("name", empName);
		requestParams.put("salary", empSalary);
		requestParams.put("age", empAge);
		
		request.header("Content-Type","application/json").body(requestParams.toJSONString());
		
		Response response = request.post("/create");
		
		Thread.sleep(5000);
		
		String responseBody = response.asString();
		
		log.info(responseBody);
		
		log.info(response.getStatusCode());
		
		log.info(response.getStatusLine());
		
		Assert.assertTrue(responseBody.contains(empName));
		
	}
}
