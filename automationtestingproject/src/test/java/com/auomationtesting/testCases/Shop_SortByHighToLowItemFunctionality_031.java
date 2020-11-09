package com.auomationtesting.testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.pageObjects.ShopPage;
import com.automationtesting.testBase.BaseClass;

public class Shop_SortByHighToLowItemFunctionality_031 extends BaseClass{

	public HomePage hp;
	public ShopPage spObj;
	
	@Test
	public void verifyingPopularProductAfterSortingHighToLow() throws InterruptedException
	{
		driver.get(propObj.getProperty("baseURL"));
		hp=new HomePage(driver);
		hp.clickOnShopBtn();
		Thread.sleep(3000);
		spObj= new ShopPage(driver);
		spObj.clickOnDefaultDropDown("Sort by price: high to low");
		Thread.sleep(4000);
		boolean popularStatus=spObj.verifyingPopularItemsInHomePage("Selenium Ruby", "Android Quick Start Guide", "Thinking in HTML", "Mastering JavaScript", "Mastering HTML5 Forms", "HTML5 Web Application Development Beginner's guide", 
				"Functional Programming in JS", "Learning JavaScript Data Structures and Algorith");
	    spObj.gettingItemPriceAfterSelectingOptionFromDropDown();
	    boolean decendingPriceStatus=spObj.removingOldPriceOfTheSaleProductForHighToLowSorting();
		Thread.sleep(20000);
		if((popularStatus==true)&&(decendingPriceStatus==true))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
}
