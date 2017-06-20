package domestictest;

import java.util.Map;

import org.testng.annotations.Test;

import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class Xyz extends WebDriverTestCase {

	@QAFDataProvider(dataFile = "resources/data.csv")
	@Test(description = "asdasdfq")
	public void ascasc(Map<String, String> data) {
		//TODO: call test steps
	}

}
