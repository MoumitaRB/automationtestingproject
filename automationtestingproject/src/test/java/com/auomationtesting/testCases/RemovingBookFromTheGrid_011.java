package com.auomationtesting.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.ArrivalsImageAddPage;
import com.automationtesting.pageObjects.CheckOutPage;
import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.testBase.BaseClass;

public class RemovingBookFromTheGrid_011 extends BaseClass{
	public HomePage hp;
	public ArrivalsImageAddPage aipObj;
	public CheckOutPage cpObj;
	
	
	@Test
	public void verifyingRemovedConfirmMsgTest() throws InterruptedException, IOException
	{
		driver.get(propObj.getProperty("baseURL"));
		hp=new HomePage(driver);
		logger.info("**********************Starting of RemovingBookFromTheGrid_011***********************" );
		hp.clickOnShopBtn();
		Thread.sleep(3000);
		hp.clickOnHomeBtn();
		Thread.sleep(3000);
		
		hp=new HomePage(driver);
		hp.clickOnMasteringInJavaImg();
		Thread.sleep(2000);
		
		aipObj=new ArrivalsImageAddPage(driver);
		aipObj.clickOnAddToBasket();
		aipObj.clickOnViewBasketBtn();
		Thread.sleep(2000);
		
		cpObj=new CheckOutPage(driver);
		cpObj.clickOnRemoveBtn();
		Thread.sleep(2000);
		boolean status=cpObj.verifyingRemovedCrfMsg("Mastering JavaScript removed. ");
		if(status==true)
		{   
			logger.info("***************************Status verification is successful************************");
			Assert.assertTrue(true);
		}
		else
		{  
		   logger.warn("*****************************Status verification is not successful***********************");
		   captureScreens(driver,"verifyingRemovedConfirmMsgTest");
		   Thread.sleep(3000);
		   Assert.assertTrue(false);
		}
		
		logger.info("*************************Ending of RemovingBookFromTheGrid_011***************************");
		
	}

}
