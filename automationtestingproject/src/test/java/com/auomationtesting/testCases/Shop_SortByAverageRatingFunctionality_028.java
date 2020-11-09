package com.auomationtesting.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.pageObjects.ShopPage;
import com.automationtesting.testBase.BaseClass;

public class Shop_SortByAverageRatingFunctionality_028 extends BaseClass {
	
	public HomePage hp;
	public ShopPage spObj;
	
	@Test
	public void verifyingPopularProductAfterSortByAverageRating() throws InterruptedException
	{
		driver.get(propObj.getProperty("baseURL"));
		hp=new HomePage(driver);
		hp.clickOnShopBtn();
		Thread.sleep(3000);
		spObj=new ShopPage(driver);
		spObj.clickOnDefaultDropDown("Sort by average rating");
		Thread.sleep(4000);
		boolean urlStatus=spObj.verifyingURL("http://practice.automationtesting.in/shop/?orderby=rating");
		boolean status=spObj.verifyingPopularItemsInHomePage("Mastering HTML5 Forms", "Selenium Ruby", "Mastering JavaScript",
				"Functional Programming in JS", "Thinking in HTML", "Android Quick Start Guide", "HTML5 Web Application Development Beginner's guide", "Learning JavaScript Data Structures and Algorith");
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
