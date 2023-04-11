package com.studentapi.testCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.studentapi.base.TestBase;
import com.studentapi.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC003_POST_AddStudent extends TestBase{
	
	String name=RestUtils.getRandomName();
	String location=RestUtils.getRandomLocation();
	String phone=RestUtils.getPhoneNumber();

	
	@BeforeClass
	void getSingleStudent() {
		logger.info("--------TC003_POST_AddStudent Started-----------");
		RestAssured.baseURI="http://localhost:3000/students";
		httpRequest=RestAssured.given();
		
		JSONObject reqParams=new JSONObject();
		reqParams.put("name", name);
		reqParams.put("location", location);
		reqParams.put("Phone", phone);
		httpRequest.header("Content-Type","application/json");
		
		httpRequest.body(reqParams.toJSONString());
		
		response=httpRequest.request(Method.POST);
	}
	
	@Test
	void checkResponseBody() {
		logger.info("--------Checking response body-----------");
		String responseBody=response.getBody().asString();
		logger.info("Response body:"+responseBody);
		Assert.assertEquals(responseBody.contains(name),true);
	}
	@Test
	void checkStatusCode() {
		logger.info("--------Checking status code-----------");
		int statusCode=response.getStatusCode();
		logger.info("Staus code:"+statusCode);
		Assert.assertEquals(statusCode, 201);
	}
	
	@Test
	void checkStatusLine() {
		logger.info("--------Checking Status Line-----------");
		String statusLine=response.getStatusLine();
		logger.info("Staus Line:"+statusLine);
		//Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
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
		logger.info("--------TC001_POST_AddStudents Finished-----------");
	}
}
