package pages;

import org.openqa.selenium.support.FindBy;

public class FlipkartcategorylistTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "flipkartcategoryList.link.category")
	private QAFWebElement flipkartcategoryListLinkCategory;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getFlipkartcategoryListLinkCategory() {
		return flipkartcategoryListLinkCategory;
	}

}
