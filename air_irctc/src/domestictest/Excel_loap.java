package domestictest;

import java.util.Map;

import org.testng.annotations.Test;

import com.air_irctc.DomesticTestPage;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class Excel_loap extends WebDriverTestCase{
	/*
	public static Object[][] getExcelContents(String filename, String sheetname)
	{
		Generic1.createExcelConnection(filename, sheetname);
		int rc = Generic1.rowCount();
		int cc = Generic1.colCount();
		String[][] data = new String [rc-1][cc];
		for(int r=1;r<rc;r++)
		{
			for(int c=0;c<cc;c++)
			{
				data[r-1][c]=Generic1.readData(c, r);
			}
		}
		return data;
	}
*/
	@QAFDataProvider(dataFile = "resources/data.xlsx", sheetName="Sheet1")
	@Test(groups = { "SMOKE" }, description = "fill domestic form")
	public void scenario5(Map<String, String> data) throws InterruptedException {
		DomesticTestPage df = new DomesticTestPage();
		Generic1 generic1=new Generic1(getDriver());
		df.launchPage(null);
		generic1.kw_click_link(df.getRadioOneWay());
		generic1.kw_enter_text(df.getTextOrigin(), "Calcutta (Kolkata),CCU");
		generic1.kw_moveToElement(df.getOrigin_value());
		generic1.kw_enter_text(df.getTextDestination(), "Pune,PNQ");
		generic1.kw_moveToElement(df.getDestination_value());
		Thread.sleep(3000);
		df.getCalender().click();
		df.getDate().click();
		/*QAFWebElement fname = new QAFExtendedWebElement("select.child");
		Select s = new Select(fname); 
		s.selectByIndex(2);*/
		generic1.kw_dropdown(df.getSelectAdult(), 2);
		generic1.kw_dropdown(df.getSelectChild(), 1);
		generic1.kw_dropdown(df.getSelectInfant(), 3);
		generic1.kw_dropdown(df.getSelectClass(), 2);
		generic1.kw_dropdown(df.getSelectPreference(),2);
		df.getSearch();
	}
}

