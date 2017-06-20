package domestictest;

import org.testng.annotations.Test;

import com.air_irctc.GmailTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class Gmail_Main extends WebDriverTestCase {
	
	
	@Test(groups = { "SMOKE" }, description = "fill gmail form")
	public void scenario3() throws InterruptedException {
	GmailTestPage gm = new GmailTestPage();
	gm.launchPage(null);
	gm.fillData();
	
	}
}
