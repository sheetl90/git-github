package com.test.jellyfish;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.generic.jellyFish.BaseLib;
import com.generic.jellyFish.Utility;
import com.pom.jellyFish.Reatil_SignUp_Page;

public class Retail_OnBoarding extends BaseLib
{
	Reatil_SignUp_Page retail;
	
@Test(dataProvider="Registration",dataProviderClass=BaseLib.class)
public void signUp_test(String fname,String lname,String email_d,String password,String c_password) throws AWTException
{
     retail=new Reatil_SignUp_Page(driver);
      Utility.keyboard_activity();
     logger.log(Status.PASS,"Login Page verified Successfully");
	logger.log(Status.INFO,"click on the SignUp button on the Login Page");
	JavascriptExecutor script=(JavascriptExecutor) driver;
	
	Utility.waitTillElementFound(retail.clk_on_signUp(),10);
	retail.clk_on_signUp().click();
	logger.log(Status.PASS,"Sign Up button has been clicked");
	
	Utility.waitTillPageLoad(2000);

	logger.log(Status.PASS,"Welcome to the Retail SignUp Page");
	logger.log(Status.INFO,"Enter the First Name");
	retail.get_firstname().sendKeys(fname);
	logger.log(Status.PASS,"It should accept the First Name");
	
	logger.log(Status.INFO,"Enter the Last Name");
	retail.get_lastname().sendKeys(lname);
	logger.log(Status.PASS,"It should accept the last Name");
	
	logger.log(Status.INFO,"Enter the Email or Phone Number");
	retail.get_email().sendKeys(email_d);
	logger.log(Status.PASS,"It should accept the Email or phone number");
	
	logger.log(Status.INFO,"Enter the Passowrd");
	retail.get_password().sendKeys(password);
	logger.log(Status.PASS,"It should accept the password");
	
	logger.log(Status.INFO,"Enter the confirm Passowrd");
	retail.get_confirm_passowrd().sendKeys(c_password);
	logger.log(Status.PASS,"It should accept the confirm password");
	
	logger.log(Status.INFO, "Click on the terms and condition button");
	script.executeScript("arguments[0].click();",retail.clk_termandcondition());
	//retail.clk_termandcondition().click();
	logger.log(Status.PASS, "It should click the checkbox");
	
	logger.log(Status.INFO, "Click on the proceed button");
	retail.clk_proceed().click();
	logger.log(Status.PASS, "Welcome to the Retailer Dashboard");
	
		

}



}
