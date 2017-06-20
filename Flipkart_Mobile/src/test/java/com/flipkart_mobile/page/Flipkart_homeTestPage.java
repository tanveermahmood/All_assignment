package com.flipkart_mobile.page;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class Flipkart_homeTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "FlipkartHome.menu.btn.click")
	private QAFWebElement flipkartHomeMenuBtnClick;
	
	@FindBy(locator = "skipbutton.click")
	private QAFWebElement skipbutton;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
		driver.get("/");
	}

	public QAFWebElement getFlipkartHomeMenuBtnClick() {
		return flipkartHomeMenuBtnClick;
	}
	
	public QAFWebElement clickSkipbutton() {
		return skipbutton;
	}
	
public void clickMenu()
{
	clickSkipbutton().click();
	getFlipkartHomeMenuBtnClick().waitForEnabled();
	getFlipkartHomeMenuBtnClick().click();
}
}
