package com.flipkart_day3.step;

import org.testng.annotations.Test;

import com.flipkart_day3.page.FlipkarthomeTestPage;
import com.flipkart_day3.page.SearchresultTestPage;
import com.flipkart_day3.page.SelectproductTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class FlipkartTestSteps extends WebDriverTestCase {

	@Test(groups = { "P1", "P2", "SMOKE" }, description = "test")
	public void search() {
	
		
		FlipkarthomeTestPage FlipkarthomeTestPage = new FlipkarthomeTestPage();
		FlipkarthomeTestPage.launchPage(null);
		FlipkarthomeTestPage.selectCatogory("Electronics", "Apple");
		FlipkarthomeTestPage.verifyHomePage();
		SelectproductTestPage SelectproductTestPage = new SelectproductTestPage();
		SelectproductTestPage.selectProduct("iPad");
		SelectproductTestPage.verifyProduct();
		SearchresultTestPage SearchresultTestPage = new SearchresultTestPage();
		SearchresultTestPage.verifySearchResultPage();
//		SearchresultTestPage.selectlowToHighTab();
//		SearchresultTestPage.selectLowestAmountIpad();
		
		String product=SearchresultTestPage.getLeastPriceProductName();
		System.out.println("Min priced product :    "+product);
	}

}