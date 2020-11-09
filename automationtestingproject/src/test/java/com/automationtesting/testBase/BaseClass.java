package com.automationtesting.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	public Properties propObj;
	public Logger logger= LogManager.getLogger(this.getClass());
	
	@Parameters("browser")

	@BeforeClass(alwaysRun=true)
	
	public void setUp(String browserName) throws IOException
	{
		
		//load configuration file
	   propObj= new Properties();
	   FileInputStream configprop= new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\config.properties");
	   propObj.load(configprop);
	   
	   // open browser
	   if(browserName.equals("chrome"))
	   {   
	       WebDriverManager.chromedriver().setup();
	       driver =new ChromeDriver();
	   }
	   else if(browserName.equals("firefox"))
	   {
		   WebDriverManager.firefoxdriver().setup();
		   driver= new FirefoxDriver();
	   }
	   
	   //global wait
	   
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreens(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile= ts.getScreenshotAs(OutputType.FILE);
		File targetfile = new File(System.getProperty("user.dir")+"\\Screenshots\\"+tname+".png");
		FileUtils.copyFile(sourcefile, targetfile);
		System.out.println("Screenshots taken.....");
	}
	
	
}
