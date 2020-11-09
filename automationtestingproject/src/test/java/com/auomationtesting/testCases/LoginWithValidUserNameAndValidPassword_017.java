package com.auomationtesting.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.pageObjects.MyAccountLoginPage;
import com.automationtesting.testBase.BaseClass;

public class LoginWithValidUserNameAndValidPassword_017 extends BaseClass{
	
	public HomePage hp;
	public MyAccountLoginPage malpObj;
	
	@Test
	public void verifyingValidUserNameAndPassword() throws InterruptedException, IOException
	{
		driver.get(propObj.getProperty("baseURL"));
		logger.info("*************************Starting of LoginWithValidUserNameAndValidPassword_017**************************");
		hp=new HomePage(driver);
		hp.clickOnMyAccountLink();
		Thread.sleep(3000);
		
		malpObj=new MyAccountLoginPage(driver);
		malpObj.setUserName("moumitabasak@gmail.com");
		malpObj.setPassWord("MoumitaBasak");
		malpObj.clickOnLoginBtn();
		boolean titleStatus=malpObj.verifyingSuccessfullyLoginToWebPage("My Account – Automation Practice Site");
		Thread.sleep(3000);
		if(titleStatus==true) 
		{   
			logger.info("*********************Title Status verification is successful********************");
			Assert.assertTrue(true);
		}
		else
		{   
			logger.warn("**********************Title Status verification is not successful*********************");
			captureScreens(driver,"verifyingValidUserNameAndPassword");
			Thread.sleep(2000);
			Assert.assertTrue(false);
		}
		
		 logger.info("*************************Ending of LoginWithValidUserNameAndValidPassword_017*********************");
		
	}

}
