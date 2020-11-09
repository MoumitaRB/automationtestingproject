package com.auomationtesting.testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.pageObjects.ShopPage;
import com.automationtesting.testBase.BaseClass;

public class Shop_SortByLowToHighItemFunctionality_030 extends BaseClass{
	
	public HomePage hp;
	public ShopPage spObj;
	
	@Test
	public void verifyingPopularProductAfterSortByLowToHigh() throws InterruptedException
	{
		driver.get(propObj.getProperty("baseURL"));
		hp=new HomePage(driver);
		hp.clickOnShopBtn();
		Thread.sleep(3000);
		spObj=new ShopPage(driver);
		spObj.clickOnDefaultDropDown("Sort by price: low to high");
		Thread.sleep(4000);
		boolean popularStatus=spObj.verifyingPopularItemsInHomePage("Learning JavaScript Data Structures and Algorith", "HTML5 Web Application Development Beginner's guide", "Functional Programming in JS", "Mastering HTML5 Forms",
				"Android Quick Start Guide", "Mastering JavaScript", "Thinking in HTML", "Selenium Ruby");
		spObj.gettingItemPriceAfterSelectingOptionFromDropDown();
		boolean assendingPriceStatus=spObj.removingOldPriceOfTheSaleProductForLowToHighSorting();
		Thread.sleep(10000);
		if((popularStatus==true)&&(assendingPriceStatus==true))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
	 }

}
