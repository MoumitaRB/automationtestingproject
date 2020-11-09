package com.auomationtesting.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.ArrivalsImageAddPage;
import com.automationtesting.pageObjects.CheckOutPage;
import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.testBase.BaseClass;

public class CheckingOutTheFinalPriceOfTheBook_013 extends BaseClass{
	
	public HomePage hp;
	public ArrivalsImageAddPage aipObj;
	public CheckOutPage cpObj;
	
	@Test
	public void verifyingTotalPriceInTheCheckOutGridTest() throws InterruptedException, IOException
	{
		driver.get(propObj.getProperty("baseURL"));
		hp=new HomePage(driver);
		logger.info("**********************Starting of CheckingOutTheFinalPriceOfTheBook_013*********************");
		hp.clickOnShopBtn();
		Thread.sleep(3000);
		hp.clickOnHomeBtn();
		Thread.sleep(3000);
		
		hp=new HomePage(driver);
		hp.clickOnMasteringInJavaImg();
		Thread.sleep(2000);
		
		aipObj=new ArrivalsImageAddPage(driver);
		aipObj.clickOnAddToBasket();
		aipObj.clickOnMenuItem();
		Thread.sleep(2000);
		
		cpObj=new CheckOutPage(driver);
		boolean totalPriceStatus=cpObj.verifyingTotalPriceInTheCheckOutGrid(367.50);
		Thread.sleep(3000);
		if(totalPriceStatus==true)
		{
			logger.info("*********************Total price status verification is successful********************");
			Assert.assertTrue(true);
		}
		else
		{
			logger.warn("*********************Toatl price status verification is not successful*******************");
			captureScreens(driver,"CheckingOutTheFinalPriceOfTheBook_013");
			Thread.sleep(3000);
			Assert.assertTrue(false);
		}
		
		logger.info("***********************Ending of CheckingOutTheFinalPriceOfTheBook_013**********************");
		
	}

}
