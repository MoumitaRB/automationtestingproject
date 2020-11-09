package com.auomationtesting.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.pageObjects.MyAccountLoginPage;
import com.automationtesting.testBase.BaseClass;

public class LoginHandlesCaseSensitiveCase_023 extends BaseClass{
	
	public HomePage hp;
	public MyAccountLoginPage malpObj;
	
	@Test
	public void verifyingProperErrorMsgAfterLoginWithCaseChangedUserNameAndPassword() throws InterruptedException
	{
		driver.get(propObj.getProperty("baseURL"));
		hp=new HomePage(driver);
		hp.clickOnMyAccountLink();
		Thread.sleep(3000);
		malpObj=new MyAccountLoginPage(driver);
		malpObj.setUserName("MOUMITAbasak@gmail.com");
		malpObj.setPassWord("MOUMITABASAK");
		malpObj.clickOnLoginBtn();
		Thread.sleep(3000);
		boolean errorMSgStatus=malpObj.verifyingProperErrorMsgLoginWithCaseChangedUserNameAndPassword("ERROR: The password you "
				+ "entered for the username MOUMITAbasak@gmail.com is incorrect. Lost your password?");
		if(errorMSgStatus==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		Thread.sleep(3000);
	}

}
