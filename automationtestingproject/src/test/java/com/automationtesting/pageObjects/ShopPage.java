package com.automationtesting.pageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShopPage {
	
   public WebDriver driver;
   public  List<Double>originalList;
   public  List<Double>sortedList;
   public ArrayList<Double>pricelist;
   public ArrayList<Double>originalList1=new ArrayList<Double>();
   public  ArrayList<Double>sortedList1= new ArrayList<Double>();
   
   
	
	public ShopPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//locators
	
	@FindBy(xpath="//div[@class='price_slider ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all']//span[2]")
	@CacheLookup
	WebElement slider;
	
	@FindBy(xpath="//button[@class='button']")
	@CacheLookup
	WebElement filterBtn;
	
	@FindBy(xpath="//li//a[@class='woocommerce-LoopProduct-link']")
	@CacheLookup
	List<WebElement> bookListBelow500;
	
	@FindBy(xpath="//a[contains(text(),'JavaScript')]")
	@CacheLookup
	WebElement productLink;
	
	@FindBy(xpath="//select[contains(@name,'orderby')]")
	@CacheLookup
	WebElement dropdownBtn;
	
	@FindBy(xpath="//li[@class='post-169 product type-product status-publish product_cat-android product_tag-android has-post-title no-post-date has-post-category has-post-tag has-post-comment has-post-author first outofstock sale downloadable taxable shipping-taxable purchasable product-type-simple']//a[@class='button product_type_simple ajax_add_to_cart'][contains(text(),'Read more')]")
	@CacheLookup
	WebElement readMoreBtn;
	
	@FindBy(xpath="//li[3]//a[2]")
	@CacheLookup
	WebElement addToBasketBtn;
	
	@FindBy(xpath="//a[@title='View your shopping cart']//i[@class='wpmenucart-icon-shopping-cart-0']//following-sibling::span[1]")
    @CacheLookup
    WebElement cartContent;
    
    @FindBy(xpath="//a[@title='View your shopping cart']//i[@class='wpmenucart-icon-shopping-cart-0']//following-sibling::span[2]")
    @CacheLookup
    WebElement cartPrice;
    
    @FindBy(xpath="//a[contains(@class,'added_to_cart wc-forward')]")
    @CacheLookup
    WebElement viewBasketBtn;
    
    @FindBy(xpath="//a[@title='View your shopping cart']//span[@class='cartcontents']")
    @CacheLookup
    WebElement itemLink;
    
   
	//actions
    
    public void getTheLengthOfXAxis()
    {
    	int xLength=slider.getLocation().getX();
    	System.out.println("Length of x axis:"+xLength);
    }
	
	public void adjustingFilterByPrice() throws InterruptedException
    {   
		for(int i=0;i<=49;i++){
            //Slide to RIGHT
           // slider.sendKeys(Keys.ARROW_RIGHT);
          //Slide to LEFT
           slider.sendKeys(Keys.ARROW_LEFT);
       }
 //    	Actions act=new Actions(driver);    	
//    	act.dragAndDropBy(slider,530, 0).build().perform();
    	Thread.sleep(6000);
    	filterBtn.click();
    }
    
    public boolean verifyingBooksWithTitle(String title1, String title2, String title3, String title4, String title5, String title6, String title7)
    {  
    	boolean flag=false;
    	List<WebElement>booklist=driver.findElements(By.xpath("//li//a[@class='woocommerce-LoopProduct-link']//img"));
    	System.out.println(booklist.size());
    	for(WebElement book:booklist)
    	{
    		String booktitle=book.getAttribute("title");
    		System.out.println(booktitle);
    		if((booktitle.equals(title1))||(booktitle.equals(title2))||(booktitle.equals(title3))||
    				(booktitle.equals(title4))||(booktitle.equals(title5))||(booktitle.equals(title6))||(booktitle.equals(title7)))
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
    			
    			
    			
    public boolean verifyingBookPriceBetween150To450(double exp_price1, double exp_price2)			
    			
    {	boolean flag1=false;
        Set<Double>set= new HashSet<Double>();
    	 List<WebElement>ele= driver.findElements(By.xpath("//span[@class='price']//span[@class='woocommerce-Price-amount amount']"));
    	 System.out.println(ele.size());
    	 for(WebElement price:ele)
    	  {  
    		  String priceText=price.getText();
    		  System.out.println(priceText);
    		  String act_price=priceText.replaceAll("[^0-9.]", "");
    		  System.out.println(act_price);
    		  double double_actprice=Double.parseDouble(act_price);
    		  if(double_actprice!=600.00)
    		    {
    		    	 set.add(double_actprice);
    		    	 System.out.println(set);
    		    }
    	  }
    			 
    		 Iterator<Double> it= set.iterator();
    		 while(it.hasNext())
    		 {
    			 double bookPrice=(Double) it.next();
    			 System.out.println(bookPrice);
    			 if((bookPrice>=exp_price1)&&(bookPrice<=exp_price2))
    			  {
    			    flag1=true;
    			  }
    			  else
    			  {
    			    flag1=false;
    			  }
    			    	
    	    }
    	return flag1;
    			    
    		}
    public void storingBookPriceInArrayList() 
    {
    	pricelist=new ArrayList<Double>();
    	
    	List<WebElement>ele= driver.findElements(By.xpath("//span[@class='price']//span[@class='woocommerce-Price-amount amount']"));
   	    System.out.println(ele.size());
   	    for(WebElement price:ele)
   	    {  
   		  String priceText=price.getText();
   		  System.out.println(priceText);
   		  String act_price=priceText.replaceAll("[^0-9.]", "");
   		  System.out.println(act_price);
   		  double double_actprice=Double.parseDouble(act_price);
   		  if(double_actprice!=600)
   		  {
   			 pricelist.add(double_actprice);
   		  }
   		}
   	    System.out.println(pricelist);
   	    pricelist.remove(6);
   	    System.out.println(pricelist);
   	    
    	
    }

   public boolean verifyingBookPriceMethod2Between150To450(double exp_price1, double exp_price2)
   {   
	   boolean flag=false;
	   for(double price:pricelist)
	   {
		   if((price>=exp_price1)&&(price<=exp_price2))
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

    public void clickOnProductLink()
    {
    	productLink.click();
    }
    	

   public boolean verifyingJavaScriptRelatedProduct(String exp_title1, String exp_title2, String exp_title3)
   {  
	  boolean flag=false;
	  List<WebElement>bookList= driver.findElements(By.xpath("//a//img[@class='attachment-shop_catalog size-shop_catalog wp-post-image']"));
      for(WebElement ele:bookList)
      {
    	String act_title= ele.getAttribute("title");
    	if((act_title.equals(exp_title1))||(act_title.equals(exp_title2))||(act_title.equals(exp_title3)))
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
   
   public void clickOnDefaultDropDown(String exp_string )
   {
	   driver.findElement(By.xpath("//select[contains(@name,'orderby')]")).click();
	   Select select =new Select(dropdownBtn);
	   System.out.println(select.getOptions().size());
	   select.selectByVisibleText(exp_string);
   }
   
   public boolean verifyingPopularItemsInHomePage(String exp_title1, String exp_title2, String exp_title3, String exp_title4,
		   String exp_title5, String exp_title6, String exp_title7, String exp_title8)
   {
	   boolean flag=false;
	   List<WebElement>popularItemLists=driver.findElements(By.xpath("//a[@class='woocommerce-LoopProduct-link']//img"));
	   for(WebElement item:popularItemLists)
	   {
		   String act_title=item.getAttribute("title");
		   if((act_title.equals(exp_title1))||(act_title.equals(exp_title2))||(act_title.equals(exp_title3))||(act_title.equals(exp_title4))||(act_title.equals(exp_title5))||(act_title.equals(exp_title6))||
				   (act_title.equals(exp_title7))||(act_title.equals(exp_title8)))
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
   public boolean verifyingURL(String exp_url)
   {
	  String act_url= driver.getCurrentUrl();
	  System.out.println(act_url);
	  if(act_url.equals(exp_url))
	  {
		  return true;
	  }
	  else
	  {
		  return false;
	  }
   }
  
   public void gettingItemPriceAfterSelectingOptionFromDropDown()
   {
	   
	   List<WebElement>itemPriceList=driver.findElements(By.xpath("//span[@class='price']//span[@class='woocommerce-Price-amount amount']"));
	   for(WebElement price:itemPriceList)
	   {
		  String act_price= price.getText();
		  System.out.println(act_price);
		  String strprice=act_price.replaceAll("[^0-9.]", "");
		  System.out.println(strprice);
		  double double_price=Double.parseDouble(strprice);
		  originalList1.add(double_price);
		  System.out.println(originalList1);
		  sortedList1.add(double_price);
		  System.out.println(sortedList1);
		    
	  }

   }   
   
   public boolean removingOldPriceOfTheSaleProductForHighToLowSorting() 
	  { 
	      boolean flag=false;
	      
	      originalList1.remove(1);
	      originalList1.remove(1);
	      System.out.println(originalList1);
	      sortedList1.remove(1);
	      sortedList1.remove(1);
	      System.out.println(sortedList1);
	      
		  Collections.sort(sortedList1,Collections.reverseOrder());
		  System.out.println(sortedList1);
		  
		  if(originalList1.equals(sortedList1))
		  {
			  flag=true;
		  }
		  else
		  {
			  flag=false;
		  }
	  
	   return flag;
 }
   
   public boolean removingOldPriceOfTheSaleProductForLowToHighSorting()
   {
	   boolean flag=false;
	      
	      originalList1.remove(5);
	      originalList1.remove(6);
	      System.out.println(originalList1);
	      sortedList1.remove(5);
	      sortedList1.remove(6);
	      System.out.println(sortedList1);
	      
	      Collections.sort(sortedList1);
	      System.out.println(sortedList1);
	      
	      if(originalList1.equals(sortedList1))
		  {
			  flag=true;
		  }
		  else
		  {
			  flag=false;
		  }
	  
	   return flag;
	      
	      
   }
   
   public void clickOnReadMoreBtn()
   {
	   readMoreBtn.click();
   }
   
   public void clickOnSaleBook(String exp_title, String exp_text)
   {  
	   boolean flag=false;
	   List<WebElement>bookList= driver.findElements(By.xpath("//a[@class='woocommerce-LoopProduct-link']//img"));
	   for(WebElement book:bookList)
	   {
		   String act_title=book.getAttribute("title");
		   System.out.println(act_title);
		   if(act_title.equals(exp_title))
		   {
			  List<WebElement>span_textlist= driver.findElements(By.xpath("//a[@class='woocommerce-LoopProduct-link']//img//parent::a//span"));
			  for(WebElement ele:span_textlist)
			  {
				 String act_text= ele.getText();
				 System.out.println(act_text);
				 if(act_text.equals(exp_text))
				 {
					 book.click();
					 flag=true;
					 break;
				 }
				 else
				 {
					 flag=false;
				 }
				 
			  }
			  
		   }
		   if(flag=true)
		   {
			   break;
		   }
	   }
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
   
   public void clickOnViewBasketBtn()
	{
		viewBasketBtn.click();
		
	}

}
   

