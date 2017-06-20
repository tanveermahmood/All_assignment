package com.flipkart_main.Page;

import org.hamcrest.Matchers;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CommandExecutor;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.CommandTracker;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.util.Validator;

import net.sf.antcontrib.antserver.Command;

public class FlipkarthomeTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	
	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
		driver.get("/");
		
	}

	 public void selectCatogory(String menuName,String subMenuName)
	  {
	   Actions actions = new Actions(driver);
	   QAFExtendedWebElement CatogoryElement=new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("Homepage.link.menu"), menuName));
	   actions.moveToElement(CatogoryElement);
	   CatogoryElement.click();
	   QAFExtendedWebElement subCatogoryElement=new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("Homepage.link.submenu"), subMenuName));
	   subCatogoryElement.waitForVisible();
	   subCatogoryElement.click();
	   waitForPageToLoad();
	  }
	
	public void verifyHomePage()
	{
	Validator.verifyThat(driver.getTitle(), Matchers.containsString("Online Shopping Site for Mobiles,Fashion,Books,Electronics,Home Appliances & More @ Flipkart"));
	}
	
}

