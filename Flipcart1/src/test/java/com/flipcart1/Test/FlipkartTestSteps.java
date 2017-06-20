package com.flipcart1.Test;

import org.testng.annotations.Test;

import com.flipcart1.Page.FlipkartTestPage;
import com.flipcart1.Test.Generic;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class FlipkartTestSteps extends WebDriverTestCase {

	@Test(groups = { "P1", "P2", "SMOKE" }, description = "search mobile")
	public void search() {
		FlipkartTestPage fts = new FlipkartTestPage();
		Generic gn = new Generic();
		fts.launchPage(null);
		gn.kw_moveToElement(fts.getSpanSpan());
		fts.getImgGreatDeals().click();
		
		
	}

}
