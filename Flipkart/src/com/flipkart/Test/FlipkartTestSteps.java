package com.flipkart.Test;

import org.testng.annotations.Test;

import com.flipkart.Page.FlipkartTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class FlipkartTestSteps extends WebDriverTestCase {

	@Test(groups = { "P1", "P2", "SMOKE" }, description = "search mobile")
	public void search() {
		FlipkartTestPage ftp = new FlipkartTestPage();
		Generic gn = new Generic();
		ftp.launchPage(null);
		gn.kw_moveToElement(ftp.getSpanSpan());
		ftp.getImgGreatDeals().click();
	}

}