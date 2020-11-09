package com.auomationtesting.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.pageObjects.MyAccountDashboardPage;
import com.automationtesting.pageObjects.MyAccountLoginPage;
import com.automationtesting.testBase.BaseClass;

public class LoginAuthentication_024 extends BaseClass{
	
	public HomePage hp;
	public MyAccountLoginPage malpObj;
	public MyAccountDashboardPage madbObj;
	
	@Test
	public void verifyingLoginAuthentication() throws InterruptedException
	{
		driver.get(propObj.getProperty("baseURL"));
		hp=new HomePage(driver);
		hp.clickOnMyAccountLink();
		Thread.sleep(3000);
		malpObj=new MyAccountLoginPage(driver);
		malpObj.setUserName("moumitabasak@gmail.com");
		malpObj.setPassWord("MoumitaBasak");
		malpObj.clickOnLoginBtn();
		Thread.sleep(3000);
		madbObj=new MyAccountDashboardPage(driver);
		madbObj.clickOnSignOutBtn();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		boolean titleStatus=malpObj.verifyingMyAccountLoginPageTitle("My Account – Automation Practice Site");
		if(titleStatus==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
	}

}
