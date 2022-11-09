package automation;

import org.testng.annotations.Test;

import DataDriven.base;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteEmployee extends base {

	int empID = base.empID;

	@Test
	public void deleteEmployee() throws InterruptedException {

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

		RequestSpecification request = RestAssured.given();

		Response response = request.delete("/delete/" + this.empID);

		Thread.sleep(5000);

		String responseBody = response.getBody().asString();

		log.info("responseBody : " + responseBody);

		log.info(response.getStatusCode());

	}

}
