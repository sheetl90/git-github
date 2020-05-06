package com.test.jellyfish;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.generic.jellyFish.BaseLib;
import com.generic.jellyFish.Utility;
import com.pom.jellyFish.Retail_LoginPage;

public class LoginTest extends BaseLib
{
  Retail_LoginPage login;
  
 @Test(dataProvider = "Registration",dataProviderClass = BaseLib.class)
 public void retail_login(String email,String pass) throws AWTException
 {
	 login=new Retail_LoginPage(driver);
	 Utility.keyboard_activity();
	 Utility.waitTillPageLoad(5);
	 logger.log(Status.INFO,"Enter the email");
	 login.enter_email().sendKeys(email);
	 logger.log(Status.PASS,"It should accept the email");
	 logger.log(Status.INFO,"Enter the password");
	 login.enter_password().sendKeys(pass);
	 logger.log(Status.PASS,"It should accept the password");
	 logger.log(Status.INFO,"Click on the Login button");
	 login.clk_login().click();
	 logger.log(Status.PASS,"Welcome to the retailer Dahsboard");
 }
}
