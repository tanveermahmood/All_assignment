/**
 * 
 */
package com.flipkart_main;

import com.flipkart_main.Page.AddToCartPage;
import com.flipkart_main.Page.FlipkarthomeTestPage;
import com.flipkart_main.Page.ProductdetailTestPage;
import com.flipkart_main.Page.SearchresultTestPage;
import com.flipkart_main.Page.SelectproductTestPage;
import com.qmetry.qaf.automation.step.QAFTestStep;

/**
 * @author tanveer.mahmood
 *
 */
public class StepsBackLog {
FlipkarthomeTestPage FlipkarthomeTestPage = new FlipkarthomeTestPage();
SelectproductTestPage SelectproductTestPage = new SelectproductTestPage();
SearchresultTestPage searchresultTestPage=new SearchresultTestPage();
ProductdetailTestPage productdetailTestPage=new ProductdetailTestPage();
	@QAFTestStep(description = "user opens flipkart application")
	public void userOpensFlipkartApplication() {
		
		FlipkarthomeTestPage.launchPage(null);
		FlipkarthomeTestPage.verifyHomePage();
	}
	@QAFTestStep(description = "user selects {0} from {1} catogory")
	public void userSelectsFromCatogory(String subMenuName, String menuName)
	{
		FlipkarthomeTestPage.selectCatogory(menuName, subMenuName);
	}
	
	@QAFTestStep(description = "user navigates to product catogory")
	public void userNavigatesToProductCatogory() 
	{
		SelectproductTestPage.verifyProduct();
	}
	
	@QAFTestStep(description = "user selects {0} from product list")
	public void userSelectsFromProductList(String productCatogory) {
		SelectproductTestPage.selectProduct(productCatogory);
	}
	@QAFTestStep(description = "user navigates to searchproduct page")
	public void userNavigatesToSearchproductPage() {
		searchresultTestPage.verifyProductList();
	}
	
	@QAFTestStep(description = "user selects {0} product from product list")
	public void userSelectsProductFromProductList(String index) {
		searchresultTestPage.selectProductName(Integer.parseInt(index));
	}
	@QAFTestStep(description = "user verifies product details matching correctly")
	public void userVerifiesProductDetailsMatchingCorrectly() {
		
		productdetailTestPage.verifyProductOnDetailPage();
	}
	@QAFTestStep(description = "user selects add to cart")
	public void userSelectsAddToCart() 
	{
		productdetailTestPage.selectAddtoCartButton();
	}
	@QAFTestStep(description = "product has been added to cart")
	public void productHasBeenAddedToCart() {
		AddToCartPage addToCartPage=new AddToCartPage();
		addToCartPage.verifyProductOnAddToCartPage();
	}

}
