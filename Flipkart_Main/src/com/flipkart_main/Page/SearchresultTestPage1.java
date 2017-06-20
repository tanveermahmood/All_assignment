package com.flipkart_main.Page;

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

public class SearchresultTestPage1 extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "Searchproduct.component.product")
	private List<QAFWebElement> searchproductComponentProduct;
	@FindBy(locator = "Searchproduct.link.productname")
	private List<QAFWebElement> searchproductLinkProductname;
	@FindBy(locator = "Searchproduct.lbl.productprice")
	private List<QAFWebElement> searchproductLblProductprice;
	
	
	@FindBy(locator = "Addtocart.btn")
	private QAFWebElement Addtocart;


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

	public QAFWebElement addToCart() {
		
		return Addtocart;
		
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
