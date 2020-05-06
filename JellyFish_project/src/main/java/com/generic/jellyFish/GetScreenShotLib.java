package com.generic.jellyFish;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class GetScreenShotLib
{
	 public static String capture(WebDriver driver,String screenshotname)
	   {
		   String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		  
			  TakesScreenshot ts = (TakesScreenshot) driver;
			    File source = ts.getScreenshotAs(OutputType.FILE);
			    
			     String path=System.getProperty("user.dir")+"/screenShot/"+screenshotname+dateName+".jpeg";
			      File destination= new File(path);
			      try
			 {   
			 
		      FileHandler.copy(source, destination);
		    
			  }
		   
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		return path;
		
		
		   
	   }
}
