package com.flipkart_main.component;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class ProductComponent extends QAFWebComponent {

	public ProductComponent(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}

	@FindBy(locator = "searchproduct.lnk.productname")
	private QAFWebElement searchproductLnkProductname;

	@FindBy(locator = "searchproduct.lbl.productprice")
	private QAFWebElement searchproductLblProductprice;

	public QAFWebElement getSearchproductLnkProductname() {
		return searchproductLnkProductname;
	}

	public QAFWebElement getSearchproductLblProductprice() {
		return searchproductLblProductprice;
		
	}
	
	

}
