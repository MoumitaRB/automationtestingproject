package com.auomationtesting.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationtesting.pageObjects.HomePage;
import com.automationtesting.pageObjects.MyAccountDashboardPage;
import com.automationtesting.pageObjects.MyAccountLoginPage;
import com.automationtesting.testBase.BaseClass;

public class MyAccount_AddressFunctionality_EditShippingAddress_041 extends BaseClass{
	
	public HomePage hpObj;
	public MyAccountLoginPage malpObj;
	public MyAccountDashboardPage madbObj;
	
	
	@Test
	public void verifyingShippingEditFunctionality() throws InterruptedException
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
		madbObj.clickOnAddressLink();
		Thread.sleep(3000);
		madbObj.clickOnEditBtnForShippingAddress();
		Thread.sleep(3000);
		madbObj.editingShippingAddress("Amir", "Khan", "5678 AppleValley", "Apt 256", "Shorview", "55190");
		Thread.sleep(3000);
		madbObj.clickOnSaveBtn();
		Thread.sleep(3000);
		boolean changedStatus=madbObj.verifyingCrfMsgAfterEditingShippingAddress("Address changed successfully.");
		Assert.assertEquals(changedStatus, true);
		Thread.sleep(3000);
	}

}
