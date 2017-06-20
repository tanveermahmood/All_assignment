package domestictest;

import org.testng.annotations.Test;

import com.air_irctc.DomesticTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;




public class Domestic_Scenario extends WebDriverTestCase {

	@Test(groups = { "SMOKE" }, description = "fill domestic form")
	public void scenario1() throws InterruptedException {
		DomesticTestPage df = new DomesticTestPage();
		Generic1 generic1=new Generic1(getDriver());
		df.launchPage(null);
		/*df.getRadioOneWay().click();*/
		/*df.getTextOrigin().sendKeys("Hyderabad,HYD");
		df.getTextDestination().sendKeys("Pune,PNQ");*/
		generic1.kw_click_link(df.getRadioOneWay());
		generic1.kw_enter_text(df.getTextOrigin(), "Calcutta (Kolkata),CCU");
		generic1.kw_moveToElement(df.getOrigin_value());
		generic1.kw_enter_text(df.getTextDestination(), "Pune,PNQ");
		generic1.kw_moveToElement(df.getDestination_value());
		/*Thread.sleep(3000);*/
		generic1.kw_synchronize(3000);
		/*Generic1.kw_click_link(df.getCalender());*/
		/*Generic1.kw_click_link(df.getDate());*/
		/*Generic1.kw_date_picker(df.getApril_calender(),30 );*/
		/*Generic1.kw_date("29/04/2017", "Depart");*/
		//Generic1.kw_date(df.getCalender(), df.getNext_calender(), df.getApril_calender());
		generic1.kw_date1("23/08/2017", "Depart");
		generic1.kw_dropdown(df.getSelectAdult(), 2);
		generic1.kw_dropdown(df.getSelectChild(), 1);
		generic1.kw_dropdown(df.getSelectInfant(), 3);
		generic1.kw_dropdown(df.getSelectClass(), 2);
		generic1.kw_dropdown(df.getSelectPreference(),2);
		df.getSearch().click();
		
		generic1.kw_validate_title("IRCTC, Flight Ticket, Air Ticket, Cheap Flight, Low Fare Flight");
	}

}
