package com.auomationtesting.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.ArrivalsImageAddPage;
import com.automationtesting.pageObjects.CheckOutPage;
import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.testBase.BaseClass;

public class UpdateBasketCheckingAfterAddingMoreBooks_012 extends BaseClass{
	public HomePage hp;
	public ArrivalsImageAddPage aipObj;
	public CheckOutPage cpObj;
	
	@Test
	public void verifyingMenuItemWithPriceBeforeUpdating() throws InterruptedException, IOException
	{
		driver.get(propObj.getProperty("baseURL"));
		hp=new HomePage(driver);
		logger.info("*************************Starting of UpdateBasketCheckingAfterAddingMoreBooks_012*************************");
		hp.clickOnShopBtn();
		Thread.sleep(3000);
		hp.clickOnHomeBtn();
		Thread.sleep(3000);
		
		hp=new HomePage(driver);
		hp.clickOnMasteringInJavaImg();
		Thread.sleep(2000);
		

		aipObj=new ArrivalsImageAddPage(driver);
		aipObj.clickOnAddToBasket();
		boolean statusBeforeUpdatingBasket=aipObj.verifyingMenuItemWithPrice("1 Item",350.00);
		Thread.sleep(3000);
		if(statusBeforeUpdatingBasket==true)
		{   
			logger.info("**********************Status before updating basket verification is successful*************************");
			Assert.assertTrue(true);
		}
		else
		{
			logger.warn("***********************Status before updating basket verification is not successful*********************");
			captureScreens(driver, "verifyingMenuItemWithPriceBeforeUpdating");
			Thread.sleep(2000);
			Assert.assertTrue(false);
		}
		
		
	}
	
	@Test(dependsOnMethods="verifyingMenuItemWithPriceBeforeUpdating")
	public void verifyingUpdateBasketClickableTest() throws InterruptedException, IOException
	{
		aipObj.clickOnMenuItem();
		Thread.sleep(2000);
		
		cpObj=new CheckOutPage(driver);
		boolean status=cpObj.isUpdateBasketBtnClickable("3");
		if(status==true)
		{   
			logger.info("***********************Status verification is successful**********************");
			Assert.assertTrue(true);
		}
		else
		{
			logger.warn("************************Status verification is not successful*********************");
			captureScreens(driver, "verifyingUpdateBasketClickableTest");
		    Thread.sleep(2000);
			Assert.assertTrue(false);
		}
		
		
	}
   
	@Test(dependsOnMethods="verifyingUpdateBasketClickableTest")
	public void verifyingMenuItemWithPriceAfterUpdatingBasket() throws InterruptedException, IOException
	{   
		cpObj.clickOnUpdateBasketBtn();
		Thread.sleep(3000);
		boolean statusAfterUpdatingBasket=cpObj.verifyingCartItemWithPrice("3 Items", 1050.00);
		if(statusAfterUpdatingBasket==true)
		{
			logger.info("*********************Status after updating basket is successful************************");
			Assert.assertTrue(true);
		}
		else
		{
			logger.warn("*********************Status after updating basket is not successful***********************");
			captureScreens(driver,"verifyingMenuItemWithPriceAfterUpdatingBasket");
			Assert.assertTrue(false);
		}
	}
	
	@Test(dependsOnMethods="verifyingMenuItemWithPriceAfterUpdatingBasket")
	public void verifyingChangesInViewBasketTest() throws InterruptedException, IOException
	{   
		boolean changesStatus=cpObj.verifyingChangesInTheUpdateBasket("Mastering JavaScript", 1050.00);
		Thread.sleep(3000);
		if(changesStatus==true)
		{
			logger.info("********************Changes status is successful**************************");
			Assert.assertTrue(true);
		}
		else
		{
			logger.warn("********************changes status is not successful***********************");
			captureScreens(driver, "verifyingChangesInViewBasketTest");
			Assert.assertTrue(false);
		}
		Thread.sleep(2000);
		
	   logger.info("***********************Ending of UpdateBasketCheckingAfterAddingMoreBooks_012***************************");
	}
}
