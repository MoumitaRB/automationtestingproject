package com.auomationtesting.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.pageObjects.ShopPage;
import com.automationtesting.testBase.BaseClass;

public class Shop_SortByPopularityFunctionality_027 extends BaseClass {
	
	public HomePage hp;
	public ShopPage spObj;
	
	@Test
	public void verifyingPopularProductsAfterSortByPopularity() throws InterruptedException
	{
		driver.get(propObj.getProperty("baseURL"));
		hp=new HomePage(driver);
		hp.clickOnShopBtn();
		Thread.sleep(3000);
		spObj=new ShopPage(driver);
		spObj.clickOnDefaultDropDown("Sort by popularity");
		Thread.sleep(4000);
		boolean urlStatus=spObj.verifyingURL("http://practice.automationtesting.in/shop/?orderby=popularity");
		boolean itemStatus=spObj.verifyingPopularItemsInHomePage("Selenium Ruby", "Thinking in HTML", "Mastering JavaScript", "Android Quick Start Guide", "Functional Programming in JS", "Learning JavaScript Data Structures and Algorith", 
				"Mastering HTML5 Forms", "HTML5 Web Application Development Beginner's guide");
		if((itemStatus==true)&&(urlStatus==true))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}

}
