package com.auomationtesting.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.ArrivalsImageAddPage;
import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.testBase.BaseClass;

public class ImageInArrivalsShouldNavigate_003 extends BaseClass {
	
	public HomePage hp;
	public ArrivalsImageAddPage aipObj;
	
	@Test(groups= {"Sanity test"})
	public void verifyingArrivalsImgIsClickable() throws InterruptedException, IOException 
	{
		driver.get(propObj.getProperty("baseURL"));
	    hp=new HomePage(driver);
	    logger.info("******************************Starting of ImageInArrivalsShouldNavigate_003*********************************");
	    hp.clickOnShopBtn();
		Thread.sleep(3000);
		hp.clickOnHomeBtn();
		Thread.sleep(3000);
		
	    boolean status=hp.isImgClickable();
	    if(status==true)
	    {   
	    	logger.info("************************Status verification is successful***********************");
	    	Assert.assertTrue(true);
	    }
	    else
	    {   
	    	logger.warn("*************************Status verification is not successful*******************");
	    	captureScreens(driver,"verifyingArrivalsImgIsClickable");
	    	Assert.assertTrue(false);
	    }
	}
	
	@Test
	public void verifyingArrivalsImgIsNavigatingToNextPage() throws InterruptedException, IOException
	{
		boolean status=hp.arrivalImgesNavigatingToNextPage("Selenium Ruby","Thinking in HTML","Mastering JavaScript");
		Thread.sleep(3000);
		if(status==true)
		{   
			logger.info("***************************Status verification is successful***************************");
			Assert.assertTrue(true);
		}
		else
		{   
			logger.warn("***************************Status verification is not successful**************************");
			captureScreens(driver, "verifyingArrivalsImgIsNavigatingToNextPage");
			Assert.assertTrue(false);
		}
		
		Thread.sleep(3000);
		logger.info("**************************Ending of ImageInArrivalsShouldNavigate_003************************");
	}
    


}
