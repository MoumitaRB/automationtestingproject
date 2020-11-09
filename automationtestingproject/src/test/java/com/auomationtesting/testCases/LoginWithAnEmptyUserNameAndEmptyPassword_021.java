package com.auomationtesting.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.pageObjects.MyAccountLoginPage;
import com.automationtesting.testBase.BaseClass;

public class LoginWithAnEmptyUserNameAndEmptyPassword_021 extends BaseClass{
	
	public HomePage hp;
	public MyAccountLoginPage malpObj;
	
	
	@Test
	public void verifyingProperErrorMsgAfterEnteringEmptyUserNameAndPassword() throws InterruptedException, IOException
	{
		driver.get(propObj.getProperty("baseURL"));
		logger.info("********************Starting of LoginWithAnEmptyUserNameAndEmptyPassword_021************************");
		hp=new HomePage(driver);
		hp.clickOnMyAccountLink();
		Thread.sleep(3000);
		malpObj=new MyAccountLoginPage(driver);
		malpObj.setUserName("");
		malpObj.setPassWord("");
		malpObj.clickOnLoginBtn();
		Thread.sleep(2000);
		boolean errorMsgStatus=malpObj.verifyingProperErrorMsgLoginWithValidPasswordAndEmptyUserName("Error: Username is required.");
		Thread.sleep(2000);
		malpObj.promptToLoginAgain();
		Thread.sleep(2000);
		if(errorMsgStatus==true)
		{
			logger.info("********************Error Msg Status verification is successful***********************");
			Assert.assertTrue(true);
		}
		else
		{   
			logger.warn("********************Error Msg Status verification is not successful******************");
			captureScreens(driver, "verifyingProperErrorMsgAfterEnteringEmptyUserNameAndPassword");
			Thread.sleep(2000);
			Assert.assertTrue(false);
		}
		
		logger.info("*******************Ending of LoginWithAnEmptyUserNameAndEmptyPassword_021***********************");
	
	}

}
