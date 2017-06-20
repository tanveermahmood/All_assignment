package com.flipcart1.Page;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;



public class FlipkartTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "span.span")
	private QAFWebElement spanSpan;
	@FindBy(locator = "img.great.deals")
	private QAFWebElement imgGreatDeals;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	driver.get("/");
	}
	
	

	public QAFWebElement getSpanSpan() {
		return spanSpan;
	}

	public QAFWebElement getImgGreatDeals() {
		return imgGreatDeals;
	}
	
	
}
