package com.studentapi.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	public static String getRandomName() {
		String name=RandomStringUtils.randomAlphabetic(10);
		return name;				
	}
	public static String getRandomLocation() {
		String location=RandomStringUtils.randomAlphabetic(6);
		return location; 
	}
	public static String getPhoneNumber() {
		String phone=RandomStringUtils.randomNumeric(10);
		return phone;
	}
}
