package com.auomationtesting.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.ArrivalsImageAddPage;
import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.testBase.BaseClass;

public class AddToBasketWithMoreBooks_007 extends BaseClass {
	
	public HomePage hp;
	public ArrivalsImageAddPage aipObj;
	
	@Test
	public void verifyingMenuItemWithPriceTest() throws InterruptedException, IOException
	{
		driver.get(propObj.getProperty("baseURL"));
		hp=new HomePage(driver);
		logger.info("*************************Starting of AddToBasketWithMoreBooks_007**********************");
		hp.clickOnShopBtn();
		Thread.sleep(3000);
		hp.clickOnHomeBtn();
		Thread.sleep(3000);
		hp.clickOnArrivalsImg();
		Thread.sleep(3000);
		
		aipObj = new ArrivalsImageAddPage(driver);
		aipObj.clickOnAddToBasket();
		Thread.sleep(2000);
		boolean status=aipObj.verifyingMenuItemWithPrice("1 Item",500.00);
		
		//boolean status=aipObj.addingMoreBooksThanStocks("Value must be less than or equals to 856");
		Thread.sleep(3000);
		if(status==true)
		{
			logger.info("************************Status verification is successful*********************");
			Assert.assertTrue(true);
		}
		else
		{   
			logger.warn("************************Status verification is not successful*******************");
			captureScreens(driver, "verifyingMenuItemWithPriceTest");
			Assert.assertTrue(false);
		}
		
		Thread.sleep(3000);
		logger.info("***********************Ending of AddToBasketWithMoreBooks_007************************");
	}

}
