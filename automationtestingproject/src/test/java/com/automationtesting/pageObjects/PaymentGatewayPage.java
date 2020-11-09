package com.automationtesting.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentGatewayPage {
	
	public WebDriver driver;
	
	
 public PaymentGatewayPage(WebDriver driver)
 {
	this.driver=driver;
	PageFactory.initElements(driver, this);
 }
 
 //locators
 
 @FindBy(xpath="//input[@id='place_order']")
 @CacheLookup
 WebElement placeOrderBtn;
 
 @FindBy(xpath="//h3[contains(text(),'Billing Details')]")
 @CacheLookup
 WebElement billingDetails;
 
 @FindBy(xpath="//h3[contains(text(),'Additional Information')]")
 @CacheLookup
 WebElement additionalDetails;
 
 @FindBy(xpath="//h3[@id='order_review_heading']")
 @CacheLookup
 WebElement orderDetails;
 
 @FindBy(xpath="//tr[@class='order-total']//td")
 @CacheLookup
 WebElement totalprice;
 
 @FindBy(xpath="//label[contains(text(),'Direct Bank Transfer')]")
 @CacheLookup
 WebElement bankPayment;
 
 @FindBy(xpath="//label[contains(text(),'Check Payments')]")
 @CacheLookup
 WebElement chequePayment;
 
 @FindBy(xpath="//label[contains(text(),'Cash on Delivery')]")
 @CacheLookup
 WebElement cashPayment;
 
 @FindBy(xpath="//label[contains(text(),'PayPal Express Checkout')]")
 @CacheLookup
 WebElement paypalPayment;
 
 @FindBy(xpath="//input[@id='payment_method_bacs']")
 @CacheLookup
 WebElement radioBtnForBankPayment;
 
 @FindBy(xpath="//input[@id='payment_method_cod']")
 @CacheLookup
 WebElement radioBtnForCash;
 
 @FindBy(xpath="//input[@id='payment_method_ppec_paypal']")
 @CacheLookup
 WebElement radioBtnForPayPal;
 
 @FindBy(id="billing_first_name")
 @CacheLookup
 WebElement txtFirstName;
 
 @FindBy(id="billing_last_name")
 @CacheLookup
 WebElement txtLastName;
 
 @FindBy(id="billing_email")
 @CacheLookup
 WebElement txtEmailId;
 
 @FindBy(id="billing_phone")
 @CacheLookup
 WebElement txtPhNo;
 
 @FindBy(id="select2-chosen-1") //s2id_autogen1_search
 @CacheLookup
 WebElement countrybox;
 
 @FindBy(xpath="//div[@id='s2id_billing_country']//b")
 @CacheLookup
 WebElement dropdownBtn;
 
 @FindBy(id="s2id_autogen1_search")
 @CacheLookup
 WebElement txtSearchBox;
 
 @FindBy(id="billing_address_1")
 @CacheLookup
 WebElement txtBillingAdd1;
 
 @FindBy(id="billing_address_2")
 @CacheLookup
 WebElement txtBillingAdd2;
 
 @FindBy(id="billing_city")
 @CacheLookup
 WebElement txtCity;
 
 @FindBy(id="select2-chosen-2")
 @CacheLookup
 WebElement stateBox;
 
 @FindBy(id="billing_postcode")
 @CacheLookup
 WebElement txtPostCode;
 
 @FindBy(id="payment_method_cheque")
 @CacheLookup
 WebElement radioBtnForCheque;
 
 @FindBy(xpath="//a[contains(@class,'showcoupon')]")
 @CacheLookup
 WebElement couponLink;
 
 @FindBy(id="coupon_code")
 @CacheLookup
 WebElement txtCouponBox;
 
 @FindBy(name="apply_coupon")
 @CacheLookup
 WebElement applycouponBtn;
 
 @FindBy(xpath="//ul[@id='select2-results-1']//li//div")
 @CacheLookup
 List<WebElement> countryList;
 
 //action
 
  public boolean isPlaceOrderBtnDisplaced()
  {
	  boolean b1=placeOrderBtn.isDisplayed();
	  if(b1==true)
	  {
		  return true;
	  }
	  else
	  {
		  return false;
	  }
  }
 
  public boolean isPlaceOrderBtnClickable()
  {
	  boolean b1=placeOrderBtn.isEnabled();
	  if(b1==true)
	  {
		  return true;
	  }
	  else
	  {
		  return false;
	  }
  }
  
  public boolean verifyingPaymentGatewayPageTitle(String exp_title)
  {
	 String act_title= driver.getTitle();
	 System.out.println(act_title);
	 if(act_title.equals(exp_title))
	 {
		 return true;
	 }
	 else
	 {
		 return false;
	 }
  }
  
  public boolean isBillingDetailsdisplayed()
  {
	  boolean b1=billingDetails.isDisplayed();
	   if(b1==true)
	  {
		  return true;
	  }
	  else
	  {
		  return false;
	  }
  }
  
  public boolean isAdditionalDetailsDisplayed()
  {
	  boolean b1=additionalDetails.isDisplayed();
	  if(b1==true)
	  {
		  return true;
	  }
	  else
	  {
		  return false;
	  }
  }
  
  public boolean isOrderDetailsDisplayed() 
  {
	 boolean b1= orderDetails.isDisplayed();
	 boolean b2= totalprice.isDisplayed();
	 if((b1==true)&&(b2==true))
	 {
		 return true;
	 }
	 else
	 {
		 return false;
	 }
  }
  
  public boolean isPaymentDetailsDisplayed()
  {
	  boolean b1=bankPayment.isDisplayed();
	  boolean b2= radioBtnForBankPayment.isDisplayed();
	  boolean b3= chequePayment.isDisplayed();
	  boolean b5=cashPayment.isDisplayed();
	  boolean b6=radioBtnForCash.isDisplayed();
	  boolean b7=paypalPayment.isDisplayed();
	  boolean b8= radioBtnForPayPal.isDisplayed();
	  
	  if((b1==true)&&(b2==true)&&(b3==true)&&(b5==true)&&(b6==true)&&(b7==true)&&(b8==true))
	  {
		  return true;
	  }
	  else
	  {
		  return false;
	  }
  }
  
  public boolean verifyingAddCouponInPaymentPage()
  {
	  couponLink.click();
	  boolean b1=txtCouponBox.isDisplayed();
	  boolean b2=applycouponBtn.isEnabled();
	  if((b1==true)&&(b2==true))
	  {
		  return true;
	  }
	  else
	  {
		  return false;
	  }
  }
  
  public void fillingUpBillingDetails(String fname, String lname, String email, String ph, String countryname, String exp_country,
		  String add1, String add2, String cityname, String statename, String exp_state, String pincode ) throws InterruptedException
  {  
	  boolean b1=txtFirstName.isDisplayed();
      if(b1==true) {
      txtFirstName.clear();
	  txtFirstName.sendKeys(fname);
      }
      boolean b2=txtLastName.isDisplayed();
      if(b2==true) {
      txtLastName.clear();
	  txtLastName.sendKeys(lname);
      }
      boolean b3=txtEmailId.isDisplayed();
      if(b3==true) {
      txtEmailId.clear();
	  txtEmailId.sendKeys(email);
      }
      boolean b4=txtPhNo.isDisplayed();
      if(b4==true) {
      txtPhNo.clear();
	  txtPhNo.sendKeys(ph);
      }
      
      boolean b5=dropdownBtn.isDisplayed();
      if(b5==true) 
      {
	  dropdownBtn.click();
	  txtSearchBox.clear();
	  txtSearchBox.sendKeys(countryname);
	 // List<WebElement>countryList=driver.findElements(By.xpath("//ul[@id='select2-results-1']//li//div"));
	  System.out.println(countryList.size());
	  for(WebElement country:countryList)
	  {
		 String act_country= country.getText();
		 System.out.println(act_country);
		 if(act_country.equals(exp_country))
		 {
			 country.click();
		 }
	  }
      }
      
      boolean b6=txtBillingAdd1.isDisplayed();
      if(b6==true) {
      txtBillingAdd1.clear();
	  txtBillingAdd1.sendKeys(add1);
      }
      boolean b7=txtBillingAdd2.isDisplayed();
      if(b7==true) {
      txtBillingAdd2.clear();
	  txtBillingAdd2.sendKeys(add2);
      }
      boolean b8=txtCity.isDisplayed();
      if(b8==true) {
      txtCity.clear();
	  txtCity.sendKeys(cityname);
      }
      
	  driver.findElement(By.xpath("//a[@class='select2-choice select2-default']//b")).click();
	  WebElement ele= driver.findElement(By.xpath("//div[@class='select2-search']//input[@id='s2id_autogen2_search']"));
	  
	  JavascriptExecutor js= (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].click()",ele );
	  ele.clear();
	  ele.sendKeys(statename);
	  
	  List<WebElement>statesList =driver.findElements(By.xpath("//ul[@id='select2-results-2']//li//div"));
	  System.out.println(statesList.size());
		for(WebElement state:statesList)
		{   
			String act_state=state.getText();
			if(act_state.equals(exp_state))
			{
				state.click();
			}
		}
	  
	  boolean b9=txtPostCode.isDisplayed();
	  if(b9==true) {
	  txtPostCode.clear();
	  txtPostCode.sendKeys(pincode);
	  }
	  boolean b10=radioBtnForCheque.isDisplayed();
	  if(b10==true) {
	  radioBtnForCheque.click();
	  }
  
  }
  
  public void clickOnPlaceOrderBtn()
  {
	  placeOrderBtn.click();
  }
  
  public boolean verifyingTaxRateInIndia(double exp_subtotal)
  {  
	 boolean flag=false;
	 double twoPercentOfSubTotal=0.0;
	 List<WebElement>rownum= driver.findElements(By.xpath("//table[@class='shop_table woocommerce-checkout-review-order-table']//tfoot//tr"));
	 for(int r=1; r<=rownum.size(); r++)
	 {   
		 String subTotal=driver.findElement(By.xpath("//table[@class='shop_table woocommerce-checkout-review-order-table']//tfoot//tr["+r+"]//td")).getText();
		 String act_subTotal=subTotal.replaceAll("[^0-9.]", "");
		 double double_actSubTotal=Double.parseDouble(act_subTotal);
		 System.out.println("Subtotal after converting in double:"+double_actSubTotal);
		 if(double_actSubTotal==exp_subtotal)
		  {
			twoPercentOfSubTotal=(double_actSubTotal*2)/100;
			System.out.println("Getting 2 percent of subtotal:"+twoPercentOfSubTotal);
		    String tax=driver.findElement(By.xpath("//table[@class='shop_table woocommerce-checkout-review-order-table']//tfoot//tr["+(r+1)+"]//td")).getText();
		    String str_tax=tax.replaceAll("[^0-9.]", "");
		    System.out.println("Tax after removing regex:"+str_tax);
		    double act_tax=Double.parseDouble(str_tax);
		    if(act_tax==twoPercentOfSubTotal)
		    {
			   flag=true;
			   break;
		    }
		    else
		    {
			   flag=false;
		    }
	    }
	 }
	 return flag;
   
  }
  
  public void clickOnOtherCountry(String countryname, String exp_country) throws InterruptedException
  {   
	  
	  WebElement ele=driver.findElement(By.xpath("//div[@id='s2id_billing_country']//b"));
	  Actions actions = new Actions(driver);
	  actions.moveToElement(ele).click().build().perform();
	  Thread.sleep(2000);
	  WebElement csb=driver.findElement(By.id("s2id_autogen1_search"));
	  csb.sendKeys(countryname);
	  List<WebElement>countryLists=driver.findElements(By.xpath("//ul[@id='select2-results-1']//li//div"));
	  System.out.println(countryLists.size());
	  for(WebElement country1:countryLists)
	  {
		 String act_country= country1.getText();
		 System.out.println(act_country);
		 if(act_country.equals(exp_country))
		 {
			 country1.click();
			 break;
		 }
	  }
   }
  

  public boolean verifyingTaxRateInAbroad(double exp_subtotal)
  {
	  boolean flag=false;
		 double fivePercentOfSubTotal=0.0;
		 List<WebElement>rownum= driver.findElements(By.xpath("//table[@class='shop_table woocommerce-checkout-review-order-table']//tfoot//tr"));
		 for(int r=1; r<=rownum.size(); r++)
		 {   
			 String subTotal=driver.findElement(By.xpath("//table[@class='shop_table woocommerce-checkout-review-order-table']//tfoot//tr["+r+"]//td")).getText();
			 String act_subTotal=subTotal.replaceAll("[^0-9.]", "");
			 double double_actSubTotal=Double.parseDouble(act_subTotal);
			 System.out.println("Subtotal after converting in double:"+double_actSubTotal);
			 if(double_actSubTotal==exp_subtotal)
			  {
				fivePercentOfSubTotal=(double_actSubTotal*5)/100;
				System.out.println("Getting 5 percent of subtotal:"+fivePercentOfSubTotal);
			    String tax=driver.findElement(By.xpath("//table[@class='shop_table woocommerce-checkout-review-order-table']//tfoot//tr["+(r+1)+"]//td")).getText();
			    String str_tax=tax.replaceAll("[^0-9.]", "");
			    System.out.println("Tax after removing regex:"+str_tax);
			    double act_tax=Double.parseDouble(str_tax);
			    if(act_tax==fivePercentOfSubTotal)
			    {
				   flag=true;
				   break;
			    }
			    else
			    {
				   flag=false;
			    }
		    }
		 }
		 return flag;
	   
	  }
	  
  }


