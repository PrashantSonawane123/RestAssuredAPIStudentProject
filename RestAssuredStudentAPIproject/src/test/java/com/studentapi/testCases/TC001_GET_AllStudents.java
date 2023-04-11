package com.studentapi.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.studentapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC001_GET_AllStudents extends TestBase {
	@BeforeClass
	void getAllStudents() {
		logger.info("--------TC001_GET_AllStudents Started-----------");
		RestAssured.baseURI="http://localhost:3000/students";
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET);
	}
	
	@Test
	void checkResponseBody() {
		logger.info("--------Checking response body-----------");
		String responseBody=response.getBody().asString();
		logger.info("Response body:"+responseBody);
		Assert.assertTrue(responseBody!=null);
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
		logger.info("--------TC001_GET_AllStudents Finished-----------");
	}
	
	
}
