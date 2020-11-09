package com.auomationtesting.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.pageObjects.MyAccountLoginPage;
import com.automationtesting.testBase.BaseClass;

public class LoginPasswordShouldBeMasked_022 extends BaseClass{
	public HomePage hp;
	public MyAccountLoginPage malpObj;
	
	@Test
	public void verifyingPasswordFieldDisplayingInAsterrisks() throws InterruptedException, IOException
	{
		driver.get(propObj.getProperty("baseURL"));
		logger.info("*********************Starting of LoginPasswordShouldBeMasked_022*********************");
		hp=new HomePage(driver);
		hp.clickOnMyAccountLink();
		Thread.sleep(3000);
		malpObj=new MyAccountLoginPage(driver);
		malpObj.setUserName("moumitabasak@gmail.com");
		boolean passwordStatus=malpObj.verifyingPasswordCharactersVisibleInAsterisks("MoumitaBasak", "password");
		System.out.println(passwordStatus);
		if(passwordStatus==true)
		{   
			logger.info("*******************Password displaying in Asterisks is successful**********************");
			Assert.assertTrue(true);
		}
		else
		{
			logger.warn("******************Password displaying in Asterisks is not successful**********************");
			captureScreens(driver, "verifyingPasswordFieldDisplayingInAsterrisks");
			Thread.sleep(2000);
			Assert.assertTrue(false);
		}
		
		Thread.sleep(3000);
		logger.info("********************Ending of LoginPasswordShouldBeMasked_022***********************" );
	}

	}
