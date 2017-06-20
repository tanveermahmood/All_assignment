package flipkartweb;

import com.qmetry.qaf.automation.step.QAFTestStep;

import flipkartweb.page.AddToCartPage;
import flipkartweb.page.FlipkarthomeTestPage;
import flipkartweb.page.ProductdetailTestPage;
import flipkartweb.page.SearchresultTestPage;
import flipkartweb.page.SelectproductTestPage;

/**
 * @author harshit.trivedi
 *
 */
public class StepsBackLog {

	FlipkarthomeTestPage flipkarthomeTestPage = new FlipkarthomeTestPage();
	SelectproductTestPage selectproductTestPage = new SelectproductTestPage();
	SearchresultTestPage searchresultTestPage = new SearchresultTestPage();
	ProductdetailTestPage productdetailTestPage = new ProductdetailTestPage();

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user opens flipkart application")
	public void userOpensFlipkartApplication() {
		flipkarthomeTestPage.launchSite();
		flipkarthomeTestPage.verifyFlipKartHomePage();
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user selects {0} from {1} catogory")
	public void userSelectsFromCatogory(String subMenuName, String menuName) {
		// FlipkarthomeTestPage flipkarthomeTestPage = new
		// FlipkarthomeTestPage();
		flipkarthomeTestPage.selectCatogory(menuName, subMenuName);
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user navigates to product catogory")
	public void userNavigatesToProductCatogory() {
		selectproductTestPage.verifySelectProductPage();
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user selects {0} from product list")
	public void userSelectsFromProductList(String productCatogory) {
		selectproductTestPage.selectProduct(productCatogory);
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user navigates to searchproduct page")
	public void userNavigatesToSearchproductPage() {
		searchresultTestPage.verifyProductList();
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user selects {0} product from product list")
	public void userSelectsProductFromProductList(String index) {
		searchresultTestPage.selectProductName(Integer.parseInt(index));
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user verifies product details matching correctly")
	public void userVerifiesProductDetailsMatchingCorrectly() {
		productdetailTestPage.verifyProductOnDetailPage();
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user selects add to cart")
	public void userSelectsAddToCart() {
		productdetailTestPage.selectAddtoCartButton();
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "product has been added to cart")
	public void productHasBeenAddedToCart() {
		AddToCartPage addToCartPage=new AddToCartPage();
		addToCartPage.verifyProductOnAddToCartPage();
	}

}
