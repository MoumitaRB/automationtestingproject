package com.auomationtesting.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.CheckOutPage;
import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.pageObjects.PaymentGatewayPage;
import com.automationtesting.pageObjects.ShopPage;
import com.automationtesting.testBase.BaseClass;

public class Shop_ViewBasketTaxFunctionality_035 extends BaseClass {
	
	public HomePage hp;
	public ShopPage spObj;
	public CheckOutPage cpObj;
	public PaymentGatewayPage pgObj;
	
	@Test
	public void verifyingRoamingTaxRateInIndia() throws InterruptedException
	{
		driver.get(propObj.getProperty("baseURL"));
		hp=new HomePage(driver);
		hp.clickOnShopBtn();
		Thread.sleep(3000);
		spObj=new ShopPage(driver);
		spObj.clickOnAddToBasket();
		Thread.sleep(2000);
		spObj.clickOnViewBasketBtn();
		Thread.sleep(4000);
		cpObj=new CheckOutPage(driver);
		cpObj.clickOnProceedToCheckOutBtn();
		Thread.sleep(3000);
		pgObj=new PaymentGatewayPage(driver);
		pgObj.fillingUpBillingDetails("Amir", "Khan", "amir123@gmail.com", "9745656768", "India", "India", "Adarsh Palm Retreat", 
				"Sarjapur Road", "Bangalore","Karnataka","Karnataka", "560103");
		Thread.sleep(5000);
		boolean indiaTaxStatus=pgObj.verifyingTaxRateInIndia(280.00);
		System.out.println(indiaTaxStatus);
		if(indiaTaxStatus==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		

	}

	
	@Test(dependsOnMethods="verifyingRoamingTaxRateInIndia")
	public void verifyingRoamingTaxRateInAbroad() throws InterruptedException
	  {   
		pgObj=new PaymentGatewayPage(driver);
		pgObj.clickOnOtherCountry("United States", "United States (US)");
		Thread.sleep(5000);
		boolean abroadTaxStatus=pgObj.verifyingTaxRateInAbroad(280.00);
		if(abroadTaxStatus==true)
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
	
 
	


