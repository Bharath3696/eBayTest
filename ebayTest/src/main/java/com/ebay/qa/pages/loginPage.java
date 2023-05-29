package com.ebay.qa.pages;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.qa.base.base;

public class loginPage extends base {
	
	//page factory or object repository
	
	@FindBy(id = "userid")
	WebElement username;
	
	@FindBy(id = "signin-continue-btn")
	WebElement user_continue;
	
		
	@FindBy(id= "gh-logo")
	WebElement logo;
	
	@FindBy(id = "pass")
	WebElement password;
	
	@FindBy(id = "sgnBt")
	WebElement pass_continue;
	
	
	
	public loginPage() throws IOException
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean check_logo()
	{
		return logo.isDisplayed();
	}
	
	public String page_title()
	{
		return driver.getTitle();
	}
	
	public homePagep sigin(String kk, String pp) throws IOException
	{
		username.sendKeys(kk);
		user_continue.click();

		password.sendKeys(pp);
		pass_continue.click();
		
		return new homePagep();
	}
	

}
