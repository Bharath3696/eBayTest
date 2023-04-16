package com.ebay.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebay.qa.base.base;
import com.ebay.qa.pages.homePagep;
import com.ebay.qa.pages.loginPage;

public class homePageTest extends base {

	public homePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	public homePagep hp;
	public loginPage lp;
	
@BeforeMethod
public void launch() throws IOException
{
	initialize();
	hp = new homePagep();
	lp = new loginPage();
	hp = lp.sigin(prop.getProperty("username"), prop.getProperty("pwd"));	
}
@Test
public void owner()
{
String vb = hp.checkowner();
Assert.assertEquals(vb, "Bharath");

}
}
