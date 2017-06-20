/**
 * 
 */
package com.flipkart_mobile.step;

import com.flipkart_mobile.page.CategoryTestPage;
import com.flipkart_mobile.page.Flipkart_homeTestPage;
import com.qmetry.qaf.automation.step.QAFTestStep;

/**
 * @author tanveer.mahmood
 *
 */
public class StepsBackLog {

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user lauched flipkart application")
	public void userLauchedFlipkartApplication() {

	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user clicks on skip button on register page and clicks on open drawer icon")
	public void userClicksOnSkipButtonOnRegisterPage() {
		Flipkart_homeTestPage Flipkart_homeTestPage = new Flipkart_homeTestPage();
		Flipkart_homeTestPage.clickMenu();

	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user selects Mobiles from Electronics category")
	public void userSelectsFromCategory() {
		CategoryTestPage CategoryTestPage = new CategoryTestPage();
		CategoryTestPage.selectCategory();

	}

}
