package com.generic.jellyFish;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseLib
{
	 public static WebDriver driver; 

	   FileInputStream fis;
	   File file;
	   Properties p;
	   public static ExtentHtmlReporter extent;
	   public static ExtentReports report;
	   public static ExtentTest logger;
	   //this a test comment
	   
	 @BeforeSuite
	 public void setSuiteUp()
	 {
		 Reporter.log("setting up Reports and Test started",true);
		 String workingDir = System.getProperty("user.dir");
		 extent = new ExtentHtmlReporter(workingDir + "/Report/ExtentReportResults.html");
		 
		 extent.config().setDocumentTitle("Automation Report"); // Tile of report
		 extent.config().setReportName("Functional Testing"); // Name of the report
		 extent.config().setTheme(Theme.DARK);
		 report=new ExtentReports();
		 report.attachReporter(extent);
		logger= report.createTest("Jelly_fish");
		 
		 Reporter.log("Setting Done--Test Cases",true);
		 
	 }
	   
	   @BeforeMethod
	   @Parameters(value="browser")
	   
	   public void preCondition(String browser) throws IOException, AWTException
	   {
		   file=new File(System.getProperty("user.dir")+"/object_repository.properties");
		   fis= new FileInputStream(file);
		   p= new Properties();
		   p.load(fis); 
		   
		  if(browser.equalsIgnoreCase("firefox"))
		  {
			 
			  System.setProperty("webdriver.gecko.driver",new File(System.getProperty("user.dir"))+"/exeFiles/geckodriver.exe");
			  driver= new FirefoxDriver();
			  String u = p.getProperty("url");
			  driver.get(u);
			  String title = driver.getTitle();
			  System.out.println(title);
			  String url = driver.getCurrentUrl();
			  System.out.println(url);
		
		  } 
			  
		  else
			  {
				 
				  
				System.setProperty("webdriver.chrome.driver",new File(System.getProperty("user.dir"))+"/exeFiles/chromedriver.exe");
				driver=new ChromeDriver();
			    driver.manage().window().maximize();
				String u = p.getProperty("url");
				
				System.out.println(u);
				driver.get(u);
				String title = driver.getTitle();
				System.out.println(title);
				 
				String url = driver.getCurrentUrl();
			    System.out.println(url);
			  }
			
			 
			  
			  
		  }
	   
	   
	   @AfterMethod
	   public void postCondition(ITestResult r) throws IOException
	   {
		   Reporter.log("The Test is about to end",true);
		   if(r.getStatus()==ITestResult.FAILURE)
		   {
			   
			   logger.log(Status.FAIL, "TEST CASE FAILED IS " + r.getName()); // to add name in extent report
			   logger.log(Status.FAIL, "TEST CASE FAILED IS " + r.getThrowable()); // to add error/exception in extent
			   String screenShotpath = GetScreenShotLib.capture(driver, r.getName().toString());
			  logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(screenShotpath).build());
			 
			   
			       
	     }
		   else if(r.getStatus()==ITestResult.SKIP)
		   {
			   
			   logger.log(Status.SKIP, "TEST CASE SKIPED IS " + r.getName()); // to add name in extent report
			   logger.log(Status.SKIP, "TEST CASE SKIPED IS " + r.getThrowable()); // to add error/exception in extent
			   String screenShotpath = GetScreenShotLib.capture(driver, r.getName().toString());
			   logger.skip("Test skipped",MediaEntityBuilder.createScreenCaptureFromPath(GetScreenShotLib.capture(driver,screenShotpath)).build());
			   
		   }
		   
		   else if(r.getStatus() == ITestResult.SUCCESS)
		   {
			   logger.log(Status.PASS, "Test Case PASSED IS " + r.getName());
		 
	      }
		  
		   report.flush();
	   }
	   
	  //@DataProvider(name = "Login")
	 // public Object[][] getTestData() throws EncryptedDocumentException, IOException
	  // {
	  //		Object data[][] = ExcelLib.getExceldata("Sheet4");
	  	//	return data;
	 // }
	   
	   @DataProvider(name = "Registration")
	   public Object[][] getRegistrationData() throws EncryptedDocumentException, IOException
	   
	  {
		  Object data[][] = ExcelLib.getExceldata("Sheet1");
		   
		 return data;
		   
	  }
}
