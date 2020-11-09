package com.auomationtesting.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.pageObjects.MyAccountLoginPage;
import com.automationtesting.testBase.BaseClass;

public class LoginWithValidUserNameAndEmptyPassword_019 extends BaseClass {
	
	public HomePage hp;
	public MyAccountLoginPage malpObj;
	
	@Test
	public void verifyingProperErrorMsgAfterEnteringValidUserNameAndEmptyPassword() throws InterruptedException, IOException
	{
		driver.get(propObj.getProperty("baseURL"));
		logger.info("***********************Starting ofLoginWithValidUserNameAndEmptyPassword_019**********************" );
		hp=new HomePage(driver);
		hp.clickOnMyAccountLink();
		Thread.sleep(3000);
		malpObj=new MyAccountLoginPage(driver);
		malpObj.setUserName("moumitabasak@gmail.com");
		malpObj.setPassWord("");
		malpObj.clickOnLoginBtn();
		boolean msgStatus=malpObj.verifyingProperErrorMsgLoginWithOutPassword("Error: Password is required.");
		Thread.sleep(2000);
		malpObj.promptToLoginAgain();
		Thread.sleep(3000);
		if(msgStatus==true)
		{   
			logger.info("********************Msg Status verification is successful**************************");
			Assert.assertTrue(true);
		}
		else
		{   
			logger.warn("*******************Msg Status verification is not successful***********************");
			captureScreens(driver,"verifyingProperErrorMsgAfterEnteringValidUserNameAndEmptyPassword");
			Thread.sleep(3000);
			Assert.assertTrue(false);
		}
		
		logger.info("********************Ending of LoginWithValidUserNameAndEmptyPassword_019********************");
	}

}
