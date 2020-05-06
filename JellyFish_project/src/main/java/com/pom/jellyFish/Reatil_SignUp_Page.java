package com.pom.jellyFish;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.generic.jellyFish.BaseLib;
import com.generic.jellyFish.Utility;
import com.mongodb.diagnostics.logging.Logger;
import com.relevantcodes.extentreports.LogStatus;

public class Reatil_SignUp_Page 	
{
 
	public Reatil_SignUp_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Declaration of the webElement
	@FindBy(xpath = "//p[text()=\"Please log in to proceed\"]")
	private WebElement jellyfish_logologin_text;
	
	@FindBy(xpath="(//span[text()=' Sign Up'])[1]")
	private WebElement sign_up_button;
	
	@FindBy(xpath ="(//h3[contains(text(),'Sign Up')])[2]")
	private WebElement sign_up_text;
	
	@FindBy(xpath = "(//input[@type='text'])[2]")
	private WebElement enter_firstname;
	
	@FindBy(xpath ="(//input[@class='text-input text-input-md'])[4]")
	private WebElement enter_lastname;
	
	@FindBy(xpath ="(//input[@class='text-input text-input-md'])[5]")
	private WebElement enter_emailid;
	
	@FindBy(xpath ="(//input[@class='text-input text-input-md'])[6]")
	private WebElement enter_pass;
	
	@FindBy(xpath = "(//input[@class='text-input text-input-md'])[7]")
	private WebElement enter_cpass;
	
	@FindBy(xpath = "//div[@class='checkbox-icon']")
	private WebElement clk_chkbox;
	
	@FindBy(xpath = "//span[text()='Proceed']")
	private WebElement clk_proceed;
	


	
public WebElement clk_on_signUp()
{
	return sign_up_button;
	
}
	
public WebElement get_firstname()
{
	return enter_firstname;
	
}

public WebElement get_lastname()
{
	return enter_lastname;
	
}

public WebElement get_email()
{
	return enter_emailid;
	
}

public WebElement get_password()
{
	return enter_pass;
	
}


public WebElement get_confirm_passowrd()
{
	return enter_cpass;
	
}

public WebElement clk_termandcondition()
{
	return clk_chkbox;
}

public WebElement clk_proceed()
{
	return clk_proceed;
}


}
