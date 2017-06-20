package com.flipkart_mobile.step;

import org.testng.annotations.Test;

import com.flipkart_mobile.page.CategoryTestPage;
import com.flipkart_mobile.page.Flipkart_homeTestPage;
import com.flipkart_mobile.page.Product_resultTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class Flipkart_homeeststep extends WebDriverTestCase {
	
	Flipkart_homeTestPage Flipkart_homeTestPage = new Flipkart_homeTestPage();
	CategoryTestPage CategoryTestPage = new CategoryTestPage();
	Product_resultTestPage Product_resultTestPage = new Product_resultTestPage();

	@Test(description = "Add data")
	public void search() {
		
		
		Flipkart_homeTestPage.clickMenu();
		CategoryTestPage.selectCategory();
		Product_resultTestPage.selectProduct();
	}

}
