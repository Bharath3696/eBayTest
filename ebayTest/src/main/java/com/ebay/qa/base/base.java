package com.ebay.qa.base;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;

public class base 
{

	public static WebDriver driver;
	public static Properties prop;
	
	public base() throws IOException
	{
		prop = new Properties();
		
		try
		{
			FileInputStream ip = new FileInputStream("A:\\eclipse prgrams\\ebayTest\\src\\main\\java\\com\\ebay\\qa\\config\\confingfile.properties");
            prop.load(ip);		
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	public static void initialize()
	{
		String need = prop.getProperty("browser");
		
		if(need.equals("chrome"))
		{
			//System.setProperty("webdriver.http.factory", "jdk-http-client");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			System.setProperty("webdriver.chrome.driver","A:\\crm\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver(options);
			//driver = new ChromeDriver();
		}
		
		else if(need.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","A:\\crm\\chromedriver_win32\\gecko.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(prop.getProperty("url"));
		
	}
	
}
