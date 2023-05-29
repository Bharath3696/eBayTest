
package com.ebay.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebay.qa.base.base;
import com.ebay.qa.pages.homePagep;
import com.ebay.qa.pages.loginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class loginePageTest extends base {
	
	public loginPage lp =new loginPage();
	public homePagep hp = new homePagep();
	public ExtentReports extent;
	public ExtentTest logger;
	
	//public base jj = new base();
	

	loginePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void extent()
	{
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/extenttt.html", true);
		extent.addSystemInfo("user Name", "Bharath Kumaar RJ");
		extent.addSystemInfo("Environment", "QA");
	}
	
	@BeforeMethod
	public void setup() throws IOException
	{
		initialize();
		lp = new loginPage();
					
	}
	
	@Test(priority =1)
	public void checklogologin() throws IOException
	{
		
		boolean n = lp.check_logo();
		Assert.assertTrue(n);
		
	}
	
	@Test(priority =2)
	public void uname() throws IOException 
	{
		hp = lp.sigin(prop.getProperty("username"), prop.getProperty("pwd"));
	}
	
	@Test(priority =3)
	public void passlogo()
	{
	 boolean k = lp.check_logo();
	 Assert.assertTrue(k);
	}
	
	
	
	@AfterMethod
	public void Teardown() 
	{
		driver.quit();
	}
	
	@AfterMethod
	public void closeext()
	{
		extent.flush();
		extent.close();
	}
	
	
	

}
