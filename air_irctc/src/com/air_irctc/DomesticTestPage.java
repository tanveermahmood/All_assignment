package com.air_irctc;

import org.openqa.selenium.support.ui.Select;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class DomesticTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "radio.one.way")
	private QAFWebElement radioOneWay;
	
	@FindBy(locator = "text.origin")
	private QAFWebElement textOrigin;
	
	@FindBy(locator = "text.destination")
	private QAFWebElement textDestination;
	
	@FindBy(locator = "calender")
	private QAFWebElement calender1;
	
	@FindBy(locator = "date")
	private QAFWebElement date1;
	
	@FindBy(locator = "select.adult")
	private QAFWebElement select1;
	
	@FindBy(locator = "option.adult")
	private QAFWebElement option3;
	
	@FindBy(locator = "select.child")
	private QAFWebElement select0;
	
	@FindBy(locator = "option.child")
	private QAFWebElement option31;
	
	@FindBy(locator = "select.infant")
	private QAFWebElement select01;
	
	@FindBy(locator = "option.infant")
	private QAFWebElement option32;
	
	@FindBy(locator = "select.class")
	private QAFWebElement selectE;
	
	@FindBy(locator = "option.class")
	private QAFWebElement optionB;
	
	@FindBy(locator = "select.Preference")
	private QAFWebElement selectAll;
	
	@FindBy(locator = "option.Preference")
	private QAFWebElement option0S;
	
	@FindBy(locator = "search")
	private QAFWebElement divDiv;
	
	@FindBy(locator = "april.full")
	private QAFWebElement pick ;

	@FindBy(locator = "next.calender")
	private QAFWebElement pick1 ;
	
	@FindBy(locator = "origin.value")
	private QAFWebElement value1 ;
	
	@FindBy(locator = "destination.value")
	private QAFWebElement value2 ;
	
	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
		driver.get("/");
	}

	public QAFWebElement getRadioOneWay() {
		return radioOneWay;
	}

	public QAFWebElement getTextOrigin() {
		return textOrigin;
	}

	public QAFWebElement getTextDestination() {
		return textDestination;
	}

	public QAFWebElement getSelectAdult() {
		return select1;
	}

	public QAFWebElement getOptionAdult() {
		return option3;
	}

	public QAFWebElement getSelectChild() {
		return select0;
	}

	public QAFWebElement getOptionChild() {
		return option31;
	}

	public QAFWebElement getSelectInfant() {
		return select01;
	}

	public QAFWebElement getOptionInfant() {
		return option32;
	}

	public QAFWebElement getSelectClass() {
		return selectE;
	}

	public QAFWebElement getOptionClass() {
		return optionB;
	}

	public QAFWebElement getSelectPreference() {
		return selectAll;
	}

	public QAFWebElement getOptionPreference() {
		return option0S;
	}

	public QAFWebElement getSearch() {
		return divDiv;
	}
	public QAFWebElement getCalender() {
		return calender1;
	}
	public QAFWebElement getDate() {
		return date1;
	}
	public QAFWebElement getApril_calender() {
		return pick;
	}

	public QAFWebElement getNext_calender() {
		return pick1;
	}
	public QAFWebElement getOrigin_value() {
		return value1;
	}
	
	public QAFWebElement getDestination_value() {
		return value2;
	}
	
	/*public void selectAdults(QAFWebElement ele,int index) {
		
		Select sel=new Select(ele);
		sel.selectByIndex(index);
	}*/
}
