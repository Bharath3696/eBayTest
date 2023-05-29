package com.ebay.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.ebay.qa.base.base;
import com.ebay.qa.pages.homePagep;
import com.ebay.qa.pages.loginPage;

public class Log4jAPI_example extends base {
	
	public homePagep hj;
	public loginPage jp;
	Logger lg = Logger.getLogger(Log4jAPI_example.class);
	
	//  what is log? : capturing info/activities at the time of program execution.
	
	// types of logs :
	     // 1. info
	     // 2. warnings
	     // 3. error
	     // 4. fatal
	
// how to generate the logs : in java, logs are created using Apache log4j API(log4j jar)
// how it works? : it reads log4j configuration from log4j.properties file	

	public Log4jAPI_example() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	//WebDriver driver;
	
	@BeforeMethod
	public void initial() throws IOException
	{
		initialize();
		jp = new loginPage();
		hj= new homePagep();
		hj = jp.sigin(prop.getProperty("username"), prop.getProperty("pwd"));
		lg.info("*****************successfully loggedin*********************");
	}
	
	@Test
	public void owner()
	{
		String mlm = hj.checkowner();
		Assert.assertEquals(mlm, "Bharath");
		
	}
	
	@Test
	public void logoo() throws IOException
	{
		boolean kk = hj.checklogon();
		Assert.assertTrue(kk);
		
	} 
	
	@AfterMethod
	public void teardow()
	{
		driver.quit();
	}
	
}

