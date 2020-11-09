package com.auomationtesting.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.ArrivalsImageAddPage;
import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.testBase.BaseClass;

public class ArrivalsImagesReviews_005 extends BaseClass {
	 
	 public HomePage hp;
	 public ArrivalsImageAddPage aipObj;
	 
	 
	 @Test(groups="Regression test")
	 public void verifyingReviewMsgTest() throws InterruptedException, IOException
	 {
		 driver.get(propObj.getProperty("baseURL"));
		 hp=new HomePage(driver);
		 logger.info("*************************Starting of ArrivalsImagesReviews_005***********************" );
		 hp.clickOnShopBtn();
		 Thread.sleep(3000);
		 hp.clickOnHomeBtn();
		 Thread.sleep(3000);
		 hp.clickOnArrivalsImg();
		 Thread.sleep(3000);
		 
		 aipObj=new ArrivalsImageAddPage(driver);
		 aipObj.clickOnReviewBtn();
		 boolean reviewstatus= aipObj.verifyingReviewMsg("There are no reviews yet.");
		 if(reviewstatus==true)
		 {   
			 logger.info("*********************Review Status verification is successful**********************");
			 Assert.assertTrue(true);
		 }
		 else
		 {  
			 logger.warn("*********************Review status verification is not successful*********************");
			 captureScreens(driver,"verifyingReviewMsgTest");
			 Assert.assertTrue(false);
		 }
		 Thread.sleep(3000);
		 logger.info("*************************Ending of ArrivalsImagesReviews_005************************" );
	 }
	

}
