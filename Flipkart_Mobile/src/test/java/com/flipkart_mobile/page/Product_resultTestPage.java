package com.flipkart_mobile.page;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class Product_resultTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "selectdevice.click")
	private QAFWebElement selectdeviceClick;
	@FindBy(locator = "selectsubdevice.click")
	private QAFWebElement selectsubdeviceClick;
	@FindBy(locator = "addTocart.click")
	private QAFWebElement addTocartClick;
	@FindBy(locator = "GoToCart.click")
	private QAFWebElement goToCartClick;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getSelectdeviceClick() {
		return selectdeviceClick;
	}

	public QAFWebElement getSelectsubdeviceClick() {
		return selectsubdeviceClick;
	}

	public QAFWebElement getAddTocartClick() {
		return addTocartClick;
	}

	public QAFWebElement getGoToCartClick() {
		return goToCartClick;
	}

	 public  void selectProduct()
	 {
	//	 getSelectdeviceClick().waitForEnabled();
		// waitForPageToLoad();
		 System.out.println("1");
		 getSelectdeviceClick().click();
		 System.out.println("2");
		 getSelectsubdeviceClick().waitForVisible();
		 getSelectsubdeviceClick().click();
		 System.out.println("1");
		 getAddTocartClick().waitForVisible();
		 getAddTocartClick().click();
		 getSelectsubdeviceClick().waitForVisible();
		 getGoToCartClick();
		 
		 
	 }
}
