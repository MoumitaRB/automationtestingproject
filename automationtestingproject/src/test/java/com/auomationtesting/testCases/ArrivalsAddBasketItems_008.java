package com.auomationtesting.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.ArrivalsImageAddPage;
import com.automationtesting.pageObjects.CheckOutPage;
import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.testBase.BaseClass;

public class ArrivalsAddBasketItems_008 extends BaseClass{
	
	public HomePage hp;
	public ArrivalsImageAddPage aipObj;
	public CheckOutPage cpObj;

	
	
	@Test
	public void verifyingArrivalsItemNavigatingToCheckOutPage() throws InterruptedException, IOException
	{
		driver.get(propObj.getProperty("baseURL"));
		hp=new HomePage(driver);
		logger.info("*************************Starting of ArrivalsAddBasketItems_008***********************" );
		hp.clickOnShopBtn();
		Thread.sleep(3000);
		hp.clickOnHomeBtn();
		Thread.sleep(3000);
		hp.clickOnArrivalsImg();
		Thread.sleep(3000);
		
		aipObj = new ArrivalsImageAddPage(driver);
		aipObj.clickOnAddToBasket();
		aipObj.clickOnMenuItem();
		Thread.sleep(3000);
		
		cpObj=new CheckOutPage(driver);
		boolean status=cpObj.isProceedToCheckOutButtonClickable();
		if(status==true)
		{   
			logger.info("******************************Status verification is successful*********************");
			Assert.assertTrue(true);
		}
		else
		{   
			logger.warn("*************************Status verification is not successful******************");
			captureScreens(driver,"verifyingArrivalsItemNavigatingToCheckOutPage");
			Thread.sleep(2000);
			Assert.assertTrue(false);
		}
		
	}
	
	@Test(dependsOnMethods="verifyingArrivalsItemNavigatingToCheckOutPage")
	public void verifyingArrivalsItemNavigatingToBillingPage() throws InterruptedException, IOException
	{
		

		cpObj.clickOnProceedToCheckOutBtn();
		Thread.sleep(3000);
		boolean cpStatus=cpObj.verifyingConfirmTextFrombillingPage("Your order", "Selenium Ruby");
		if(cpStatus==true)
		{
			logger.info("****************************cpStatus verification is successful*************************" );
			Assert.assertTrue(true);
		}
		else
		{   
			logger.warn("***************************cpStatus verification is not successful***********************");
			captureScreens(driver,"verifyingArrivalsItemNavigatingToBillingPage");
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
		
		logger.info("************************Ending of ArrivalsAddBasketItems_008**********************");
	}

	
}
