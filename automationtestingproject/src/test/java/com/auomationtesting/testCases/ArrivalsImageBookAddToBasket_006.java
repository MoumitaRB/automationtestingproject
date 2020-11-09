package com.auomationtesting.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.ArrivalsImageAddPage;
import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.testBase.BaseClass;

public class ArrivalsImageBookAddToBasket_006 extends BaseClass{
	
	public HomePage hp;
	public ArrivalsImageAddPage aipObj;
	
	
	@Test
	public void verifyingConfirmAddedMsgTest() throws InterruptedException, IOException
	{
		driver.get(propObj.getProperty("baseURL"));
		hp=new HomePage(driver);
		logger.info("**************************Starting of ArrivalsImageBookAddToBasket_006****************************");
		hp.clickOnShopBtn();
		Thread.sleep(3000);
		hp.clickOnHomeBtn();
		Thread.sleep(3000);
		hp.clickOnArrivalsImg();
		Thread.sleep(3000);
		
		aipObj=new ArrivalsImageAddPage(driver);
		aipObj.clickOnAddToBasket();
		Thread.sleep(3000);
		
		boolean status=aipObj.verifyingConfirmAddedMsg("“Selenium Ruby” has been added to your basket.");
		if(status==true)
		{   
			logger.info("********************Status verification is successful***************************");
			Assert.assertTrue(true);
		}
		else
		{   
			logger.warn("********************Status verification is not successful**************************");
			captureScreens(driver, "verifyingConfirmAddedMsgTest");
			Assert.assertTrue(false);
		}
		Thread.sleep(2000);
	}
	
	@Test(dependsOnMethods="verifyingConfirmAddedMsgTest")
	public void verifyingAddedBookInViewBasketTest() throws InterruptedException, IOException
	{
		aipObj.clickOnViewBasketBtn();
		Thread.sleep(3000);
		boolean status=aipObj.verifyingBookInViewBasket("Selenium Ruby", 500.00);
		if(status==true)
		{   
			logger.info("********************Status verification is successful*************************");
			Assert.assertTrue(true);
		}
		else
		{   
			logger.warn("*********************Status verification is not successful*******************");
			captureScreens(driver,"verifyingAddedBookInViewBasketTest");
			Assert.assertTrue(false);
		}
		
		logger.info("***********************Ending of ArrivalsImageBookAddToBasket_006***************************");
		Thread.sleep(3000);
	}
}
