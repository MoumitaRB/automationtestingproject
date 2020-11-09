package com.auomationtesting.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.pageObjects.MyAccountDashboardPage;
import com.automationtesting.pageObjects.MyAccountLoginPage;
import com.automationtesting.testBase.BaseClass;

public class MyAccount_Dashboard_036 extends BaseClass {
	
	public HomePage hpObj;
	public MyAccountLoginPage malpObj;
	public MyAccountDashboardPage madbObj;
	
	@Test
	public void verifyingUserMustViewDashBoardOfSite() throws InterruptedException
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
		madbObj= new MyAccountDashboardPage(driver);
		boolean successfullyLoginStatus=madbObj.verifyingSuccessfullyLoginMsgFromWebPage("moumitabasak");
		boolean viewingdashboardStatus=madbObj.verifyingViewingDashboardOfTheSite("From your account dashboard you can view your");
	    if((successfullyLoginStatus==true)&&(viewingdashboardStatus==true))
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	}

}
