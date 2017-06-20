package flipkartweb.page;


import java.util.HashMap;

import org.hamcrest.Matchers;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

import flipkartweb.bean.ProductInfoBean;
import flipkartweb.utils.CommonUtils;

public class ProductdetailTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "productdetail.lbl.productname")
	private QAFWebElement productdetailLblProductname;
	@FindBy(locator = "productdetail.lbl.price")
	private QAFWebElement productdetailLblPrice;

	@FindBy(locator = "productdetail.btn.addtocart")
	private QAFWebElement addtoCartButton;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getProductdetailLblProductname() {
		return productdetailLblProductname;
	}

	public QAFWebElement getProductdetailLblPrice() {
		return productdetailLblPrice;
	}

	public void verifyProductOnDetailPage() {
		if (driver.getWindowHandles().size() > 1) {
			CommonUtils.switchToWindow(driver);
		}
		getProductdetailLblProductname().waitForVisible();
		HashMap<String, ProductInfoBean> productInfo2 = CommonUtils.getProductItems();
		for (String key : productInfo2.keySet()) {
			ProductInfoBean details = productInfo2.get(key);

			Validator.verifyThat(getProductdetailLblProductname().getText(),
					Matchers.containsString(details.getProductName()));
			Validator.verifyThat(getProductdetailLblPrice().getText(),
					Matchers.containsString(details.getProductPrice()));
		}
	}

	public void selectAddtoCartButton() {
		addtoCartButton.click();
	}

}
