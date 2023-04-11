package com.studentapi.base;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public String studentID="37";
	public Logger logger;
	@BeforeClass
	public void setUp() {
		logger=Logger.getLogger("StudentAPI");//Name of the project or any other name we can give
		PropertyConfigurator.configure("log4j.properties"); //location of the log4j.properties
		logger.setLevel(Level.INFO);
	}
}
