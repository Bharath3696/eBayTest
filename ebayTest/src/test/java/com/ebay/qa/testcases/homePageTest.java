package com.ebay.qa.testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ebay.qa.base.base;
import com.ebay.qa.pages.homePagep;
import com.ebay.qa.pages.loginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class homePageTest extends base {

	public homePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	public homePagep hp;
	public loginPage lp;
	public ExtentReports extent;
	public ExtentTest logger;
	

@BeforeTest
public void setextent()
{
	extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/extenttt.html", true);
	extent.addSystemInfo("user Name", "Bharath Kumaar RJ");
	extent.addSystemInfo("Environment", "QA");
}



@BeforeMethod
public void launch() throws IOException
{
	initialize();
	hp = new homePagep();
	lp = new loginPage();
	hp = lp.sigin(prop.getProperty("username"), prop.getProperty("pwd"));	
	
}

public static String getScreenshot(WebDriver driver, String screenshotname) throws IOException
{
	String datename = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
	File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String destination = System.getProperty("user.dir")+"/failedtestscreenshot/"+screenshotname+datename+".png";
	File finalDestination = new File(destination);
	FileUtils.copyFile(src, finalDestination);
	return destination;
}

@Test
public void owner()
{
	logger=extent.startTest("owner");
String vb = hp.checkowner();
Assert.assertEquals(vb, "harath");

}

@AfterTest
public void slowdown()
{
	extent.flush();
	
}

@AfterMethod
public void teardown(ITestResult result)throws IOException
{
	if(result.getStatus()==ITestResult.FAILURE)
	{
		logger.log(LogStatus.FAIL, "TEST CASE FAILED IS"+result.getName()); //to add a name in extent report.
		logger.log(LogStatus.FAIL, "TEST CASE FAILED IS"+result.getThrowable()); //to add error/exception in extent report.
		
		String screenshotpath = homePageTest.getScreenshot(driver, result.getName());
		logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotpath));
	}
	else if(result.getStatus()==ITestResult.SKIP)
	{
		logger.log(LogStatus.SKIP, "TEST CASE SKIPPED IS"+result.getName()); //to add a name in extent report.
	}
	
	else if(result.getStatus()==ITestResult.SUCCESS)
	{
		logger.log(LogStatus.PASS, "TEST CASE PASSED IS "+result.getName()); //to add a name in extent report.
	}
	
	
	extent.endTest(logger);
	driver.close();
}
}

