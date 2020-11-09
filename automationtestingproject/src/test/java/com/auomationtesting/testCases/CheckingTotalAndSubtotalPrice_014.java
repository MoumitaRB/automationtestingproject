package com.auomationtesting.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.ArrivalsImageAddPage;
import com.automationtesting.pageObjects.CheckOutPage;
import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.testBase.BaseClass;

public class CheckingTotalAndSubtotalPrice_014 extends BaseClass{
	public HomePage hp;
	public ArrivalsImageAddPage aipObj;
	public CheckOutPage cpObj;
	
	@Test
	public void verifyingTotalAndSubtotalPrice() throws InterruptedException, IOException
	{
		driver.get(propObj.getProperty("baseURL"));
		hp=new HomePage(driver);
		logger.info("***********************Starting of CheckingTotalAndSubtotalPrice_014*************************");
		hp.clickOnShopBtn();
		Thread.sleep(3000);
		hp.clickOnHomeBtn();
		Thread.sleep(3000);
		hp=new HomePage(driver);
		hp.clickOnMasteringInJavaImg();
		Thread.sleep(2000);
		
		aipObj=new ArrivalsImageAddPage(driver);
		aipObj.clickOnAddToBasket();
		Thread.sleep(3000);
		aipObj.clickOnMenuItem();
		Thread.sleep(3000);
		
		cpObj=new CheckOutPage(driver);
		boolean subtotalStatus=cpObj.getSubTotalPrice(350.00);
		boolean totalStatus=cpObj.getTotalPrice(367.50);
		Thread.sleep(3000);
		
		if((subtotalStatus==true)&&(totalStatus==true))
		{
			logger.info("************************Subtotal Status and total status verification are successful******************");
			Assert.assertTrue(true);
		}
		else
		{
			logger.warn("***********************Subtotal Status and total status verification are not successful****************");
			captureScreens(driver, "verifyingTotalAndSubtotalPrice");
			Thread.sleep(2000);
			Assert.assertTrue(false);
		}
		
	}
   
	@Test
	public void verifyingTotalPriceIsAlwaysGreaterThanSubTotalPrice() throws IOException, InterruptedException
	{
		boolean compairingstatus=cpObj.verifyingTotalIsGreaterThanSubtotal(350.0, 367.5);
		if(compairingstatus==true)
		{   
			logger.info("********************Compairing Status verification is successful********************" );
			Assert.assertTrue(true);
		}
		else
		{
			logger.warn("********************Compairing Status verification is not successful********************" );
			captureScreens(driver,"verifyingTotalPriceIsAlwaysGreaterThanSubTotalPrice");
			Thread.sleep(2000);
			Assert.assertTrue(false);
		}
		
		logger.info("**********************Ending of CheckingTotalAndSubtotalPrice_014********************");
	}
}
