package com.auomationtesting.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.pageObjects.MyAccountLoginPage;
import com.automationtesting.testBase.BaseClass;

public class LoginWithInvalidUserNameAndPassword_018 extends BaseClass {
	
	public HomePage hp;
	public MyAccountLoginPage malpObj;
	
	@Test
	public void verifyingProperErrorMsgAfterEnteringInvalidEmailidAndPassword() throws InterruptedException, IOException
	{
	  driver.get(propObj.getProperty("baseURL"));
	  logger.info("**********************Starting of LoginWithInvalidUserNameAndPassword_018****************************");
	  hp=new HomePage(driver);
	  hp.clickOnMyAccountLink();
	  Thread.sleep(3000);
	  malpObj=new MyAccountLoginPage(driver);
	  malpObj.setUserName("moumita345@gmail.com");
	  malpObj.setPassWord("admin");
	  malpObj.clickOnLoginBtn();
	  Thread.sleep(3000);
	  boolean errorMsgStatus=malpObj.verifyingProperErrorMsg("Error: A user could not be found with this email address.");
	  Thread.sleep(3000);
	  boolean promptErrorStatus=malpObj.verifyingPromptToEnterLoginAgain("Error: Password is required.");
	  Thread.sleep(2000);
	  if((errorMsgStatus==true)&&(promptErrorStatus==true))
	  {
		  logger.info("*******************Error Msg Status & Prompt Error Status verification are successful*********************");
		  Assert.assertTrue(true);
	  }
	  else
	  {
		  logger.warn("*******************Error Msg Status & Prompt Error Status verification are not successful********************");
		  captureScreens(driver,"verifyingProperErrorMsgAfterEnteringInvalidEmailidAndPassword");
		  Assert.assertTrue(false);
	  }
    
	  Thread.sleep(2000);
	  logger.info("************************Ending of LoginWithInvalidUserNameAndPassword_018*************************");
  }	
	

}

