package com.ebay.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.qa.base.base;

public class homePagep extends base 
{

	
	
	
	//page factory

	//@FindBy(xpath = "//div[@id ='gh-top']//ul[@id='gh-topl']//li[@id='gh-eb-u']//button//b[contains(text(), 'Bharath')]")
	//WebElement owner;
	
	@FindBy(id="gh-logo")
	WebElement logoo;
	
	public homePagep() throws IOException
	{
		super();
		PageFactory.initElements(driver, this);
		
	}
	
	public String checkowner()
	{
		String hk = driver.findElement(By.xpath("//div[@id ='gh-top']//ul[@id='gh-topl']//li[@id='gh-eb-u']//button//b[contains(text(), 'Bharath')]")).getText();
		System.out.println(hk);
		return hk;
	}
	
	public boolean checklogon()
	{
		return logoo.isDisplayed();
		
		
	}
}
