package com.automationtesting.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
	
	public WebDriver driver;
	
	public OrderConfirmationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//locatores
	
	@FindBy(xpath="//p[contains(@class,'woocommerce-thankyou-order-received')]")
	@CacheLookup
	WebElement orderCrfMsg;
	
	@FindBy(xpath="//strong[contains(text(),'Check Payments')]")
	@CacheLookup
	WebElement paymentWay;
	
	@FindBy(xpath="//p[contains(text(),'Please send a cheque to Store Name, Store Street,')]")
	@CacheLookup
	WebElement paymentDetails;
	
	@FindBy(xpath="//h2[contains(text(),'Order Details')]")
	@CacheLookup
	WebElement orderDetails;
	
	@FindBy(xpath="//table//tfoot//tr[4]//td[1]")
	@CacheLookup
	WebElement totalPrice;
	
	//actions
	
	public  boolean verifyingOrderCrfMsg(String exp_msg)
	{
		String act_msg=orderCrfMsg.getText();
		if(act_msg.contains(exp_msg))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean verifyingPaymentWay(String exp_pway, String exp_payDetails)
	{  boolean flag=false;
		String act_pway=paymentWay.getText();
		if(act_pway.contains(exp_pway))
		{
			String act_payDetails=paymentDetails.getText();
			System.out.println(act_payDetails);
			if(act_payDetails.equals(exp_payDetails))
			{
				flag= true;
			}
			else
			{
				flag= false;
			}
		}
		return flag;
	}
	
	
	
	public boolean verifyingOrderDetails(String exp_text, double exp_total)
	{   
		boolean flag=false;
		String act_text=orderDetails.getText();
		System.out.println(act_text);
		if(act_text.equals(exp_text))
		{
			String act_total=totalPrice.getText();
			System.out.println(act_total);
			String price=act_total.replaceAll("[^0-9.,]", "");
			System.out.println(price);
			double double_price=Double.parseDouble(price);
			if(double_price==exp_total)
			{
				flag= true;
			}
			else
			{
				flag= false;
			}
		}
		return flag;
	}
}
