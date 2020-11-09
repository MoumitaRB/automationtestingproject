package com.automationtesting.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	
	public WebDriver driver;
	
	public CheckOutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//locators
	
	@FindBy(xpath="//a[contains(@class,'checkout-button button alt wc-forward')]")
	@CacheLookup
	WebElement proceedToCheckoutBtn;
	
	@FindBy(xpath="//h3[@id='order_review_heading']")
	@CacheLookup
	WebElement confirmText;
	
	@FindBy(xpath="//tbody//tr")
	@CacheLookup
	List<WebElement> rowNum;
	
	@FindBy(id="coupon_code")
	@CacheLookup
	WebElement txtCouponBox;
	
	
	@FindBy(xpath="//input[contains(@name,'apply_coupon')]")
	@CacheLookup
	WebElement couponBtn;

	@FindBy(xpath="//a[contains(@class,'showcoupon')]")
	@CacheLookup
	WebElement couponLink;
	
	@FindBy(xpath="//div[contains(@class,'woocommerce-message')]")
	@CacheLookup
	WebElement couponAddedCrfMsg;
	
	@FindBy(xpath="//div[@id='body']//li[1]")
	@CacheLookup
	WebElement couponDeniedCrfMsg;
	
	@FindBy(xpath="//a[contains(@class,'remove')]")
	@CacheLookup
	WebElement removeBtn;
	
	@FindBy(xpath="//div[contains(@class,'woocommerce-message')]")
	@CacheLookup
	WebElement removedCrfMsg;
	
	@FindBy(xpath="//input[@title='Qty']")
	@CacheLookup
	WebElement txtQtyBox;
	
	@FindBy(xpath="//div//input[@name='update_cart']")
	@CacheLookup
	WebElement updateBasketBtn;
	
	@FindBy(xpath="//table[@class='shop_table shop_table_responsive']//tbody//tr")
	@CacheLookup
	List<WebElement> totalRows;
	
	@FindBy(xpath="//span[@class='cartcontents']")
	@CacheLookup
	WebElement menuItem;
	
	@FindBy(xpath="//span[@class='amount']")
	@CacheLookup
	WebElement itemPrice;
	
	//actions
	public boolean isProceedToCheckOutButtonClickable()
	{
		boolean b1=proceedToCheckoutBtn.isDisplayed();
		if(b1==true)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public void clickOnProceedToCheckOutBtn()
	{
		proceedToCheckoutBtn.click();
	}
	
	public boolean verifyingConfirmTextFrombillingPage(String exp_text, String exp_book)
	{   
		boolean flag=false;
		String act_text=confirmText.getText();
		System.out.println(act_text);
		if(act_text.equals(exp_text))
		{
			for(int r=1; r<=rowNum.size(); r++)
			{
				String act_book=driver.findElement(By.xpath("//tbody//tr["+r+"]//td[1]")).getText();
				String ac_book=act_book.replaceAll("[^A-Za-z ]", "");
				System.out.println(ac_book);
				if(ac_book.equals(exp_book))
				{
					flag=true;
				}
				else
				{
					flag=false;
				}
			}
		}
		
		return flag;
	}
	public void setCouponCode(String coupon)
	{
		txtCouponBox.sendKeys(coupon);
	}
	
	public void clickOnCouponBtn()
	{
		couponBtn.click();
	}
	public boolean verifyingCouponAddedCrfMsg(String exp_msg)
	{
		String act_msg=couponAddedCrfMsg.getText();
		if(act_msg.contains(exp_msg))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean verifyingApplyingCouponCode(String coupon, String exp_text) throws InterruptedException
	{  
		boolean flag=false;
		
		List<WebElement>totalRow=driver.findElements(By.xpath("//table[@class='shop_table woocommerce-checkout-review-order-table']//tfoot//tr"));
		for(int r=1; r<=totalRow.size(); r++)
		{
			String couponName=driver.findElement(By.xpath("//table[@class='shop_table woocommerce-checkout-review-order-table']//tfoot//tr["+r+"]//th")).getText();
			if(couponName.equals(coupon))
			{
				String act_text=driver.findElement(By.xpath("//table[@class='shop_table woocommerce-checkout-review-order-table']//tfoot//tr["+r+"]//td//span")).getText();
			    if(act_text.contains(exp_text))
			    {
			    	flag=true;
			    }
			    else
			    {
			    	flag=false;
			    }
			  if(flag=true)
			  {
				  break;
			  }
			}
		}
		return flag;
	}
	

	public boolean verifyingCouponDeniedMsg(String exp_text)
	{
		String act_text=couponDeniedCrfMsg.getText();
		
		if(act_text.toString().equals(exp_text))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void clickOnRemoveBtn()
	{
		removeBtn.click();
	}
	
	public boolean verifyingRemovedCrfMsg(String exp_text)
	{
		String act_text=removedCrfMsg.getText();
		if(act_text.contains(exp_text))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean verifyingCartItemWithPrice(String exp_item, double exp_price)
	{    double double_price= 0.00;
		 boolean flag=false;
			String act_item=menuItem.getText();
			if(act_item.equals(exp_item))
			{
				String act_price=itemPrice.getText();
				String price=act_price.replaceAll("[^0-9.]", "");
				System.out.println(price);
				double_price=double_price+Double.parseDouble(price);
				if(double_price==exp_price)
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
	public boolean isUpdateBasketBtnClickable(String qty)
	{
		txtQtyBox.clear();
		txtQtyBox.sendKeys(qty);
		boolean clickableStatus=updateBasketBtn.isEnabled();
		if(clickableStatus==true)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	public void clickOnUpdateBasketBtn()
	{
		updateBasketBtn.click();
	}
	public boolean verifyingChangesInTheUpdateBasket(String exp_name, double exp_price) throws InterruptedException
	{   
		double double_price=0.0;
		boolean flag=false;
		List<WebElement>rownum=driver.findElements(By.xpath("//table[@class='shop_table shop_table_responsive cart']//tbody//tr"));
		for(int r=1; r<rownum.size(); r++)
		{
			String act_name=driver.findElement(By.xpath("//table//tbody//tr["+r+"]//td[3]")).getText();
			if(act_name.equals(exp_name))
			{
				String act_price=driver.findElement(By.xpath("//table//tbody//tr["+r+"]//td[6]")).getText();
				String price=act_price.replaceAll("[^0-9.]", "");
				System.out.println(price);
				double_price=double_price+Double.parseDouble(price);
				
				if(double_price==exp_price)
				{
					flag= true;
					break;
					
				}
				else
				{
					flag= false;
				}	
		    }
			if(flag=true)
			{
				break;
			}
		}
		return flag;
		
	}
	
	public boolean verifyingTotalPriceInTheCheckOutGrid(double exp_total)
	{
		boolean flag=false;
		List<WebElement>rows=driver.findElements(By.xpath("//table[@class='shop_table shop_table_responsive']//tbody//tr"));
		for(int r=1; r<=rows.size(); r++)
		{
			String act_total=driver.findElement(By.xpath("//table[@class='shop_table shop_table_responsive']//tbody//tr["+r+"]//td//span")).getText();
			String total=act_total.replaceAll("[^0-9.]", "");
			double double_total=0.0;
			
			double_total=double_total+Double.parseDouble(total);
			if(double_total==exp_total)
			{
				flag= true;
			
			}
			else
			{
				flag= false;
			}
			if(flag=true)
			{
				break;
			}
		}
		return flag;
	}
	
	public boolean getSubTotalPrice(double exp_subtotal)
	{  
		boolean flag1=false;
		List<WebElement>rownum=driver.findElements(By.xpath("//table[@class='shop_table shop_table_responsive']//tbody//tr"));
		//System.out.println(rownum.size());
		for(int r=1; r<=rownum.size(); r++)
		{
			String act_subtotal=driver.findElement(By.xpath("//table[@class='shop_table shop_table_responsive']//tbody//tr["+r+"]//td//span")).getText();
			String subtotal=act_subtotal.replaceAll("[^0-9.]", "");
			double double_subtotal=0.0;
			
			double_subtotal=double_subtotal+Double.parseDouble(subtotal);
			if(double_subtotal==exp_subtotal)
			{   
				flag1=true;
				break;
				
			}
			else
			{
				flag1=false;
			}
			if(flag1=true)
			{
				break;
			}
		}
		
		return flag1;
	}
	
	public boolean getTotalPrice(double exp_total)
	{ 
		boolean flag2=false;
		List<WebElement>rownum=driver.findElements(By.xpath("//table[@class='shop_table shop_table_responsive']//tbody//tr"));
		for(int r=1; r<=rownum.size(); r++)
		{
			String act_total=driver.findElement(By.xpath("//table[@class='shop_table shop_table_responsive']//tbody//tr["+r+"]//td//span")).getText();
			String total=act_total.replaceAll("[^0-9.]", "");
			double double_total=0.0;
			double_total=double_total+Double.parseDouble(total);
			if(double_total==exp_total)
			{   
				flag2=true;
				break;
			}
			else
			{
				flag2=false;
			}
			
			if(flag2=true)
			{
				break;
			}
		}
	  return flag2;
	}
	
	
	public boolean verifyingTotalIsGreaterThanSubtotal(double exp_subtotal, double exp_total)
	{   boolean flag=false;
		List<WebElement>rownum=driver.findElements(By.xpath("//table[@class='shop_table shop_table_responsive']//tbody//tr"));
		for(int r=1; r<=rownum.size(); r++)
		{
			String act_subtotal=driver.findElement(By.xpath("//table[@class='shop_table shop_table_responsive']//tbody//tr["+r+"]//td//span")).getText();
			String subtotal=act_subtotal.replaceAll("[^0-9.]", "");
			double double_subtotal=0.0;
			double_subtotal=double_subtotal+Double.parseDouble(subtotal);
			System.out.println(double_subtotal);
			
			if(double_subtotal==exp_subtotal)
			{
				String act_tax=driver.findElement(By.xpath("//table[@class='shop_table shop_table_responsive']//tbody//tr["+(r+1)+"]//td//span")).getText();
				String tax=act_tax.replaceAll("[^0-9.]", "");
				double double_tax=0.0;
				double_tax=double_tax+Double.parseDouble(tax);
				System.out.println(double_tax);
				double total=double_subtotal+double_tax;
				System.out.println(total);
				//String act_total=driver.findElement(By.xpath("//table[@class='shop_table shop_table_responsive']//tbody//tr["+(r+2)+"]//td//span")).getText();
				//String totalprice=act_total.replaceAll("[^0-9.]", "");
				//double double_totalPrice=Double.parseDouble(totalprice);
				//System.out.println(double_totalPrice);
				if((exp_total==total)&&(exp_total>double_subtotal))
				{
				    flag=true;
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
