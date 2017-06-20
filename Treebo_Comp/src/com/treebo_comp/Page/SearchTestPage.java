package com.treebo_comp.Page;

import java.util.HashMap;
import java.util.List;

import org.hamcrest.Matchers;

import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.util.Validator;
import com.treebo_comp.Bean.ProductInfoBean;
import com.treebo_comp.Component.HotelComponent;
import com.treebo_comp.Utils.CommonUtils;

public class SearchTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "Searchpage.Comp.Hoteldetail")
	private List<HotelComponent> searchpageCompHoteldetail;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public List<HotelComponent> getSearchpageCompHoteldetail() {
		return searchpageCompHoteldetail;
	}

	public void verifyProductList() {
		Validator.verifyThat(getSearchpageCompHoteldetail().size(), Matchers.greaterThan(0));
		getSearchpageCompHoteldetail().get(0).getSearchpageLnkHotelName().waitForVisible();

		for (HotelComponent p : getSearchpageCompHoteldetail()) {

			System.out.println("HotelName" + p.getSearchpageLnkHotelName());
			System.out.println("HotelPrice" + p.getSearchpageLblHotelPrice());
			System.out.println("HotelNameLocation" + p.getSearchpageLblHotelLocation());
			System.out.println("HotelDiscount" + p.getSearchpageLblHotelDiscount());
		}
	}

	public void selectProductName(int index) {
		ProductInfoBean productInfoBean = new ProductInfoBean();
		productInfoBean.setHotelName(getSearchpageCompHoteldetail().get(index).getSearchpageLnkHotelName().getText());
		productInfoBean.setHotelPrice(getSearchpageCompHoteldetail().get(index).getSearchpageLblHotelPrice().getText());
		productInfoBean.setHotelLocation(getSearchpageCompHoteldetail().get(index).getSearchpageLblHotelLocation().getText());
		productInfoBean.setHotelDiscount(getSearchpageCompHoteldetail().get(index).getSearchpageLblHotelDiscount().getText());
		HashMap<String, ProductInfoBean> productInfo = new HashMap<String, ProductInfoBean>();

		productInfo.put(productInfoBean.hotelName, productInfoBean);
		getSearchpageCompHoteldetail().get(index).getSearchpageLnkHotelName().click();
		CommonUtils.setProductItem(productInfo);
		QAFTestBase.pause(3000);
	}

}
