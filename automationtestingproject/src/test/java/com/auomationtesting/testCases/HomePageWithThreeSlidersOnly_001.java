package com.auomationtesting.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.testBase.BaseClass;

public class HomePageWithThreeSlidersOnly_001 extends BaseClass {
	
	public HomePage hp;
	
	@Test(groups= {"Sanity test"})
	public void verifyingSliderTest() throws InterruptedException, IOException
	{   
		logger.info("******************Starting HomePageWithThreeSlidersOnly_001***************************");
		
		driver.get(propObj.getProperty("baseURL"));
		hp=new HomePage(driver);
		
		hp.clickOnShopBtn();
		Thread.sleep(3000);
		hp.clickOnHomeBtn();
		Thread.sleep(3000);
		logger.info("****************************Verifying slider method******************************");
	    boolean status =hp.slidersPresentInHomePage("Shop Selenium Books", "HTML", "JavaScript", 3);
	    Thread.sleep(3000);
	    
		if(status==true)
		{   
			logger.info("**************************Found 3 sliders successflly in homepage*************************");
			Assert.assertTrue(true);
		}
		else
		{   
			logger.warn("*************************Found more than 3 sliders in homepage******************************");
			captureScreens(driver, "verifyingSliderTest");
			Thread.sleep(3000);
			Assert.assertTrue(false);
		}
		
		Thread.sleep(3000);
	}

}
