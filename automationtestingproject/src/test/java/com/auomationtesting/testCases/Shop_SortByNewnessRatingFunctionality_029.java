package com.auomationtesting.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.pageObjects.ShopPage;
import com.automationtesting.testBase.BaseClass;

public class Shop_SortByNewnessRatingFunctionality_029 extends BaseClass{
	
	public HomePage hp;
	public ShopPage spObj;
	
	@Test
	public void verifyingPopularProductAfterSortByNewnessRating() throws InterruptedException
	{
		driver.get(propObj.getProperty("baseURL"));
		hp=new HomePage(driver);
		hp.clickOnShopBtn();
		Thread.sleep(3000);
		spObj=new ShopPage(driver);
		spObj.clickOnDefaultDropDown("Sort by newness");
		Thread.sleep(4000);
		boolean urlStatus=spObj.verifyingURL("http://practice.automationtesting.in/shop/?orderby=date");
		boolean status=spObj.verifyingPopularItemsInHomePage("HTML5 Web Application Development Beginner's guide", "Mastering HTML5 Forms", "Learning JavaScript Data Structures and Algorith", "Functional Programming in JS", "Mastering JavaScript",
				"Android Quick Start Guide", "Thinking in HTML", "Selenium Ruby");
		if((status==true)&&(urlStatus==true))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}

}
