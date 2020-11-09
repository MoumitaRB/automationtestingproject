package com.auomationtesting.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.ArrivalsImageAddPage;
import com.automationtesting.pageObjects.CheckOutPage;
import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.pageObjects.PaymentGatewayPage;
import com.automationtesting.testBase.BaseClass;

public class ItemCheckOutFunctionality_015 extends BaseClass{
	
	public HomePage hp;
	public ArrivalsImageAddPage aipObj;
	public CheckOutPage cpObj;
	public PaymentGatewayPage pgObj;
	
	
	@Test
	public void verifyingItemNavigatingToPaymentGatewayPage() throws InterruptedException, IOException
	{
		driver.get(propObj.getProperty("baseURL"));
		hp=new HomePage(driver);
		logger.info("**************************Starting of ItemCheckOutFunctionality_015***********************");
		hp.clickOnShopBtn();
		Thread.sleep(3000);
		hp.clickOnHomeBtn();
		Thread.sleep(3000);
		hp=new HomePage(driver);
		hp.clickOnMasteringInJavaImg();
		Thread.sleep(2000);
		
		aipObj=new ArrivalsImageAddPage(driver);
		aipObj.clickOnAddToBasket();
		Thread.sleep(2000);
		aipObj.clickOnMenuItem();
		Thread.sleep(3000);
		
		cpObj=new CheckOutPage(driver);
		cpObj.clickOnProceedToCheckOutBtn();
		
		pgObj=new PaymentGatewayPage(driver);
		boolean enableStatus=pgObj.isPlaceOrderBtnClickable();
		boolean displayStatus=pgObj.isPlaceOrderBtnDisplaced();
		boolean titleStatus=pgObj.verifyingPaymentGatewayPageTitle("Checkout – Automation Practice Site");
		if((enableStatus==true)&&(displayStatus==true)&&(titleStatus==true))
		{
			logger.info("********************Enable status, Display status & Title status are successful**********************" );
			Assert.assertTrue(true);
		}
		else
		{   
			logger.warn("********************Enable status, Display status & Title status are not successful**********************");
			captureScreens(driver, "verifyingItemNavigatingToPaymentGatewayPage");
			Thread.sleep(3000);
			Assert.assertTrue(false);
		}
		
		logger.info("********************Ending of ItemCheckOutFunctionality_015**************************");
	}

}
