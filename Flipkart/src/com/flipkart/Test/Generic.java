package com.flipkart.Test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class Generic {
	WebDriver driver;
	// wait for given time
	public void kw_synchronize(int value) throws InterruptedException
	{
		Thread.sleep(value);
	}

	// close the current browser
	
	public void kw_close()
	{
		driver.close();
	}

	// maximize the window
	
	public void kw_maximize()
	{
		driver.manage().window().maximize();
	}

	//entering text in a text field
	
	public void kw_enter_text(QAFWebElement element,String text) 
	{
		element.sendKeys(text);
	}
	
	public void kw_enter_text1(QAFWebElement element,String text) 
	{
		element.sendKeys(text,Keys.ARROW_DOWN,Keys.ENTER);
		
	}
	
	// click button
	
	public void kw_click_link(QAFWebElement element)
	{
		element.click();
	}

	//move to an element
	
	public void kw_moveToElement(QAFWebElement element)
	{
	   Actions action = new Actions(driver);
	   action.moveToElement(element).click().build().perform();
	}
   //selecting the element from dropdown
	
	public void kw_dropdown(QAFWebElement ele,int index)
	{
		Select sel=new Select(ele);
		sel.selectByIndex(index);
	}
	
	//validating the string
	
	public void kw_validate(QAFWebElement expected,QAFWebElement actual)
	{
		boolean booleanvalue = expected.equals(actual);
		if(booleanvalue==false)
		{
			System.out.println("expected string"+expected+"Not matching actual string"+actual+"");
	}
		else
		{
			System.out.println("expected string"+expected+"Matching actual string"+actual+"");
	}
	}
//validatig the page title
		
	public void kw_validate_title(String exp_Title)
	{
		String actualtitle =driver.getTitle();
		if(exp_Title.equals(actualtitle))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("false");
		}
	}
	// handling popup windows
	
	public void kw_alertPopup()
	{
		Alert al = driver.switchTo().alert();
		al.accept();
	}
}
