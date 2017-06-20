package com.treebo_comp.Component;

import java.util.HashMap;

import com.treebo_comp.Utils.CommonUtils;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.treebo_comp.Bean.ProductInfoBean;

public class HotelComponent extends QAFWebComponent {

	public HotelComponent(String locator) {
		super(locator);
	}
		
		@FindBy(locator = "Searchpage.lnk.HotelName")
		private QAFWebElement searchpageLnkHotelName;
		@FindBy(locator = "Searchpage.lbl.HotelPrice")
		private QAFWebElement searchpageLblHotelPrice;
		@FindBy(locator = "Searchpage.lbl.HotelLocation")
		private QAFWebElement searchpageLblHotelLocation;
		@FindBy(locator = "Searchpage.lbl.HotelDiscount")
		private QAFWebElement searchpageLblHotelDiscount;


		public QAFWebElement getSearchpageLnkHotelName() {
			return searchpageLnkHotelName;
		}

		public QAFWebElement getSearchpageLblHotelPrice() {
			return searchpageLblHotelPrice;
		}

		public QAFWebElement getSearchpageLblHotelLocation() {
			return searchpageLblHotelLocation;
		}

		public QAFWebElement getSearchpageLblHotelDiscount() {
			return searchpageLblHotelDiscount;
		}
		
		}
	


