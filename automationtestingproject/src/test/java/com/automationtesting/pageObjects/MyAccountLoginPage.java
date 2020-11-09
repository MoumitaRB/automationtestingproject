package com.automationtesting.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MyAccountLoginPage {
	
	public WebDriver driver;
	
	
   public MyAccountLoginPage(WebDriver driver)
   {
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
   }
   
   //locators
   
   @FindBy(id="username")
   @CacheLookup
   WebElement txtUserName;
   
   @FindBy(id="password")
   @CacheLookup
   WebElement txtPassword;
   
   @FindBy(xpath="//input[@name='login']")
   @CacheLookup
   WebElement loginBtn;
   
   @FindBy(xpath="//li[contains(text(),'A user could not be found with this email address.')]")
   @CacheLookup
   WebElement errorMsg1;
   
   @FindBy(xpath="//li[contains(text(),'Password is required.')]")
   @CacheLookup
   WebElement errorMsg2;
   
   @FindBy(xpath="//li[contains(text(),'Username is required.')]")
   @CacheLookup
   WebElement unErrorMsg;
   
   @FindBy(xpath="//div[@id='body']//li[1]")
   @CacheLookup
   WebElement caseChangedErrorMSg;
   
   //actions
   
   public void setUserName(String uname)
   {
	   txtUserName.clear();
	   txtUserName.sendKeys(uname);
   }
   
   public void setPassWord(String password)
   {
	   txtPassword.clear();
	   txtPassword.sendKeys(password);
   }
   
   public void clickOnLoginBtn()
   {
	   loginBtn.click();
   }
   
   public boolean verifyingSuccessfullyLoginToWebPage(String exp_title)
   {
	   String act_title=driver.getTitle();
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
   
   public boolean verifyingProperErrorMsg(String exp_errorMsg)
   {
	   String act_errorMsg=errorMsg1.getText();
	   System.out.println(act_errorMsg);
	   if(act_errorMsg.equals(exp_errorMsg))
	   {   
		   return true;
	   }
	   else
	   {  
		    return false;
		  
	   }
	
   }
   
   
   public boolean verifyingPromptToEnterLoginAgain(String exp_errorMsg) throws InterruptedException
   {
	  boolean flag=false;
	  boolean displayStatus=driver.findElement(By.xpath("//input[@name='login']")).isDisplayed();
	  boolean enableStatus=driver.findElement(By.xpath("//input[@name='login']")).isEnabled();
      if((displayStatus==true)&&(enableStatus==true))
      {
    	 driver.findElement(By.xpath("//input[@name='login']")).click();
	     Thread.sleep(3000);
	     String errorMsg= driver.findElement(By.xpath("//li[contains(text(),'Password is required.')]")).getText();
	     System.out.println(errorMsg);
	        if(errorMsg.equals(exp_errorMsg))
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
   
   public void promptToLoginAgain()
   {   
	   boolean b1=driver.findElement(By.xpath("//input[@name='login']")).isEnabled();
	   if(b1==true)
	   {
		   driver.findElement(By.xpath("//input[@name='login']")).click();
	   }
	   
   }
   
   public boolean verifyingProperErrorMsgLoginWithOutPassword(String exp_errorMsg)
   {
	  String act_errorMsg= errorMsg2.getText();
	  System.out.println(act_errorMsg);
	  if(act_errorMsg.equals(exp_errorMsg))
	  {
		  return true;
	  }
	  else
	  {
		  return false;
	  }
   }
   
   public boolean verifyingProperErrorMsgLoginWithValidPasswordAndEmptyUserName(String exp_errorMsg)
   {
	   String act_errorMsg=unErrorMsg.getText();
	   if(act_errorMsg.equals(exp_errorMsg))
	   {
		   return true;
	   }
	   else
	   {
		   return false;
	   }
   }
   
   public boolean verifyingPasswordCharactersVisibleInAsterisks(String pwd, String exp_pwdType) throws InterruptedException
   {   
	   txtPassword.sendKeys(pwd);
	   Thread.sleep(3000);
	   String pw=driver.findElement(By.id("password")).getAttribute("value");
	   System.out.println(pw);
       String pwdType=txtPassword.getAttribute("type");
       if(pwdType.equals(exp_pwdType))
       {
    	   return true;
       }
       else
       {
    	   return false;
       }
   }
   
   public boolean verifyingProperErrorMsgLoginWithCaseChangedUserNameAndPassword(String exp_errorMsg)
   {
	  String act_errorMsg= caseChangedErrorMSg.getText();
	  System.out.println(act_errorMsg);
	  if(act_errorMsg.equals(exp_errorMsg))
	  {
		  return true;
	  }
	  else
	  {
		  return false;
	  }
   }
   
   public boolean verifyingMyAccountLoginPageTitle(String exp_title)
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
}
