import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.html5.*;
import org.openqa.selenium.logging.*;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Cookie.Builder;

import io.appium.java_client.*;
import io.appium.java_client.android.*;
import io.appium.java_client.ios.*;

import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.reportium.client.ReportiumClientFactory;
import com.perfecto.reportium.model.Job;
import com.perfecto.reportium.model.PerfectoExecutionContext;
import com.perfecto.reportium.model.Project;
import com.perfecto.reportium.test.TestContext;
import com.perfecto.reportium.test.result.TestResult;
import com.perfecto.reportium.test.result.TestResultFactory;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.ExplicitGroup;

/**
 * For programming samples and updated templates refer to the Perfecto GitHub
 * at: https://github.com/PerfectoCode
 */
public class AppiumTest {

	public static void main(String[] args) throws MalformedURLException, IOException {
		System.out.println("Run started");

		String browserName = "mobileOS";
		DesiredCapabilities capabilities = new DesiredCapabilities(browserName, "", Platform.ANY);
		String host = "partners.perfectomobile.com";
		capabilities.setCapability("user", "is_user1@infostretch.com");
		capabilities.setCapability("password", "demo123");

		// TODO: Change your device ID
		capabilities.setCapability("deviceName", "A5644C053ACE2EB950A3FB74949CA716B23E5DDF");

		// Use the automationName capability to define the required framework -
		// Appium (this is the default) or PerfectoMobile.
		capabilities.setCapability("automationName", "Appium");

		// Call this method if you want the script to share the devices with the
		// Perfecto Lab plugin.
		// PerfectoLabUtils.setExecutionIdCapability(capabilities, host);

		// Application settings examples.
		// capabilities.setCapability("app",
		// "PRIVATE:applications/Errands.ipa");
		// For Android:
		// capabilities.setCapability("appPackage", "com.google.android.keep");
		// capabilities.setCapability("appActivity",
		// ".activities.BrowseActivity");
		// For iOS:
		// capabilities.setCapability("bundleId", "com.yoctoville.errands");

		// Add a persona to your script (see
		// https://community.perfectomobile.com/posts/1048047-available-personas)
		// capabilities.setCapability(WindTunnelUtils.WIND_TUNNEL_PERSONA_CAPABILITY,
		// WindTunnelUtils.GEORGIA);

		// Name your script
		// capabilities.setCapability("scriptName", "AppiumTest");

		// AndroidDriver driver = new AndroidDriver(new URL("https://" + host +
		// "/nexperience/perfectomobile/wd/hub"), capabilities);
		IOSDriver driver = new IOSDriver(new URL("https://" + host + "/nexperience/perfectomobile/wd/hub"),
				capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// Reporting client. For more details, see
		// https://github.com/perfectocode/samples/wiki/reporting
		PerfectoExecutionContext perfectoExecutionContext = new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
				.withProject(new Project("My Project", "1.0")).withJob(new Job("My Job", 45)).withContextTags("tag1")
				.withWebDriver(driver).build();
		ReportiumClient reportiumClient = new ReportiumClientFactory()
				.createPerfectoReportiumClient(perfectoExecutionContext);

		try {
			reportiumClient.testStart("My test name", new TestContext("tag2", "tag3"));

			// write your code here
			driver.get("flipkart.com");
			driver.findElement(By.xpath("//*[@class='_2MXt9f']")).click();
			String electronicsLoc = "//*[@class='_36GEsZ' and text()='Electronics']";
			WebDriverWait wait = new WebDriverWait(driver, 30);
			   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(electronicsLoc)));
			   driver.findElement(By.xpath(electronicsLoc)).click();

			   String tabletsLocStr = "//*[text()='Tablets']";
			   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tabletsLocStr)));
			   driver.findElement(By.xpath(tabletsLocStr)).click();

			   String viewAllBtnStr = "//*[@class='_1oIQWM']/div[2]/a[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]";
			   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(viewAllBtnStr)));
			   driver.findElement(By.xpath(viewAllBtnStr)).click();

			   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='FILTER']")));

			   	
			   /*List<WebElement> itemList = driver.findElements(By.cssSelector(".GUVMqT"));

			   Map<String, Integer> priceList = new HashMap<String, Integer>();
			   
			   for (WebElement item : itemList) {
				    String itemName = item.findElement(By.cssSelector("._1PnKMA")).getText();
				    String price = item.findElement(By.cssSelector("._3_ANf1")).getText();
				    System.out.println("********************ITEMNAME: " + itemName);
				    System.out.println("********************PRICE: " + price);
				    priceList.put(itemName, Integer.parseInt(price.substring(1).replace(",", "")));
				   }

				   Map<String, Integer> sortedMap = sortByValue(priceList);
				   Map.Entry<String, Integer> entry = sortedMap.entrySet().iterator().next();
				   String key = entry.getKey();
				   System.out.println("Lowest price item" + key);
				   driver.findElement(By.xpath(String.format("//*[text()='%s']", key))).click();
				   String addtocartLoc = "//span[text()='ADD TO CART']";
				   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(addtocartLoc)));
				   driver.findElement(By.xpath(addtocartLoc)).click();
				   
				   driver.findElement(By.xpath(addtocartLoc)).click();
		*/
			// reportiumClient.testStep("step1"); // this is a logical step for
			// reporting
			// reportiumClient.testStep("step2");

			reportiumClient.testStop(TestResultFactory.createSuccess());
		} catch (Exception e) {
			reportiumClient.testStop(TestResultFactory.createFailure(e.getMessage(), e));
			e.printStackTrace();
		} finally {
			try {
				// Retrieve the URL of the Single Test Report, can be saved to
				// your execution summary and used to download the report at a
				// later point
				String reportURL = reportiumClient.getReportUrl();
				
				// For documentation on how to export reporting PDF, see
				// https://github.com/perfectocode/samples/wiki/reporting
				// String reportPdfUrl =
				// (String)(driver.getCapabilities().getCapability("reportPdfUrl"));

				driver.close();

				// In case you want to download the report or the report
				// attachments, do it here.
				// PerfectoLabUtils.downloadAttachment(driver, "video",
				// "C:\\test\\report\\video", "flv");
				// PerfectoLabUtils.downloadAttachment(driver, "image",
				// "C:\\test\\report\\images", "jpg");

			} catch (Exception e) {
				e.printStackTrace();
			}

			driver.quit();
		}

		System.out.println("Run ended");
	}
}
