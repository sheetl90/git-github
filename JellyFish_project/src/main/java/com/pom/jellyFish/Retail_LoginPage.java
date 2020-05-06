package com.pom.jellyFish;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Retail_LoginPage 
{
  public Retail_LoginPage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }
  
  
  @FindBy(xpath = "//input[@type='text']")
  private WebElement enter_email;
  
  @FindBy(xpath = "//input[@name='password']")
  private WebElement enter_password;
  
  @FindBy(xpath = "//span[text()='Log In']")
  private WebElement clk_login;
  
  
  
  public WebElement enter_email()
  {
	return enter_email;
	  
  }
  
  public WebElement enter_password()
  {
	return enter_password;
	  
  }
  
  public WebElement clk_login()
  {
	return clk_login;
	  
  }
  
}
