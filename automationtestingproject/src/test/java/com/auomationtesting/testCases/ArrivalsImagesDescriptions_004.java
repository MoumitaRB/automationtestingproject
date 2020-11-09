package com.auomationtesting.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.ArrivalsImageAddPage;
import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.testBase.BaseClass;

public class ArrivalsImagesDescriptions_004 extends BaseClass{
	
	public HomePage hp;
	public ArrivalsImageAddPage aipObj;
	
	@Test(groups= {"Regression test"})
	public void verifyingProductDescriptionDetails() throws InterruptedException, IOException
	{
		driver.get(propObj.getProperty("baseURL"));
		hp=new HomePage(driver);
		logger.info("**************************Starting of ArrivalsImagesDescriptions_004**********************" );
		hp.clickOnShopBtn();
		Thread.sleep(3000);
		hp.clickOnHomeBtn();
		Thread.sleep(3000);
		hp.clickOnArrivalsImg();
		aipObj = new ArrivalsImageAddPage(driver);
		aipObj.clickOnDescriptionBtn();
		boolean status=aipObj.getProductDescriptionDetails("The Selenium WebDriver Recipes book");
		if(status==true)
		{  
			logger.info("***************************Status verification is successful**************************");
			Assert.assertTrue(true);
		}
		else
		{   
			logger.warn("**************************Status verification is not successful*************************");
			captureScreens(driver, "verifyingProductDescriptionDetails");
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
		
		logger.info("******************************Ending of ArrivalsImagesDescriptions_004**************************");
	}
	

}
