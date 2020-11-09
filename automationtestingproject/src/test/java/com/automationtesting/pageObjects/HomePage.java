package com.automationtesting.pageObjects;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	
	public WebDriver ldriver;
	
	public HomePage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	//locators
	
	@FindBy(xpath="//a[contains(text(),'Shop')]")
	@CacheLookup
	WebElement shopBtn;
	
	@FindBy(xpath="//a[contains(text(),'Home')]")
	@CacheLookup
	WebElement homeBtn;
	
	@FindBy(tagName="img")
	@CacheLookup
	List<WebElement> imglist;
	
	@FindBy(xpath="//a[@class='woocommerce-LoopProduct-link']//h3")
	@CacheLookup
	List<WebElement> imgtexts;
	
	@FindBy(xpath="//a[@class='woocommerce-LoopProduct-link']//img")
	@CacheLookup
	List<WebElement> arrivalImges;

	@FindBy(xpath="//a[@class='woocommerce-LoopProduct-link']//img[@title='Selenium Ruby']")
	@CacheLookup
	WebElement arrivalImg;

	@FindBy(xpath="//img[@title='Mastering JavaScript']")
	@CacheLookup
	WebElement mijavaImg;
	
	@FindBy(xpath="//a[contains(text(),'My Account')]")
	@CacheLookup
	WebElement myAccounLink;
	
	
	//actions
	
    public void clickOnShopBtn()
    {
    	shopBtn.click();
    }
	
    public void clickOnHomeBtn()
    {
    	homeBtn.click();
    }
    
    public void clickOnArrivalsImg() 
    {
    	arrivalImg.click();
    	
    }
    
    public boolean slidersPresentInHomePage(String slider1, String slider2, String slider3, int sliderno)
    {  
    	 boolean flag=false;
    	 int slider=0;
		    for(WebElement img:imglist)
		    {
		    	String act_alt=img.getAttribute("alt");
		    	if(act_alt.equals(slider1)||act_alt.equals(slider2)||act_alt.equals(slider3))
		    	{
		    		slider=slider+1;
		            
		    	}
		    }
		    
		    if(slider==sliderno)
		    {
		    	flag=true;
		    }
		    else
		    {
		    	flag=false;
		    }
    	   
		return flag;
    	
    }
    
    public boolean arrivalsPresentInHomePage(String arrival1, String arrival2, String arrival3, int arrivalno)
    {   
    	int arrival=0;
    	boolean flag=false;
		  for(WebElement ele:imgtexts)
		  {
			  String act_text=ele.getText();
			  if(act_text.equals(arrival1)||act_text.equals(arrival2)||act_text.equals(arrival3))
			  {
				 arrival=arrival+1; 
			  }
		  }
		  
		  if(arrival==arrivalno)
		  {
			  flag=true;
		  }
		  else
		  {
			 flag=false;
		  }
    	
        return flag;
    	
    }
    
    public boolean isImgClickable()
    {   boolean flag=false;
    	for(WebElement img:arrivalImges)
    	{
    		boolean b1=img.isEnabled();
    		if(b1==true)
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
    
    public boolean arrivalImgesNavigatingToNextPage(String exp_title1, String exp_title2, String exp_title3) throws InterruptedException
    {  
    	boolean flag=true;
    	List<WebElement>arrivalsImages = ldriver.findElements(By.xpath("//a[@class='woocommerce-LoopProduct-link']//img"));
        int imageCount=arrivalsImages.size();
        
		for(int count=0; count<imageCount; count++)
		{  
			arrivalsImages= ldriver.findElements(By.xpath("//a[@class='woocommerce-LoopProduct-link']//img"));
			WebElement img = arrivalsImages.get(count);
			img.click();
			Thread.sleep(3000);
			String act_title=ldriver.findElement(By.xpath("//img[@class='attachment-shop_single size-shop_single wp-post-image']")).getAttribute("title");
			Thread.sleep(3000);
			if(act_title.equals(exp_title1)||act_title.equals(exp_title2)||act_title.equals(exp_title3))
			{  
				boolean b1=ldriver.findElement(By.xpath("//button[@class='single_add_to_cart_button button alt']")).isEnabled();
				Thread.sleep(4000);
				if(b1==true)
				{
					flag=true;
				}
				else
				{
					flag=false;
				}
			}
			ldriver.navigate().back();
		}
		
		return flag;
	}
    
    public void clickOnMasteringInJavaImg()
    {
    	mijavaImg.click();
    }
       
    public void clickOnMyAccountLink()	
    {
    	myAccounLink.click();
    }
    
//    public void adjustingFilterByPrice() throws InterruptedException
//    {   
//    	Actions act=new Actions(ldriver);
//    	act.dragAndDropBy(slider, 850, 0).perform();
//    	Thread.sleep(2000);
//    	filterBtn.click();
//    	Thread.sleep(3000);	
//    }
//    
//    public boolean verifyingBooksWithTitle(String title1, String title2)
//    {  
//    	boolean flag=false;
//    	List<WebElement>booklist=ldriver.findElements(By.xpath("//li//a[@class='woocommerce-LoopProduct-link']//img"));
//    	System.out.println(booklist.size());
//    	for(WebElement book:booklist)
//    	{
//    		String booktitle=book.getAttribute("title");
//    		System.out.println(booktitle);
//    		if((booktitle.equals(title1))||(booktitle.equals(title2)))
//    		{
//    			   flag= true;
//    			
//    		}
//    		else
//    		{
//    			   flag= false;
//    			
//    		}
//    		
//    	}
//    	 return flag;		
//    }		
//    			
//    			
//    			
//    public boolean verifyingBookPriceBetween150To450(double exp_price1, double exp_price2)			
//    			
//    {	boolean flag1=false;
//    			
//    			List<WebElement>ele= ldriver.findElements(By.xpath("//span[@class='price']//span[@class='woocommerce-Price-amount amount']"));
//    			System.out.println(ele.size());
//    			 for(WebElement price:ele)
//    			    {  
//    			       String priceText=price.getText();
//    		           System.out.println(priceText);
//    			       String act_price=priceText.replaceAll("[^0-9.]", "");
//    		    	   System.out.println(act_price);
//    		    	   double double_price=Double.parseDouble(act_price);
//    		    	   if((double_price>=exp_price1)&&(double_price<=exp_price2))
//    		    	   {
//    		    		flag1= true;
//    		    	   }
//    		    	   else
//    		    	   {
//    		    		flag1=false;
//    		    	   }
//    		      
//    			     }
//    			    
//    		 return flag1;
//    			    
//    		}
//    public void clickOnProductLink()
//    {
//    	productLink.click();
//    }
//    	
//
//   public boolean verifyingJavaScriptRelatedProduct(String exp_title1, String exp_title2, String exp_title3)
//   {  
//	   boolean flag=false;
//	  List<WebElement>bookList= ldriver.findElements(By.xpath("//a//img[@class='attachment-shop_catalog size-shop_catalog wp-post-image']"));
//      for(WebElement ele:bookList)
//      {
//    	String act_title= ele.getAttribute("title");
//    	if((act_title.equals(exp_title1))||(act_title.equals(exp_title2))||(act_title.equals(exp_title3)))
//    	{
//    		
//    		flag=true;
//    	}
//    	else
//    	{
//    		flag=false;
//    	}
//    	
//      }
//      return flag;
//   
//   }
//   
//   public void clickOnDefaultDropDown(String exp_string )
//   {
//	   ldriver.findElement(By.xpath("//select[contains(@name,'orderby')]")).click();
//	   Select select =new Select(dropdownBtn);
//	   System.out.println(select.getOptions().size());
//	   select.selectByVisibleText(exp_string);
//   }
//   
//   public boolean verifyingPopularItemsInHomePage(String exp_title1, String exp_title2, String exp_title3, String exp_title4,
//		   String exp_title5, String exp_title6, String exp_title7, String exp_title8)
//   {
//	   boolean flag=false;
//	   List<WebElement>popularItemLists=ldriver.findElements(By.xpath("//a[@class='woocommerce-LoopProduct-link']//img"));
//	   for(WebElement item:popularItemLists)
//	   {
//		   String act_title=item.getAttribute("title");
//		   if((act_title.equals(exp_title1))||(act_title.equals(exp_title2))||(act_title.equals(exp_title3))||(act_title.equals(exp_title4))||(act_title.equals(exp_title5))||(act_title.equals(exp_title6))||
//				   (act_title.equals(exp_title7))||(act_title.equals(exp_title8)))
//		   {
//			   flag= true;
//		   }
//		   else
//		   {
//			   flag= false;
//		   }
//	   }
//	   return flag;
//   }
//   
//   public void clickOnReadMoreBtn()
//   {
//	   readMoreBtn.click();
//   }
//   
   
}
   
	  
   
  
  
    

   


