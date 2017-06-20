package domestictest;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

import jxl.Sheet;
import jxl.Workbook;

public class Generic1 {
	WebDriver driver;
	public static String folderpath ="/air_irctc/resources/data.xlsx";
	public static Workbook book;
	public static Sheet sh;
	// wait for given time
	public void kw_synchronize(int value) throws InterruptedException
	{
		Thread.sleep(value);
	}
	
	public Generic1(QAFExtendedWebDriver oDriver) {
		this.driver=oDriver;
	}

	// close the current browser
	
	public void kw_close()
	{
		driver.close();
	}

	// maximize the window
	
	public void kw_maximize()
	{
		driver.manage().window().maximize();
	}

	//entering text in a text field
	
	public void kw_enter_text(QAFWebElement element,String text) 
	{
		element.sendKeys(text);
	}
	
	public void kw_enter_text1(QAFWebElement element,String text) 
	{
		element.sendKeys(text,Keys.ARROW_DOWN,Keys.ENTER);
		
	}
	
	// click button
	
	public void kw_click_link(QAFWebElement element)
	{
		element.click();
	}

	//move to an element
	
	public void kw_moveToElement(QAFWebElement element)
	{
	   Actions action = new Actions(driver);
	   action.moveToElement(element).click().build().perform();
	}
   //selecting the element from dropdown
	
	public void kw_dropdown(QAFWebElement ele,int index)
	{
		Select sel=new Select(ele);
		sel.selectByIndex(index);
	}
	
	//validating the string
	
	public void kw_validate(QAFWebElement expected,QAFWebElement actual)
	{
		boolean booleanvalue = expected.equals(actual);
		if(booleanvalue==false)
		{
			System.out.println("expected string"+expected+"Not matching actual string"+actual+"");
	}
		else
		{
			System.out.println("expected string"+expected+"Matching actual string"+actual+"");
	}
	}
//validatig the page title
		
	public void kw_validate_title(String exp_Title)
	{
		String actualtitle =driver.getTitle();
		if(exp_Title.equals(actualtitle))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("false");
		}
	}
	// handling popup windows
	
	public void kw_alertPopup()
	{
		Alert al = driver.switchTo().alert();
		al.accept();
	}

	// for creating excel connection
	public void createExcelConnection(String filename,String sheetname)
	{
		try
		{
		FileInputStream fis = new FileInputStream( folderpath + filename);
		book =Workbook.getWorkbook(fis);
		sh = book.getSheet(sheetname);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//for counting no of rows
		public int rowCount()
		{
			return sh.getRows();
		}
		
	//for counting no of columns
		public int colCount()
		{
			return sh.getColumns();
		}
		
	//for fetching values from excel sheet
		public String readData(int cnum,int rnum)
		{
			return sh.getCell(cnum, rnum).getContents();
		}
		
		public void kw_date_picker(QAFWebElement Element,int value)
		{
			//QAFExtendedWebElement dateWidget = new QAFExtendedWebElement(locator);
			List<WebElement> columns=Element.findElements(By.tagName("td"));

			for (WebElement cell: columns){
			   //Select 13th Date 
				/*WebElement ele=cell.findElement(By.tagName("a"));*/
			   if (cell.getText().equals(value)){
			      cell.click();
			      break;
			 }
		}
		}
		
		public void kw_date1(String date,String TripType)
		{
			String[] a = date.split("/");
			String day = a[0];
			String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
			int x = Integer.parseInt(a[1]);
			String month = months[x-1];
			String year =a[2];
			
			System.out.println("Day: "+day);
			System.out.println("Month: "+month);
			System.out.println("Year: "+year);
			System.out.println("Trip Type: "+TripType);
			switch(TripType)
			{
			case "Depart":
				driver.findElement(By.xpath("//input[@id='departDate']/following-sibling::img")).click();
				break;
				
			case "Return":
				driver.findElement(By.xpath("//*[@id='lastwhenId']/img")).click();
				break;
				default:
					System.out.println("Invalid trip type...");
			}
			//driver.findElement(By.xpath("//input[@id='departDate']/following-sibling::img")).click();
			//Xpath of year in left calender
			
			String Cal_year = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/div/div/span[2]")).getText();
			//loop navigate until the required year reached
			while(!Cal_year.equals(year))
			{
				//xpath of arrow in right calender
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a/span")).click();
				//xpath of year on left calender
				String Cal_year1 = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/div/div/span[2]")).getText();
				Cal_year = Cal_year1;
			}
			//xpath of month in left calender
			String Cal_Month = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/div/div/span[1]")).getText();
			
			//loop until the required year reached
			while(!Cal_Month.equals(month))
			{
				//xpath of arrow in right calender
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a/span")).click();
				String Cal_Month1 = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/div/div/span[1]")).getText();
				Cal_Month = Cal_Month1;
			}
			WebElement datewidget = driver.findElement(By.id("ui-datepicker-div"));
			List<WebElement> columns = datewidget.findElements(By.tagName("td"));
			for(WebElement cell : columns)
			{
				if(cell.getText().equals(day))
				{
					cell.findElement(By.linkText(day)).click();
					break;
				}
			}
		}
			
		
		public void kw_date(QAFWebElement element,QAFWebElement element1,QAFWebElement element2)
		{
		
		 //Click on textbox so that datepicker will come  
		  element.click();  
/*		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);  */
		 //Click on next so that we will be in next month  
		  element2.click();  

		 /*DatePicker is a table.So navigate to each cell   
		 * If a particular cell matches value 13 then select it  
		 */  
		 /*WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));*/  
		List<WebElement> rows=element1.findElements(By.tagName("tr"));  
		List<WebElement> columns=element1.findElements(By.tagName("td"));  

		for (WebElement cell: columns){  
		 //Select 26 Date   
		 if (cell.getText().equals("26")){  
		 cell.findElement(By.linkText("13")).click();  
		 break;  
		 }  
		 }   
					}
}
		