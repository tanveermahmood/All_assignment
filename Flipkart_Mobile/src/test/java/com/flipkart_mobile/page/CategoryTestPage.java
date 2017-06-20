package com.flipkart_mobile.page;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class CategoryTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "category.electronics.click")
	private QAFWebElement categoryElectronicsClick;
	@FindBy(locator = "subcategory.mobile.click")
	private QAFWebElement subcategoryMobileClick;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getCategoryElectronicsClick() {
		return categoryElectronicsClick;
	}

	public QAFWebElement getSubcategoryMobileClick() {
		return subcategoryMobileClick;
	}
	
	public void selectCategory()
	{
		getCategoryElectronicsClick().waitForVisible(50000);
		getCategoryElectronicsClick().click();
		
		getSubcategoryMobileClick().waitForEnabled();
		getSubcategoryMobileClick().click();
		//waitForPageToLoad();
	}

}
