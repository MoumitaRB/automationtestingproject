package com.auomationtesting.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.ArrivalsImageAddPage;
import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.pageObjects.ShopPage;
import com.automationtesting.testBase.BaseClass;

public class Shop_SaleFunctionality_033 extends BaseClass {
	
	public HomePage hp;
	public ShopPage spObj;
	public ArrivalsImageAddPage aipObj;
	
	@Test
	public void verifyingActualPriceOfBookWithOldPrice() throws InterruptedException
	{
		driver.get(propObj.getProperty("baseURL"));
		hp=new HomePage(driver);
		hp.clickOnShopBtn();
		Thread.sleep(3000);
		spObj=new ShopPage(driver);
		spObj.clickOnSaleBook("Android Quick Start Guide", "SALE!");
		Thread.sleep(3000);
		
		aipObj=new ArrivalsImageAddPage(driver);
		boolean priceStatus=aipObj.verifyingActualBookPriceWithOldPrice(600.00, 450.00);
		boolean strikenStatus=aipObj.verifyingOldPriceStikenOut("450.00");
		if((priceStatus==true)&&(strikenStatus==true))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		Thread.sleep(5000);
	}

}
