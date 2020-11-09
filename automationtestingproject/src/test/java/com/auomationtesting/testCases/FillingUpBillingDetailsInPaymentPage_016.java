package com.auomationtesting.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.ArrivalsImageAddPage;
import com.automationtesting.pageObjects.CheckOutPage;
import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.pageObjects.OrderConfirmationPage;
import com.automationtesting.pageObjects.PaymentGatewayPage;
import com.automationtesting.testBase.BaseClass;

public class FillingUpBillingDetailsInPaymentPage_016 extends BaseClass {
	
	public HomePage hp;
	public ArrivalsImageAddPage aipObj;
	public CheckOutPage cpObj;
	public PaymentGatewayPage pgObj;
	public OrderConfirmationPage ocObj;
	
	@Test
	public void verifyingAllBillingAndPaymentDetailsAreDisplayed() throws InterruptedException, IOException
	{
		driver.get(propObj.getProperty("baseURL"));
		hp=new HomePage(driver);
		logger.info("**********************Starting of FillingUpBillingDetailsInPaymentPage_016***********************");
		hp.clickOnShopBtn();
		Thread.sleep(3000);
		hp.clickOnHomeBtn();
		Thread.sleep(3000);
		hp=new HomePage(driver);
		hp.clickOnMasteringInJavaImg();
		Thread.sleep(2000);
		
		aipObj=new ArrivalsImageAddPage(driver);
		aipObj.clickOnAddToBasket();
		Thread.sleep(3000);
		aipObj.clickOnMenuItem();
		Thread.sleep(3000);
		
		cpObj=new CheckOutPage(driver);
		cpObj.clickOnProceedToCheckOutBtn();
		
		pgObj=new PaymentGatewayPage(driver);
		boolean billingStatus=pgObj.isBillingDetailsdisplayed();
		boolean additionalStatus=pgObj.isAdditionalDetailsDisplayed();
		boolean orderStatus=pgObj.isOrderDetailsDisplayed();
		boolean paymentStatus=pgObj.isPaymentDetailsDisplayed();
		Thread.sleep(4000);
		if((billingStatus==true)&&(additionalStatus==true)&&(orderStatus==true)&&(paymentStatus==true))
		{   
			logger.info("***************************Billing Status, Additional Status & Payment Status verification are successful***********************");
			Assert.assertTrue(true);
		}
		else
		{   
			logger.warn("*************************Billing Status, Additional Status & Payment Status verification are not successful*************************");
			captureScreens(driver,"verifyingAllBillingAndPaymentDetailsAreDisplayed");
			Thread.sleep(1000);
			Assert.assertTrue(false);
		}
	}

	
	@Test
	public void verifyingFeasibilityOfApplyingCouponInPaymentPage() throws InterruptedException, IOException
	{
		boolean status=pgObj.verifyingAddCouponInPaymentPage();
		Thread.sleep(3000);
		if(status==true)
		{   
			logger.info("*************************Status verification is successful***************************");
			Assert.assertTrue(true);
		}
		else
		{   
			logger.warn("*************************Status verification is not successful**********************");
			captureScreens(driver, "verifyingFeasibilityOfApplyingCouponInPaymentPage");
			Thread.sleep(2000);
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void verifyingFillingUpOfBillingDetailsTest() throws InterruptedException, IOException
	{
		pgObj.fillingUpBillingDetails("Amir", "Khan", "amir123@gmail.com", "9745656768", "India", "India", "Adarsh Palm Retreat", "Sarjapur Road", "Bangalore","Karnataka","Karnataka", "560103");
		Thread.sleep(10000);
		pgObj.clickOnPlaceOrderBtn();
		Thread.sleep(2000);
		ocObj=new OrderConfirmationPage(driver);
		boolean orderCrfStatus=ocObj.verifyingOrderCrfMsg("Thank you. Your order has been received.");
		boolean paymentStatus=ocObj.verifyingPaymentWay("Check Payments","Please send a cheque to Store Name, Store Street, Store Town, Store State / County, Store Postcode.");
		boolean orderDetails=ocObj.verifyingOrderDetails("Order Details", 357.00);
		Thread.sleep(3000);
		if((orderCrfStatus==true)&&(paymentStatus==true)&&(orderDetails==true))
		{   
			logger.info("**********************Order Confirmation Status, Payment Status & Order Details Status verification are successful**************************");
			Assert.assertTrue(true);
		}
		else
		{   
			logger.warn("**********************Order Confirmation Status, Payment Status & Order Details Status verification are not successful**************************");
			captureScreens(driver,"verifyingFillingUpOfBillingDetailsTest");
			Assert.assertTrue(false);
		}
		
		Thread.sleep(3000);
		logger.info("*********************Ending of FillingUpBillingDetailsInPaymentPage_016***********************");
	}
}
