package com.flipkart_day3.page;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hamcrest.Matchers;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;

public class SearchresultTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "Searchproduct.component.product")
	private List<QAFWebElement> searchproductComponentProduct;
	@FindBy(locator = "Searchproduct.link.productname")
	private List<QAFWebElement> searchproductLinkProductname;
	@FindBy(locator = "Searchproduct.lbl.productprice")
	private List<QAFWebElement> searchproductLblProductprice;
	
	@FindBy(locator = "lowHighTab.click")
	private QAFWebElement lowHighTabButton;
	
	@FindBy(locator = "Addtocart.btn")
	private QAFWebElement Addtocart;
	
	@FindBy(locator = "NameOfMobile.txt")
	private QAFWebElement NameOfMobile;
	
	@FindBy(locator = "FeatureOfmobile.txt")
	private QAFWebElement FeatureOfmobile;


	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public List<QAFWebElement> getSearchproductComponentProduct() {
		return searchproductComponentProduct;
	}

	public List<QAFWebElement> getSearchproductLinkProductname() {
		return searchproductLinkProductname;
	}

	public List<QAFWebElement> getSearchproductLblProductprice() {
		return searchproductLblProductprice;
	}
	public QAFWebElement getLowHighTab() {
		lowHighTabButton.waitForPresent(9000);
		return lowHighTabButton;
	}
	public QAFWebElement addToCart() {
		
		return Addtocart;
		
	}
	
public QAFWebElement nameOfMobile() {
		
		return NameOfMobile;
		
	}
public QAFWebElement featureOfMobile() {
	
	return FeatureOfmobile;
	
}
 public void verifySearchResultPage()
 {
	 Validator.verifyThat(searchproductComponentProduct.size(), Matchers.greaterThan(0));
//	 for(QAFWebElement product : searchproductComponentProduct )
//	 {
		 for(QAFWebElement productname :searchproductLinkProductname )
		 {
			 Reporter.log(productname.getText());
		 }
//	 }  
		 for(QAFWebElement productprice : searchproductLblProductprice)
		 {
			 Reporter.log(productprice.getText());
		 }
 }	
/* public void selectlowToHighTab() {
	getLowHighTab().click();
}

public void lowToHighTab() {
	getLowHighTab().click();
}

public void selectLowestAmountIpad() {
	 String mobileName = nameOfMobile().getText();
	List<QAFWebElement> feature = (List<QAFWebElement>) featureOfMobile();
	for (QAFWebElement features : feature) {
		System.out.println(features.getText());
		
	}
	System.out.println(mobileName);
	System.out.println();
	nameOfMobile().click();
}
             */
			public void AddToCart() {
					
				addToCart().click();
				}
 
 
			public List<String> getProductNames() {
				List<QAFWebElement> names=getSearchproductLinkProductname();
				List<String> pnames=new ArrayList<String>();
				for(QAFWebElement ele:names) {
					pnames.add(ele.getText().trim());
				}
				return pnames;
			}
			
		public List<Integer> getProductPrices() {
				List<QAFWebElement> names=getSearchproductLblProductprice();
				List<Integer> pprices=new ArrayList<Integer>();
				for(QAFWebElement ele:names) {
					pprices.add(getNumber(ele.getText().trim()));
				}
				return pprices;
			}
			// return least price
			public int compareMinPrice() {
				List<Integer> price = getProductPrices();
				Iterator<Integer> iter = price.iterator();
				int min = price.get(0);
				while (iter.hasNext()) {
					Integer no = iter.next();
					if (no.compareTo(min) < 0) {
						min = no;
					}
				}
				System.out.println("Min prices        : "+min);
				return min;
			}
			
			public String getLeastPriceProductName() {
				int least = getMinPriceProduct(compareMinPrice());
				return getSearchproductLinkProductname().get((least-1)).getText();
			}
			
			// return corresponding product row no
			public int getMinPriceProduct(int min) {
				List<Integer> prices = getProductPrices();
				int count = 0;
				for (int price : prices) {
					count = count + 1;
					if (price == min) {
						break;
					}
				}
				return count;
			}

			public int getNumber(String number) {
				String str1 = number.substring(1, number.length());
				String str2 = str1.replace(",", "");
				return Integer.parseInt(str2);
			}
			
}
