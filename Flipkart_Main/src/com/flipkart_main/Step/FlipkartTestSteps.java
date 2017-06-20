package com.flipkart_main.Step;

import org.testng.annotations.Test;

import com.flipkart_main.Page.AddToCartPage;
import com.flipkart_main.Page.FlipkarthomeTestPage;
import com.flipkart_main.Page.ProductdetailTestPage;
import com.flipkart_main.Page.SearchresultTestPage;
import com.flipkart_main.Page.SearchresultTestPage1;
import com.flipkart_main.Page.SelectproductTestPage;
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
		
		/*SearchresultTestPage1 SearchresultTestPage1 = new SearchresultTestPage1();
		SearchresultTestPage1.verifySearchResultPage();
		String product=SearchresultTestPage1.getLeastPriceProductName();
		System.out.println("Min priced product :    "+product);
		*/

		SearchresultTestPage searchresultTestPage=new SearchresultTestPage();
		searchresultTestPage.verifyProductList();
		searchresultTestPage.selectProductName(0);
		

		ProductdetailTestPage productdetailTestPage=new ProductdetailTestPage();
		productdetailTestPage.verifyProductOnDetailPage();
		productdetailTestPage.selectAddtoCartButton();
		
		AddToCartPage addToCartPage=new AddToCartPage();
		addToCartPage.verifyProductOnAddToCartPage();
		
	}

}
