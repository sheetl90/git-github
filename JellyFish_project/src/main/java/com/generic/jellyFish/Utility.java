package com.generic.jellyFish;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility extends BaseLib
{
	public static Select sel;	
	 public static Actions builder;
	 public static WebDriverWait wait ;
	 static File file;
	 static FileReader file_reader;
	 static FileWriter fileWrite;
	 static BufferedWriter bwrite;
	 
	 
	   public static void selectElementByvalueMethod(WebElement ele,String value)
	   {
		   sel=new Select(ele);
		  sel.selectByValue(value);
	   }
	   
	   public static void selectElementByIndexMethod(WebElement element, int index)
	   {
		 sel= new Select(element);
		 sel.selectByIndex(index);
	   }
	   
	   public static void selectElementByNameMethod(WebElement element, String Name)
	   {
		    sel = new Select(element);
		   sel.selectByVisibleText(Name);
	   }
	   
	   public static void hover_on(WebElement ele)
	   {
		   builder = new Actions(driver);
		   builder.moveToElement(ele).perform();
	   }
	   
	   public static void dragAndDrop(WebElement fromWebElement,WebElement toWebElement)
	   {
			    builder = new Actions(driver);
			   builder.dragAndDrop(fromWebElement, toWebElement);
			   
			   }

	   public static void dragAndDrop_Method2(WebElement fromWebElement,WebElement toWebElement)
	   {
			   builder = new Actions(driver);
			   Action dragAndDrop = builder.clickAndHold(fromWebElement)
			   .moveToElement(toWebElement).release(toWebElement).build();
			   dragAndDrop.perform();
			   
			   }

	   public static void dragAndDrop_Method3(WebElement fromWebElement, WebElement toWebElement) throws InterruptedException
		{
			    builder = new Actions(driver);
			   builder.clickAndHold(fromWebElement).moveToElement(toWebElement).perform();
			   Thread.sleep(2000);
			   builder.release(toWebElement).build().perform();
			   
	    }
	   
	   public static void checkbox_checking(WebElement ele)
	   {
		   boolean checkbox_status;
		   checkbox_status=ele.isSelected();
		   if(checkbox_status==true)
		   {
			   System.out.println("checkbox is already selected");
	      }
		   else
		   {
			   ele.click();
			   System.out.println("Checked the checkbox");
		   }
		   
	   }
	   public static void radiobutton_Select(WebElement Radio) 
	   {
		   boolean checkstatus;
		   checkstatus = Radio.isSelected();
		   if (checkstatus == true)
		   {
		   System.out.println("RadioButton is already checked");
		   }
		   else 
		   {
		   Radio.click();
		   System.out.println("Selected the Radiobutton");
		   }
	    }
	   
	   public static void checkbox_Unchecking(WebElement checkbox)
	   {
		   boolean checkstatus;
		   checkstatus = checkbox.isSelected();
		   if (checkstatus == true)
		   {
		   checkbox.click();
		   System.out.println("Checkbox is unchecked");
		   } 
		   else
		   {
		   System.out.println("Checkbox is already unchecked");
		   }
	 }
	   
	   public static void radioButton_Deselect(WebElement Radio)
	   {
		   boolean checkstatus;
		   checkstatus = Radio.isSelected();
		   if (checkstatus == true) 
		   {
		   Radio.click();
		   System.out.println("Radio Button is deselected");
		   }
		   else 
		   {
		   System.out.println("Radio Button was already Deselected");
		   }
		   }
	   
	   public static boolean checkAlert_Accept()
	   {
		   try
		   {
		   Alert a = driver.switchTo().alert();
		   String str = a.getText();
		   System.out.println(str);

		   a.accept();
		   return true;

		   } 
		   catch (Exception e)
		   {

		   System.out.println("No alert found");
		   return false;

		   }
	  }
	   
	   public static boolean checkAlert_Dismiss()
	   {
		   try
		   {
		   Alert a = driver.switchTo().alert();
		   String str = a.getText();
		   System.out.println(str);

		   a.dismiss();
		   return true;

		   }
		   catch (Exception e) 
		   {

		   System.out.println("No alert found");
		   return false;

		   }
		   }
	   
	   public static void switch_tonew_window()
	   {
		   String defaultWindow = driver.getWindowHandle();
		   System.out.println("Default window name is- " +defaultWindow);
		   Set<String> childWindows = driver.getWindowHandles();
		   for(String child : childWindows)
		   {
		  		  
		  		  if(!child.equalsIgnoreCase(defaultWindow))
		  		  {
		  			  driver.switchTo().window(child);
		  			  System.out.println("Child windows- "+child);
		  			  driver.close();
		  			  driver.switchTo().window(defaultWindow);
		  		  }
		  		  
		  		  else 
		  		  {
		  			  System.out.println("There are no child windows");
		  		  }
		  		  
		  		  
		  	  }
		  }
	   
	   public static void switch_totabs()
	   {
		   Set<String> childWindows = driver.getWindowHandles();
		   ArrayList<String> newTab = new ArrayList<String>(childWindows);
		   System.out.println(newTab.size());
		   driver.switchTo().window(newTab.get(1));
		   
	   }
	   
	   public static void waitForElement(WebElement element)
	   {

		   WebDriverWait wait = new WebDriverWait(driver, 10);
		   wait.until(ExpectedConditions.elementToBeClickable(element));
	   }
	   
	   
	   public static void waitTillElementFound(WebElement ElementTobeFound,int seconds)
	   {
			 wait = new WebDriverWait(driver, seconds);
			   wait.until(ExpectedConditions.visibilityOf(ElementTobeFound));
	  }
	   
	   public static void page_load(String title)
	   {
		   WebDriverWait wait = new WebDriverWait(driver, 20); //you can play with the time integer  to wait for longer than 15 seconds.`
		   wait.until(ExpectedConditions.titleContains(title));
	   }
	   
	 
	   
	   public static void waitTillPageLoad(int i)
	   {

		   driver.manage().timeouts().implicitlyWait(i,TimeUnit.SECONDS);

	 }
	   
	   public static void cookies_handling()
	   {
		   file=new File("Cookies.data");
		  try
		  {
		  
		   file.delete();
		   file.createNewFile();
		   fileWrite = new FileWriter(file);
		   bwrite = new BufferedWriter(fileWrite);
		   for(Cookie ck : driver.manage().getCookies())
			   
		   {
			  bwrite.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure())); 
			  bwrite.newLine();
		   }
		   
		   bwrite.close();
		   fileWrite.close();
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
	   }
	   
	   public static void keyboard_activity() throws AWTException
	   {
		   Robot r=new Robot();
		   r.keyPress(KeyEvent.VK_TAB);
		   r.keyPress(KeyEvent.VK_ENTER);
			   
	   }
	   
	   
}
