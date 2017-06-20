package flipkartweb.page;



import java.util.HashMap;
import java.util.List;

import org.hamcrest.Matchers;

import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.util.Validator;

import flipkartweb.bean.ProductInfoBean;
import flipkartweb.components.ProductComponent;
import flipkartweb.utils.CommonUtils;

public class SearchresultTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "searchproduct.cmp.productdetails")
	private List<ProductComponent> searchproductCmpProductdetails;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public List<ProductComponent> getSearchproductCmpProductdetails() {
		return searchproductCmpProductdetails;
	}

	public void verifyProductList() {
		Validator.verifyThat(getSearchproductCmpProductdetails().size(), Matchers.greaterThan(0));
		getSearchproductCmpProductdetails().get(0).getSearchproductLnkProductname().waitForVisible();

		for (ProductComponent p : getSearchproductCmpProductdetails()) {

			System.out.println("ProductName" + p.getSearchproductLnkProductname());
			System.out.println("ProductSize" + p.getSearchproductLblProductprice());

		}
	}

	public void selectProductName(int index) {
		ProductInfoBean productInfoBean = new ProductInfoBean();
		productInfoBean.setProductName(
				getSearchproductCmpProductdetails().get(index).getSearchproductLnkProductname().getText());
		productInfoBean.setProductPrice(
				getSearchproductCmpProductdetails().get(index).getSearchproductLblProductprice().getText());
		HashMap<String, ProductInfoBean> productInfo = new HashMap<String, ProductInfoBean>();

		productInfo.put(productInfoBean.productName, productInfoBean);
		getSearchproductCmpProductdetails().get(index).getSearchproductLnkProductname().click();
		CommonUtils.setProductItem(productInfo);
		QAFTestBase.pause(3000);
	}

}
