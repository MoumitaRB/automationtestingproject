package com.auomationtesting.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.pageObjects.MyAccountDashboardPage;
import com.automationtesting.pageObjects.MyAccountLoginPage;
import com.automationtesting.testBase.BaseClass;

public class MyAccount_AccountDetails_042 extends BaseClass{
	
	public HomePage hpObj;
	public MyAccountLoginPage malpObj;
	public MyAccountDashboardPage madbObj;
	
	
	@Test
	public void verifyingViewingAccountDetailsAndUserCanChangeHisPwd() throws InterruptedException
	{
		driver.get(propObj.getProperty("baseURL"));
		hpObj=new HomePage(driver);
		hpObj.clickOnMyAccountLink();
		Thread.sleep(3000);
		malpObj=new MyAccountLoginPage(driver);
		malpObj.setUserName("moumitabasak@gmail.com");
		malpObj.setPassWord("MoumitaBasak");
		malpObj.clickOnLoginBtn();
		Thread.sleep(3000);
		madbObj=new MyAccountDashboardPage(driver);
		madbObj.clickOnAccountDetailsLink();
		Thread.sleep(2000);
		boolean accountDetailsStatus=madbObj.verifyingViewingAccountDetails("moumitabasak@gmail.com","Moumita","Basak");
		Thread.sleep(4000);
		madbObj.changeCurrentPassword("MoumitaBasak", "MoumitaBasak", "MoumitaBasak");
		Thread.sleep(4000);
		madbObj.clickOnSaveBtnAfterChangeThePwd();
		Thread.sleep(3000);
		boolean changingPwdStatus=madbObj.verifyingCrfMsgAfterChangingPassword("Account details changed successfully.");
		
		if((accountDetailsStatus==true)&&(changingPwdStatus==true))
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
