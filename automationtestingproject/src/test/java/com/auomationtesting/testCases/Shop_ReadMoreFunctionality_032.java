package com.auomationtesting.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.ArrivalsImageAddPage;
import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.pageObjects.ShopPage;
import com.automationtesting.testBase.BaseClass;

public class Shop_ReadMoreFunctionality_032 extends BaseClass{
	
	public HomePage hp;
	public ShopPage spObj;
	public ArrivalsImageAddPage aipObj;
	
	
	@Test
	public void verifyingProductOutOfStock() throws InterruptedException
	{
		driver.get(propObj.getProperty("baseURL"));
		hp=new HomePage(driver);
		hp.clickOnShopBtn();
		Thread.sleep(3000);
		spObj=new ShopPage(driver);
		spObj.clickOnReadMoreBtn();
		Thread.sleep(3000);
		
		aipObj=new ArrivalsImageAddPage(driver);
		boolean bookStatus=aipObj.verifyingBookOutOfStock("Android Quick Start Guide", "Out of stock");
		if(bookStatus==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}

}
