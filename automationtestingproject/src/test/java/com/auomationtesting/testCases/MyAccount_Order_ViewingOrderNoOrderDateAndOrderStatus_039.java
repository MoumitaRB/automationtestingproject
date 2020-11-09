package com.auomationtesting.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.pageObjects.MyAccountDashboardPage;
import com.automationtesting.pageObjects.MyAccountLoginPage;
import com.automationtesting.testBase.BaseClass;

public class MyAccount_Order_ViewingOrderNoOrderDateAndOrderStatus_039 extends BaseClass{
	
	public HomePage hpObj;
	public MyAccountLoginPage malpObj;
	public MyAccountDashboardPage madbObj;
	
	@Test
	public void verifyingOrderNoOrderDateAndOrderStatus() throws InterruptedException
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
		madbObj.clickOnOrderLink();
		Thread.sleep(3000);
		madbObj.clickOnViewLink();
		Thread.sleep(2000);
		boolean orderStatus=madbObj.verifyingOrderNoOrderDateAndOrderStatus("1888", "May 15, 2020", "On Hold");
		Assert.assertEquals(orderStatus, true);
		Thread.sleep(4000);
	}

}
