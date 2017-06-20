package flipkartweb.page;


import org.hamcrest.Matchers;
import org.openqa.selenium.interactions.Actions;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class FlipkarthomeTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "homepage.lnk.menuname")
	private QAFWebElement homepageLnkMenuname;
	@FindBy(locator = "homepage.lnk.submenuname")
	private QAFWebElement homepageLnkSubmenuname;

	@FindBy(locator="homepage.lnk.openDrawer")
	private QAFWebElement homepageOpenDrawer;
	
	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getHomepageLnkMenuname() {
		return homepageLnkMenuname;
	}

	public QAFWebElement getHomepageLnkSubmenuname() {
		return homepageLnkSubmenuname;
	}
	
	

	public QAFWebElement getHomepageOpenDrawer() {
		return homepageOpenDrawer;
	}

	public void clickOnOpenDrawer(){
		getHomepageOpenDrawer().waitForVisible();
		getHomepageOpenDrawer().click();
		waitForPageToLoad();
	}
	
	public void selectCatogory(String menuName, String subMenuName) {
		QAFExtendedWebElement catogoryName = new QAFExtendedWebElement(
				String.format(ConfigurationManager.getBundle().getString("homepage.lnk.menuname"), menuName));

		Actions action = new Actions(driver);
		action.moveToElement(catogoryName).perform();

		QAFExtendedWebElement subCatogoryName = new QAFExtendedWebElement(
				String.format(ConfigurationManager.getBundle().getString("homepage.lnk.submenu"), menuName));
   
		subCatogoryName.waitForVisible();
		subCatogoryName.click();
	}
	
	public void launchSite()
	{
		driver.get("/");
		driver.manage().window().maximize();
	}
	
	public void verifyFlipKartHomePage()
	{
	Validator.verifyThat("FlipKArtHpome pGAe Verification",driver.getTitle(),Matchers.containsString("Online Shopping Site for Mobiles,Fashion,Books,Electronics,Home Appliances & More @ Flipkart"));	
	}

}
