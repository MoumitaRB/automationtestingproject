package com.auomationtesting.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.testBase.BaseClass;

public class HomePageWithThreeArrivalsOnly_002 extends BaseClass {
	
	public HomePage hp;
	 
	@Test(groups= {"Sanity test"})
	public void  verifyingArrivalsTest() throws InterruptedException, IOException
	{   
		logger.info("**********************Launching URL****************************");
		driver.get(propObj.getProperty("baseURL"));
	    hp=new HomePage(driver);
	    
	    hp.clickOnShopBtn();
		Thread.sleep(3000);
		logger.info("*********************Viewing homepage****************************");
		hp.clickOnHomeBtn();
		Thread.sleep(3000);
	   
	    boolean status= hp.arrivalsPresentInHomePage("Selenium Ruby", "Thinking in HTML", "Mastering JavaScript", 3);
	    Thread.sleep(3000);
		if(status==true)
		{  
			logger.info("*************************3 arrivals are present in the homepage********************");
			Assert.assertTrue(true);
		}
		else
		{   logger.warn("***********************3 arrivals are not present in the homepage*******************");
		    captureScreens(driver, "verifyingArrivalsTest");
			Assert.assertTrue(false);
		}
		
		Thread.sleep(3000);
	}

}
