package com.automationtesting.pageObjects;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArrivalsImageAddPage {
	
	public WebDriver driver;
	
	public ArrivalsImageAddPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
   
	//locators
	
	
	@FindBy(xpath="//a[contains(text(),'Description')]")
	@CacheLookup
	WebElement descriptionBtn;
	
	@FindBy(xpath="//div[@id='tab-description']//p[contains(text(),'The Selenium WebDriver Recipes book is a quick pro')]")
	@CacheLookup
	WebElement productdescription;
	
	@FindBy(xpath="//a[contains(text(),'Reviews (0)')]")
	@CacheLookup
	WebElement reviewBtn;
	
	@FindBy(xpath="//p[@class='woocommerce-noreviews']")
	@CacheLookup
	WebElement reviewMsg;
	
	@FindBy(xpath="//div//button[@class='single_add_to_cart_button button alt']")
	@CacheLookup
	WebElement addToBasketBtn;
   
	
	@FindBy(xpath="//input[contains(@name,'quantity')]")
	@CacheLookup
	WebElement txtbox;
	

	@FindBy(xpath="//a[contains(@class,'button wc-forward')]")
	@CacheLookup
	WebElement viewBasketBtn;
	
	@FindBy(xpath="//div[@class='woocommerce-message']")
	@CacheLookup
	WebElement confirmAddedMsg;
	
    @FindBy(xpath="//a[@title='View your shopping cart']//i[@class='wpmenucart-icon-shopping-cart-0']//following-sibling::span[1]")
    @CacheLookup
    WebElement cartContent;
    
    @FindBy(xpath="//a[@title='View your shopping cart']//i[@class='wpmenucart-icon-shopping-cart-0']//following-sibling::span[2]")
    @CacheLookup
    WebElement cartPrice;
    
    @FindBy(xpath="//span[@class='cartcontents']")
    @CacheLookup
    WebElement menuItem;
    
    @FindBy(xpath="//h1[contains(@class,'product_title entry-title')]")
    @CacheLookup
    WebElement bookName;
    
    @FindBy(xpath="//p[contains(@class,'stock out-of-stock')]")
    @CacheLookup
    WebElement noStockMsg;
    
    @FindBy(xpath="//div[@itemprop='offers']//p[@class='price']//del")
    @CacheLookup
    WebElement oldPrice;
    
    @FindBy(xpath="//p[@class='price']//del//following-sibling::ins")
    @CacheLookup
    WebElement actualPrice;
    
    
	//actions
	
	public void clickOnDescriptionBtn()
	{
		descriptionBtn.click();
	}
	
	public boolean getProductDescriptionDetails(String exp_text)
	{  
		String act_text=productdescription.getText();
		if(act_text.contains(exp_text))
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
	
	public void clickOnReviewBtn()
	{
		reviewBtn.click();
	}
	
	public boolean verifyingReviewMsg(String exp_text)
	{
		String act_text=reviewMsg.getText();
		if(act_text.contains(exp_text))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public void clickOnViewBasketBtn()
	{
		viewBasketBtn.click();
	}
	
	public boolean verifyingConfirmAddedMsg(String exp_msg1)
	{
		String act_msg=confirmAddedMsg.getText();
		System.out.println(act_msg);
		if(act_msg.contains(exp_msg1))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean verifyingBookInViewBasket(String exp_bookname, double exp_price) throws InterruptedException
	{  
		boolean flag=false;
		List<WebElement>rownum=driver.findElements(By.xpath("//table//tbody//tr"));
		
		for(int r=1; r<rownum.size(); r++)
		{
			String act_bookname=driver.findElement(By.xpath("//table//tbody//tr["+r+"]//td[3]")).getText();
			if(act_bookname.equals(exp_bookname))
			{
				String act_price=driver.findElement(By.xpath("//table//tbody//tr["+r+"]//td[6]")).getText();
				String price=act_price.replaceAll("[^0-9.]", "");
				double double_price=Double.parseDouble(price);
				
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


	
	public void clickOnAddToBasket()
	{
		addToBasketBtn.click();
	}
	
	public boolean verifyingMenuItemWithPrice(String exp_item,double exp_price)
	{  boolean flag=false;
	   double double_price=0.0;
		String act_item=cartContent.getText();
		System.out.println(act_item);
		if(act_item.equals(exp_item))
		{
			String act_price=cartPrice.getText();
			System.out.println(act_price);
			String price=act_price.replaceAll("[^0-9.]","");
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
	
	public void clickOnMenuItem()
	{
		menuItem.click();
		
	}
	
	public boolean addingMoreBooksThanStocks(String exp_text) throws InterruptedException
	{
		txtbox.clear();
		txtbox.sendKeys("857");
		addToBasketBtn.click();
		Alert alert=driver.switchTo().alert();
		String act_text=alert.getText();
		
		
		//String act_text=driver.findElement(By.xpath("//div//div//input[@name='add-to-cart']")).getText();
		//Thread.sleep(2000);
		
		
		Thread.sleep(3000);
		if(( act_text).contains(exp_text))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean verifyingBookOutOfStock(String exp_bookName, String exp_msg)
	{
		boolean flag=false;
		String act_bookName=bookName.getText();
		if(act_bookName.equals(exp_bookName))
		{
			String act_msg=noStockMsg.getText();
			if(act_msg.equals(exp_msg))
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
	
	public boolean verifyingActualBookPriceWithOldPrice(double exp_oldPrice, double exp_salePrice)
	{  
		boolean flag=false;
		String price=oldPrice.getText();
		System.out.println(price);
		String act_price=price.replaceAll("[^0-9.]", "");
		System.out.println(act_price);
		double act_oldPrice=Double.parseDouble(act_price);
		if(act_oldPrice==exp_oldPrice)
		{
			String price2=actualPrice.getText();
			System.out.println(price2);
			String sale_price=price2.replaceAll("[^0-9.]", "");
			System.out.println(sale_price);
			double act_salePrice=Double.parseDouble(sale_price);
			if(act_salePrice==exp_salePrice)
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
	
	public boolean verifyingOldPriceStikenOut(String exp_dPrice)
	{  boolean flag=false;
	   boolean strikeExists=!oldPrice.getText().isEmpty();
	   boolean discountedPrice=actualPrice.getText().contains(exp_dPrice);
	   if((strikeExists==true)&&(discountedPrice==true))
	   {
		   flag=true;
	   }
	   else
	   {
		   flag=false;
	   }
	   
		return flag;
	}
}

