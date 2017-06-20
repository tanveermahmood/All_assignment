package com.air_irctc;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

import domestictest.Gmail;

public class GmailTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "text.firstname")
	private QAFWebElement textFirstname;
	@FindBy(locator = "text.lastname")
	private QAFWebElement textLastname;
	@FindBy(locator = "text.gmailaddress")
	private QAFWebElement textGmailaddress;
	@FindBy(locator = "password.passwd")
	private QAFWebElement passwordPasswd;
	@FindBy(locator = "password.passwdagain")
	private QAFWebElement passwordPasswdagain;
	
	

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
		driver.get("/");
	}

	public QAFWebElement getTextFirstname() {
		return textFirstname;
	}

	public QAFWebElement getTextLastname() {
		return textLastname;
	}

	public QAFWebElement getTextGmailaddress() {
		return textGmailaddress;
	}

	public QAFWebElement getPasswordPasswd() {
		return passwordPasswd;
	}

	public QAFWebElement getPasswordPasswdagain() {
		return passwordPasswdagain;
	}
	public void fillData()
	{
		Gmail gl = new Gmail();
		gl.fillRandomData();
		gl.fillUiElements();
		
}
}

