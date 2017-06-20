package com.flipkart_main.Page;


import java.util.HashMap;
import java.util.List;

import org.hamcrest.Matchers;

import com.flipkart_main.bean.ProductInfoBean;
import com.flipkart_main.component.ProductComponent;
import com.flipkart_main.utils.CommonUtils;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.util.Validator;

public class AddToCartPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "searchproduct.cmp.productdetails")
	private List<ProductComponent> searchproductCmpProductdetails;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public void verifyProductOnAddToCartPage() {
		searchproductCmpProductdetails.get(0).getSearchproductLnkProductname().waitForVisible();
		Validator.verifyThat(searchproductCmpProductdetails.size(), Matchers.greaterThan(0));
		HashMap<String, ProductInfoBean> productInfo2 = CommonUtils.getProductItems();
		for (String key : productInfo2.keySet()) {
			ProductInfoBean details = productInfo2.get(key);

			for(ProductComponent productComponent:searchproductCmpProductdetails)
			{
				Validator.verifyThat(productComponent.getSearchproductLblProductprice().getText(), Matchers.containsString(details.getProductPrice()));
				Validator.verifyThat(productComponent.getSearchproductLnkProductname().getText(), Matchers.containsString(details.getProductName()));
				
			}
		}
	}

}
