package com.auomationtesting.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.ArrivalsImageAddPage;
import com.automationtesting.pageObjects.CheckOutPage;
import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.testBase.BaseClass;

public class DenyingCouponCodeBelowValue_010 extends BaseClass {
	public HomePage hp;
	public ArrivalsImageAddPage aipObj;
	public CheckOutPage cpObj;


	@Test
 public void verifyingCouponCodeDeningMsg() throws InterruptedException, IOException
 {
		driver.get(propObj.getProperty("baseURL"));
		hp=new HomePage(driver);
		logger.info("**********************Starting of DenyingCouponCodeBelowValue_010**************************");
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
		
		cpObj=new CheckOutPage(driver);
		logger.info("*********************Applying coupon code***********************");
		cpObj.setCouponCode("krishnasakinala");
		Thread.sleep(2000);
		cpObj.clickOnCouponBtn();
		Thread.sleep(2000);
		boolean status=cpObj.verifyingCouponDeniedMsg("The minimum spend for this coupon is ₹450.00.");
		if(status==true)
		{
			logger.info("*********************Status verification is successful************************");
			Assert.assertTrue(true);
		}
		else
		{   
			logger.warn("**********************Status verification is not successful************************");
			captureScreens(driver,"verifyingCouponCodeDeningMsg");
			Thread.sleep(2000);
			Assert.assertTrue(false);
		}
		
		logger.info("*********************Ending of DenyingCouponCodeBelowValue_010************************" );
   }
}
