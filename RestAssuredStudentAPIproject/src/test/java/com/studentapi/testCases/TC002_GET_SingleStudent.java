package com.studentapi.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.studentapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TC002_GET_SingleStudent extends TestBase{
	//int studentID;
	@BeforeClass
	void getSingleStudent() {
		logger.info("--------TC002_GET_SingleStudent Started-----------");
		RestAssured.baseURI="http://localhost:3000/students";
		httpRequest=RestAssured.given();
		Response response1=httpRequest.request(Method.GET);
		
		JsonPath jsonpath=response1.jsonPath();
		
		int studentID=jsonpath.get("[0].id");
		response=httpRequest.request(Method.GET,"/"+studentID);
	}
	
	@Test
	void checkResponseBody() {
		logger.info("--------Checking response body-----------");
		String responseBody=response.getBody().asString();
		logger.info("Response body:"+responseBody);
	//	Assert.assertEquals(responseBody.contains(studentID),true);
	}
	@Test
	void checkStatusCode() {
		logger.info("--------Checking status code-----------");
		int statusCode=response.getStatusCode();
		logger.info("Staus code:"+statusCode);
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	void checkStatusLine() {
		logger.info("--------Checking Status Line-----------");
		String statusLine=response.getStatusLine();
		logger.info("Staus Line:"+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
	@Test
	void checkHeader() {
		logger.info("--------Checking Header Line-----------");
		String header=response.getHeader("Content-Type");
		logger.info("Content-Type:"+header);
		Assert.assertEquals(header, "application/json; charset=utf-8");
	}
	
	@AfterClass
	void tearDown() {
		logger.info("--------TC002_GET_SingleStudents Finished-----------");
	}
}
