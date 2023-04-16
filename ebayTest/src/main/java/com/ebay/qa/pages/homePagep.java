package com.ebay.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ebay.qa.base.base;

public class homePagep extends base 
{

	
	public homePagep() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//page factory

	//@FindBy(xpath = "//div[@id ='gh-top']//ul[@id='gh-topl']//li[@id='gh-eb-u']//button//b[contains(text(), 'Bharath')]")
	//WebElement owner;
	
	public String checkowner()
	{
		String hk = driver.findElement(By.xpath("//div[@id ='gh-top']//ul[@id='gh-topl']//li[@id='gh-eb-u']//button//b[contains(text(), 'Bharath')]")).getText();
		System.out.println(hk);
		return hk;
	}
}
