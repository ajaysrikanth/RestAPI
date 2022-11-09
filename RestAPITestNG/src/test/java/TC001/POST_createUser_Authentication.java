package TC001;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DataDriven.base;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.Excel_Utility;

public class POST_createUser_Authentication {

	public Logger log = Logger.getLogger(POST_createUser_Authentication.class);


	@Test(dataProvider = "userdata")
	public void createID(String uname, String umail, String ugender, String ustatus) 
	{
		java.util.logging.Logger.getLogger("org.apache.http.wire").setLevel(java.util.logging.Level.FINEST);
		java.util.logging.Logger.getLogger("org.apache.http.headers").setLevel(java.util.logging.Level.FINEST);
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
		System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
		System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire", "ERROR");
		System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "ERROR");
		System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.headers", "ERROR");//System.setProperty("org.freemarker.loggerLibrary", "none");

		RestAssured.baseURI="https://gorest.co.in/public/v2";
		
		String token = "3f5c7f02425830f7cd8653af86ab200f8512a4f3a89deb1b0008b4a1c015f396";
			
		RequestSpecification httpRequest = RestAssured.given();
		
		
		JSONObject requestParam = new JSONObject();
		
		requestParam.put("name", uname);
		requestParam.put("email", umail);
		requestParam.put("gender", ugender);
		requestParam.put("status", ustatus); 
		
		//code to send bearer token for authorization
		httpRequest.auth().oauth2(token);
		
		httpRequest.header("Content-Type","application/json");
		
		httpRequest.body(requestParam.toJSONString());
		
		
		Response response = httpRequest.post("/users");
		
		String responseBody = response.getBody().asString();
		log.info(responseBody);
		System.out.println(responseBody);
		
		Assert.assertEquals(responseBody.contains("has already been taken")||responseBody.contains(uname), true);
		Assert.assertEquals(responseBody.contains("has already been taken")||responseBody.contains(umail), true);
		Assert.assertEquals(responseBody.contains("has already been taken")||responseBody.contains(ugender), true);
		Assert.assertEquals(responseBody.contains("has already been taken")||responseBody.contains(ustatus), true);

		
		
	
	}

	@DataProvider(name = "userdata")		
	String [] [] getUserData() throws IOException {
		
		//String [] [] userdata= {{"salman1","salman12@gmail.com","female","active"},{"salman singh","salmansingh@gmail.com","male","active"}};
		
		String excelPath = "./src\\test\\java\\utility\\EmpData.xlsx";
		
		int rowCount=Excel_Utility.getRowCount(excelPath, "Sheet1");
		int colCount=Excel_Utility.getCellCount(excelPath, "Sheet1", 1);
		
		String userdata[][] = new String [rowCount][colCount];
		
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<colCount;j++) 
			{
				userdata[i-1][j]=Excel_Utility.getCellData(excelPath, "Sheet1", i, j);
			}
		}
		
		
		return userdata;
		
	}
}
