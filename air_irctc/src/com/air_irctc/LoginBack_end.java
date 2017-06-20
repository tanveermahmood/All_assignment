package com.air_irctc;

import org.openqa.selenium.WebDriver;

import com.air_irctc.DomesticTestPage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

import domestictest.Generic1;

public class LoginBack_end extends WebDriverTestCase{

	

	// for launching the app
		@QAFTestStep(description="opening browser and pass the url")
		public static void open()
		{
			DomesticTestPage df = new DomesticTestPage();
			df.launchPage(null);
		}

		// for filling the form
		
		@QAFTestStep(description="fill the domestic flight form")
		public void fill_form() throws InterruptedException
		{
			DomesticTestPage df = new DomesticTestPage();
			Generic1 generic1=new Generic1(getDriver());
			generic1.kw_click_link(df.getRadioOneWay());
			generic1.kw_enter_text(df.getTextOrigin(), "Calcutta (Kolkata),CCU");
			generic1.kw_moveToElement(df.getOrigin_value());
			generic1.kw_enter_text(df.getTextDestination(), "Pune,PNQ");
			generic1.kw_moveToElement(df.getDestination_value());
			Thread.sleep(3000);
			df.getCalender().click();
			df.getDate().click();
			generic1.kw_dropdown(df.getSelectAdult(), 2);
			generic1.kw_dropdown(df.getSelectChild(), 1);
			generic1.kw_dropdown(df.getSelectInfant(), 3);
			generic1.kw_dropdown(df.getSelectClass(), 2);
			generic1.kw_dropdown(df.getSelectPreference(),2);
			df.getSearch();
		}
}
