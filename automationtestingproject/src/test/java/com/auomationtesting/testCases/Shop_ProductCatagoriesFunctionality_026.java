package com.auomationtesting.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.pageObjects.ShopPage;
import com.automationtesting.testBase.BaseClass;

public class Shop_ProductCatagoriesFunctionality_026 extends BaseClass {
	
	public HomePage hp;
	public ShopPage spObj;
	
	@Test
	public void verifyingProductRelatedCatagories() throws InterruptedException
	{
		driver.get(propObj.getProperty("baseURL"));
		hp=new HomePage(driver);
		hp.clickOnShopBtn();
		Thread.sleep(3000);
		spObj=new ShopPage(driver);
	    spObj.clickOnProductLink();
	    Thread.sleep(3000);
	    boolean catagoryStatus=spObj.verifyingJavaScriptRelatedProduct("Functional Programming in JS", "Learning JavaScript Data Structures and Algorith",
	    		"Mastering JavaScript");
	    if(catagoryStatus==true)
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	}


	
}
