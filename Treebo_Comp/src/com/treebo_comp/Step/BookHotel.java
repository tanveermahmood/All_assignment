package com.treebo_comp.Step;

import org.testng.annotations.Test;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.treebo_comp.Page.HomeTestPage;
import com.treebo_comp.Page.SearchTestPage;

public class BookHotel extends WebDriverTestCase {
	
	@Test(groups = { "SMOKE" }, description = "book hotel")
	public void scenario1() 
	{
		HomeTestPage home = new HomeTestPage();
		home.launchPage(null);
		home.searchHotel();
		
		SearchTestPage searchTestPage = new SearchTestPage();
		searchTestPage.verifyProductList();
		searchTestPage.selectProductName(0);
}
}
