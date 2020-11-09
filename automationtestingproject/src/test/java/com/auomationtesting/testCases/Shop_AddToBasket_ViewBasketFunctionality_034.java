package com.auomationtesting.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.CheckOutPage;
import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.pageObjects.OrderConfirmationPage;
import com.automationtesting.pageObjects.PaymentGatewayPage;
import com.automationtesting.pageObjects.ShopPage;
import com.automationtesting.testBase.BaseClass;

public class Shop_AddToBasket_ViewBasketFunctionality_034 extends BaseClass{
	
	public HomePage hp;
	public ShopPage spObj;
	public CheckOutPage cpObj;
	public PaymentGatewayPage pgObj;
	public OrderConfirmationPage ocObj;
	
	@Test
	public void verifyingViewBasketFunctionality() throws InterruptedException
	{
		driver.get(propObj.getProperty("baseURL"));
		hp=new HomePage(driver);
		hp.clickOnShopBtn();
		Thread.sleep(3000);
		spObj=new ShopPage(driver);
		spObj.clickOnAddToBasket();
		spObj.verifyingMenuItemWithPrice("1 Item", 280.00);
		Thread.sleep(2000);
		spObj.clickOnViewBasketBtn();
		Thread.sleep(4000);
		cpObj=new CheckOutPage(driver);
		boolean subtotalStatus=cpObj.getSubTotalPrice(280.00);
		boolean totalStatus=cpObj.verifyingTotalPriceInTheCheckOutGrid(294.00);
		boolean compairingStatus=cpObj.verifyingTotalIsGreaterThanSubtotal(280.00, 294.00);
		cpObj.clickOnProceedToCheckOutBtn();
		Thread.sleep(3000);
		pgObj=new PaymentGatewayPage(driver);
		boolean orderStatus=pgObj.isOrderDetailsDisplayed();
		boolean billingStatus=pgObj.isBillingDetailsdisplayed();
		boolean additionalStatus=pgObj.isAdditionalDetailsDisplayed();
		boolean paymentStatus=pgObj.isPaymentDetailsDisplayed();
		pgObj.fillingUpBillingDetails("Amir", "Khan", "amir123@gmail.com", "9745656768", "India", "India", "Adarsh Palm Retreat", "Sarjapur Road", "Bangalore","Karnataka","Karnataka", "560103");
		Thread.sleep(10000);
		pgObj.clickOnPlaceOrderBtn();
		Thread.sleep(2000);
	    ocObj=new OrderConfirmationPage(driver);
		boolean orderCrfStatus=ocObj.verifyingOrderCrfMsg("Thank you. Your order has been received.");
		boolean paymentwayStatus=ocObj.verifyingPaymentWay("Check Payments", "Please send a cheque to Store Name, Store Street, Store Town, Store State / County, Store Postcode.");
		if((subtotalStatus==true)&&(totalStatus==true)&&(compairingStatus==true)&&(orderStatus==true)&&(billingStatus==true)&&(additionalStatus==true)
				&&(paymentStatus==true)&&(orderCrfStatus==true)&&(paymentwayStatus==true))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		Thread.sleep(4000);
		
	}

}
