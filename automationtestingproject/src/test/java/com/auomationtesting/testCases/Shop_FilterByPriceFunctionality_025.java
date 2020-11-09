package com.auomationtesting.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.pageObjects.ShopPage;
import com.automationtesting.testBase.BaseClass;

public class Shop_FilterByPriceFunctionality_025 extends BaseClass{
	
	public HomePage hp;
	public ShopPage spObj;
	
	@Test
	public void verifyingFilterBooksWithTitle() throws InterruptedException
	{
		driver.get(propObj.getProperty("baseURL"));
		hp=new HomePage(driver);
		hp.clickOnShopBtn();
		Thread.sleep(3000);
		spObj =new ShopPage(driver);
		spObj.getTheLengthOfXAxis();
		spObj.adjustingFilterByPrice();
		Thread.sleep(3000);
		boolean bookStatus=spObj.verifyingBooksWithTitle("Android Quick Start Guide", "Functional Programming in JS","Mastering HTML5 Forms","HTML5 Web Application Development Beginner's guide",
				"Thinking in HTML","Mastering JavaScript","Learning JavaScript Data Structures and Algorith");
		Thread.sleep(10000);
		
		if(bookStatus==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
	}
	
   @Test(dependsOnMethods="verifyingFilterBooksWithTitle")
   public void verifyingFilterBooksByPriceFunctionality() throws InterruptedException
   {
	   boolean priceStatus1=spObj.verifyingBookPriceBetween150To450(150.00, 450.00);
	   spObj.storingBookPriceInArrayList();
	   Thread.sleep(6000);
	   boolean priceStatus2=spObj.verifyingBookPriceMethod2Between150To450(150.00, 450.00);
	   if((priceStatus1==true)&&(priceStatus2==true))
	   {
		   Assert.assertTrue(true);
	   }
	   else
	   {
		   Assert.assertTrue(false);
	   }
	   
	   Thread.sleep(10000);
   }
}
