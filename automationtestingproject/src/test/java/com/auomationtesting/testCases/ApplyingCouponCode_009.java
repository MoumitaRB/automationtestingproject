package com.auomationtesting.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.ArrivalsImageAddPage;
import com.automationtesting.pageObjects.CheckOutPage;
import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.testBase.BaseClass;

public class ApplyingCouponCode_009 extends BaseClass{
	public HomePage hp;
	public ArrivalsImageAddPage aipObj;
	public CheckOutPage cpObj;

	
	
	@Test
	public void verifyingApplyingCouponCfmMsgTest() throws InterruptedException, IOException
	{
		driver.get(propObj.getProperty("baseURL"));
		hp=new HomePage(driver);
		logger.info("********************************Starting of ApplyingCouponCode_009***************************");
		hp.clickOnShopBtn();
		Thread.sleep(3000);
		hp.clickOnHomeBtn();
		Thread.sleep(3000);
		hp.clickOnArrivalsImg();
		Thread.sleep(3000);
		
		aipObj = new ArrivalsImageAddPage(driver);
		aipObj.clickOnAddToBasket();
		Thread.sleep(2000);
		
		
		aipObj.clickOnMenuItem();
		
		cpObj= new CheckOutPage(driver);
		cpObj.setCouponCode("krishnasakinala");
		Thread.sleep(2000);
		cpObj.clickOnCouponBtn();
		boolean couponAddedStatus=cpObj.verifyingCouponAddedCrfMsg("Coupon code applied successfully.");
		Thread.sleep(2000);
		if(couponAddedStatus==true)
		{
			logger.info("**************************Coupon Added Status verification is successful***************************");
			Assert.assertTrue(true);
		}
		else
		{   
			logger.info("**********************Coupon added status verification is not successful***********************");
			captureScreens(driver, "verifyingApplyingCouponCfmMsgTest");
			Assert.assertTrue(false);
		}
		
	}	
		
		@Test
		public void verifyingCouponApplingCodeTest() throws InterruptedException, IOException
		{
			
		  cpObj.clickOnProceedToCheckOutBtn();
		  Thread.sleep(3000);
		  boolean status=cpObj.verifyingApplyingCouponCode("Coupon: krishnasakinala", "50.00");
		  Thread.sleep(3000);
		  if(status==true)
		  {
			  logger.info("***************************Status verification is successful*************************");
			  Assert.assertTrue(true);
		  }
		  else
		  {
			 logger.warn("**************************Status verification is not successful************************");
			 captureScreens(driver, "verifyingCouponApplingCodeTest");
			 Thread.sleep(3000);
			 Assert.assertTrue(false);
		  }
		 
		  logger.info("***********************Ending of ApplyingCouponCode_009**************************");
	   }
	}


