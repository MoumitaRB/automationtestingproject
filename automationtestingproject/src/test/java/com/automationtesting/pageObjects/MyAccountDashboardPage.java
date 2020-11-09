package com.automationtesting.pageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountDashboardPage {
	
	public WebDriver driver;
	
	public MyAccountDashboardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
  //locators
	
	@FindBy(xpath="//a[contains(text(),'Sign out')]")
	@CacheLookup
	WebElement signOutBtn;
	
	@FindBy(xpath="//a[contains(text(),'Dashboard')]")
	@CacheLookup
	WebElement dashboardLink;
	
	@FindBy(xpath="//div[@id='body']//p[1]")
	@CacheLookup
	WebElement loginMsg;
	
	
	@FindBy(xpath="//div[@id='body']//p[2]")
	@CacheLookup
	WebElement textFromDashboardPage;
	
	@FindBy(xpath="//a[contains(text(),'Orders')]")
	@CacheLookup
	WebElement orderLink;
	
	@FindBy(xpath="//a[contains(@class,'button view')]")
	@CacheLookup
	WebElement viewLink;
	
	@FindBy(xpath="//h2[contains(text(),'Order Details')]")
	@CacheLookup
	WebElement orderDetails;
	
	@FindBy(xpath="//h2[contains(text(),'Customer Details')]")
	@CacheLookup
	WebElement customerDetails;
	
	@FindBy(xpath="//h3[contains(text(),'Billing Address')]")
	@CacheLookup
	WebElement billingDetails;
	
	@FindBy(xpath="//mark[contains(@class,'order-number')]")
	@CacheLookup
	WebElement orderNo;
	
	@FindBy(xpath="//mark[contains(@class,'order-date')]")
	@CacheLookup
	WebElement orderDate;
	
	@FindBy(xpath="//mark[contains(@class,'order-status')]")
	@CacheLookup
	WebElement orderStatus;
	
	@FindBy(xpath="//a[contains(text(),'Addresses')]")
	@CacheLookup
	WebElement addressLink;
	
	@FindBy(xpath="//h3[contains(text(),'Billing Address')]")
	@CacheLookup
	WebElement billingAddHeading;
	
	@FindBy(xpath="//div[contains(@class,'u-column1 col-1 woocommerce-Address')]//address[1]")
	@CacheLookup
	WebElement billingAddress;
	
	@FindBy(xpath="//h3[contains(text(),'Shipping Address')]")
	@CacheLookup
	WebElement shippingAddHeading;
	
	@FindBy(xpath="//div[contains(@class,'u-column2 col-2 woocommerce-Address')]//address[1]")
	@CacheLookup
	WebElement shippingAddress;
	
	@FindBy(xpath="//div[contains(@class,'u-column2 col-2 woocommerce-Address')]//a[contains(@class,'edit')][contains(text(),'Edit')]")
	@CacheLookup
	WebElement shippingAddEditBtn;
	
	@FindBy(id="shipping_first_name")
	@CacheLookup
	WebElement txtShpFirstName;
	
	@FindBy(id="shipping_last_name")
	@CacheLookup
	WebElement txtShpLastName;
	
	@FindBy(xpath="//div[@id='s2id_shipping_country']//b")
	@CacheLookup
	WebElement countrydd;
	
	@FindBy(id="s2id_autogen1_search")
	@CacheLookup
	WebElement txtCountry;
	
	@FindBy(id="shipping_address_1")
	@CacheLookup
	WebElement txtShpAdd1;
	
	@FindBy(id="shipping_address_2")
	@CacheLookup
	WebElement txtShpAdd2;
	
	@FindBy(id="shipping_city")
	@CacheLookup
	WebElement txtShpCity;
	
	@FindBy(id="shipping_postcode")
	@CacheLookup
	WebElement txtPinCode;
	
	@FindBy(xpath="//input[@name='save_address']")
	@CacheLookup
	WebElement saveBtn;
	
	@FindBy(xpath="//div[contains(@class,'woocommerce-message')]")
	@CacheLookup
	WebElement crfMsg;
	
	@FindBy(xpath="//a[contains(text(),'Account Details')]")
	@CacheLookup
	WebElement accountDetailsLink;

	
	@FindBy(xpath="//input[@id='account_email']")
	@CacheLookup
	WebElement email;
	
	@FindBy(xpath="//input[@id='account_first_name']")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='account_last_name']")
	@CacheLookup
	WebElement lastName;
	
	
	@FindBy(id="password_current")
	@CacheLookup
	WebElement currentPwd;
	
	@FindBy(id="password_1")
	@CacheLookup
	WebElement newPwd;
	
	@FindBy(id="password_2")
	@CacheLookup
	WebElement crfNewPwd;
	
	@FindBy(xpath="//input[@name='save_account_details']")
	@CacheLookup
	WebElement saveBtn2;
	
	@FindBy(xpath="//div[contains(@class,'woocommerce-message')]")
	@CacheLookup
	WebElement crfMsgAfterChangingPwd;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	@CacheLookup
	WebElement logoutBtn;
	
	
   //actions
	
	public void clickOnSignOutBtn()
	{
		signOutBtn.click();
	}
	
	public void clickOnDashboardLink()
	{
		dashboardLink.click();
	}
	
	public boolean verifyingSuccessfullyLoginMsgFromWebPage(String exp_msg)
	{
		String act_msg=loginMsg.getText();
		System.out.println(act_msg);
		if(act_msg.contains(exp_msg))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean verifyingViewingDashboardOfTheSite(String exp_text)
	{
		String act_text=textFromDashboardPage.getText();
		System.out.println(act_text);
		if(act_text.contains(exp_text))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void clickOnOrderLink()
	{
		orderLink.click();
	}
	
	public boolean verifyingViewingOrderByClickingOnOrederLink(String exp_orderNumber, String exp_itemsWithPrice)
	{  
		boolean flag=false;
		List<WebElement>lists=driver.findElements(By.xpath("//table//tbody//tr"));
		for(int i=1; i<=lists.size();i++)
		{
			String orderNumber=driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[1]")).getText();
			String act_itemsWithPrice=driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[4]")).getText();
			String act_orderNumber=orderNumber.replaceAll("[^0-9]", "");
			System.out.println(act_itemsWithPrice);
			if((act_orderNumber.equals(exp_orderNumber))&&(act_itemsWithPrice.contains(exp_itemsWithPrice)))
			{
				flag=true;
			}
			else
			{
				flag=false;
			}
			
		}
		return flag;
	}
	
	public void clickOnViewLink()
	{
		viewLink.click();
	}
	
	public boolean verifyingViewingOrderDetailsCustomerDetailsBillingDetails(String exp_text1, String exp_text2, String exp_text3)
	{
		String orderText=orderDetails.getText();
		System.out.println(orderText);
		String customerText=customerDetails.getText();
		String billingText=billingDetails.getText();
		if((orderText.equals(exp_text1))&&(customerText.equals(exp_text2))&&(billingText.equals(exp_text3)))
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	 }
	
	public boolean verifyingOrderNoOrderDateAndOrderStatus(String exp_orderNo, String exp_orderDate, String exp_orderStatus)
	{
		String act_orderNo=orderNo.getText();
		String act_orderDate=orderDate.getText();
		String act_orderSattus=orderStatus.getText();
		if((act_orderNo.equals(exp_orderNo))&&(act_orderDate.equals(exp_orderDate))&&(act_orderSattus.equals(exp_orderStatus)))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public void clickOnAddressLink()
	{
		addressLink.click();
	}
	
	public boolean verifyingViewingBillingAddress(String exp_heading, String exp_address )
	{
		String act_billHeading=billingAddHeading.getText();
		System.out.println(act_billHeading);
		String act_billingAddress=billingAddress.getText();
		System.out.println(act_billingAddress);
		if((act_billHeading.equals(exp_heading))&&(act_billingAddress.contains(exp_address)))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public boolean verifyingViewingShippingAddress(String exp_heading, String exp_address)
	{
		String act_shippingHeading=shippingAddHeading.getText();
		String act_shiipingAddress=shippingAddress.getText();
		System.out.println(act_shiipingAddress);
		if((act_shippingHeading.equals(exp_heading))&&(act_shiipingAddress.contains(exp_address)))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	public void clickOnEditBtnForShippingAddress()
	{
		shippingAddEditBtn.click();
	}
	
	public void editingShippingAddress(String fname, String lname, String add1, String add2, String city, String pin) throws InterruptedException
	{
		txtShpFirstName.clear();
		txtShpFirstName.sendKeys(fname);
		Thread.sleep(2000);
		txtShpLastName.clear();
		txtShpLastName.sendKeys(lname);
	    Thread.sleep(2000);
		txtShpAdd1.clear();
		txtShpAdd1.sendKeys(add1);
		Thread.sleep(2000);
		txtShpAdd2.clear();
		txtShpAdd2.sendKeys(add2);
		Thread.sleep(2000);
		txtShpCity.clear();
		txtShpCity.sendKeys(city);
		Thread.sleep(2000);
		txtPinCode.clear();
		txtPinCode.sendKeys(pin);
	}
	
	public void clickOnSaveBtn()
	{
		saveBtn.click();
	}
	
	public boolean verifyingCrfMsgAfterEditingShippingAddress(String exp_text)
	{
		String act_text=crfMsg.getText();
		if(act_text.equals(exp_text))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void clickOnAccountDetailsLink()
	{
		accountDetailsLink.click();
	}
	
	public boolean verifyingViewingAccountDetails(String exp_email, String exp_fname, String exp_lname)
	{
		String act_email=email.getAttribute("value");
		System.out.println("user name:"+act_email);
		String act_fname=firstName.getAttribute("value");
		String act_lname=lastName.getAttribute("value");
		if((act_email.equals(exp_email))&&(act_fname.equals(exp_fname))&&(act_lname.equals(exp_lname)))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public void changeCurrentPassword(String cpwd, String npwd, String crfnpwd)
	{
		currentPwd.clear();
		currentPwd.sendKeys(cpwd);
		newPwd.clear();
		newPwd.sendKeys(npwd);
		crfNewPwd.clear();
		crfNewPwd.sendKeys(crfnpwd);
		
	}
	
	public void clickOnSaveBtnAfterChangeThePwd()
	{
		saveBtn2.click();
	}
	
	public boolean verifyingCrfMsgAfterChangingPassword(String exp_msg)
	{
		String act_msg=crfMsgAfterChangingPwd.getText();
		if(act_msg.equals(exp_msg))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void clickOnLogoutBtn()
	{
		logoutBtn.click();
	}
	
	public boolean verifyingMyAccountLoginPageTitleAfterLogout(String exp_title)
	{
		String act_title=driver.getTitle();
		System.out.println("Title of the login page:"+act_title);
		if(act_title.equals(exp_title))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}

