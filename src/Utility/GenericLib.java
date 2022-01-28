package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
//import ru.yandex.qatools.ashot.AShot;
//import ru.yandex.qatools.ashot.Screenshot;
//import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Test;

public class GenericLib extends BaseClass {
	/**
	 * Created by Mishra Susovan
	 */

	public GenericLib(String val) {
		System.out.println("Generic lib starts");
		ExtentManger em = new ExtentManger();
		em.setpath(val);
		System.out.println("Setpath done");
		extent = ExtentManger.GetExtent();
		test = extent.createTest(val);
		test.assignAuthor("Automation Testing");
	}

	public void comparestring(String a, String b, String elementname) {

		// a = a.replaceAll("[^a-zA-Z0-9_-]", "");
		// b =b.replaceAll("[^a-zA-Z0-9_-]", "");
		if (a.equalsIgnoreCase(b)) {
			test.log(Status.PASS, "Match Successful for " + elementname);
		} else {
			test.log(Status.FAIL, "Texts Do not Match for: " + elementname);
			test.log(Status.INFO, "The Message compare:" + a);
			test.log(Status.INFO, "The Message compare:" + b);

			// test.fail("Failed Due to No match");
		}

	}
	//mishra function///////////////////////////////////////////////
//	public void GetString(String a,  String elementname) {
//
//		// a = a.replaceAll("[^a-zA-Z0-9_-]", "");
//		// b =b.replaceAll("[^a-zA-Z0-9_-]", "");
////		if (a.equalsIgnoreCase(b)) {
//String 	a1 = driver.findElement(By.xpath("//div[@data-automation-id='fileAttachment'])[1]/div/div")).getText();
//
//			test.log(Status.PASS, "Match Successful for " + elementname);
//		} else
//			
//		{
//			String elementname;
//			test.log(Status.FAIL, "Texts Do not Match for: " + elementname);
////			test.log(Status.INFO, "The Message compare:" + a);
////			test.log(Status.INFO, "The Message compare:" + b);
//
//			// test.fail("Failed Due to No match");
//		}
//
//	}
	
	public static void HighlightElement(WebDriver driver, WebElement element) throws InterruptedException {

		//        if (!(driver.toString().contains("InternetExplorerDriver"))) {
		//            if (!(driver.toString().contains("InternetExplorerDriver"))) {
		//                if (driver instanceof JavascriptExecutor) {
		//
		//                    ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
		//                    Thread.sleep(500);
		//                }
		//            }
		//        }
	}

	public int findnumberofrows(String path, String sheetname) {

		InputStream myxls = null;
		try {
			myxls = new FileInputStream(path);

			Workbook book = new XSSFWorkbook(myxls);
			Sheet sheet = book.getSheet(sheetname);
			System.out.println(sheet.getLastRowNum());
			return sheet.getLastRowNum();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;

	}

	public String findkeyvalue(String path, String sheetname, int rownumber) {
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(path);

			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			XSSFSheet firstSheet = workbook.getSheet(sheetname);
			Iterator<Row> rowiterator = firstSheet.iterator();
			DataFormatter formatter = new DataFormatter();

			// for (int i=1; i <= firstSheet.getLastRowNum(); i++) {
			Row r = firstSheet.getRow(rownumber);
			if (r == null) {
				System.out.println("Empty Row");
			} else {
				String j_username = formatter.formatCellValue(r.getCell(1));
				String j_password = formatter.formatCellValue(r.getCell(2));

				return j_username.concat(";;" + j_password);

				// Use these
				// }
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}

	public static void UnhighlightElement(WebDriver driver, WebElement element, By by) {
		//        if (!(driver.toString().contains("InternetExplorerDriver"))) {
		//            if (!(driver.toString().contains("edge"))) {
		//                try {
		//                    if (driver instanceof JavascriptExecutor) {
		//                        if (driver.findElements(by).size() != 0 && driver.findElement(by).isEnabled()) {
		//                            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border=''", element);
		//                        }
		//                    }
		//                } catch (Exception e) {
		//                    e.printStackTrace();
		//
		//                }
		//            }
		//        }
	}

	public WebDriver launchApplication(String browserName, String url) throws Exception {
		// Launch Browser
//		WebDriver driver = null;
		driver = null;
		try {
			test.log(Status.INFO, "Application launched successfully");
			if (browserName.equalsIgnoreCase("chrome")) {

				//String path = System.getProperty("user.dir"); // return project folder path

				//String driverpath = path + "\\src\\Jars\\chromedriver.exe";
				//System.out.println("Searching driver in :" + driverpath);
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\smishra270\\eclipse-workspace\\Dtrace_Automation\\src\\Server\\chromedriver.exe");
				driver = new ChromeDriver();
				//return driver;
			} else if (browserName.equalsIgnoreCase("IE")) {
				//				System.setProperty("webdriver.ie.driver",
				//						"C:\\Users\\rkaushik26\\OneDrive - DXC Production\\Desktop\\PPM\\src\\Jars\\IEDriverServer.exe");
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\smishra270\\eclipse-workspace\\Dtrace_Automation\\src\\Server\\chromedriver.exe");


				//         //       driver = new InternetExplorerDriver();
				//                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				//                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				////                File file = new File("C:\\Users\\rkaushik26\\OneDrive - DXC Production\\Desktop\\PPM\\src\\Jars\\IEDriverServer.exe");
				////                System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
				DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
				capability.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
				capability.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, 1);
				capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				capability.setCapability("requireWindowFocus", true);
				capability.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);

				driver = new InternetExplorerDriver(capability);

			} else if (browserName.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\rkaushik26\\OneDrive - DXC Production\\Desktop\\WMA_Demo\\WMA_Demo\\EXE\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("edge")) {

				driver = new EdgeDriver();

			}
			driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
			driver.get(url);
			driver.manage().window().maximize();
			// driver.navigate().refresh();
			System.out.println("Launch Complete");
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.INFO, "launch Application");
			e.printStackTrace();
			Assert.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot("LaunchAPP")));

		}
		return driver;
	}

	public void  killProcess(String ProcessName) 
	{

		try {
			Runtime.getRuntime().exec("TASKKILL /F /IM "+ProcessName+"");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//	Runtime.getRuntime().exec("TASKKILL /F /IM VIPUIManager.exe");


	public String takeScreenShot(String methodName) {

		long datetime = System.currentTimeMillis();
		methodName = methodName.trim();
		methodName = methodName.replaceAll("[^a-zA-Z0-9_-]", "");

		String path = "C:\\Users\\smishra270\\PPM_mvn_2412\\Dtrace_Automation\\ScreenShot\\"
				+ methodName + datetime + ".png";
		System.out.println("Path saving : " + path);
		
		try {
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}
	
	public void ScrollPage() 
	{
//		Object scroll = ((Object) driver).execute_script("window.scrollTo(0, document.body.scrollHeight);");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
//		js.executeScript("window.scrollBy(0,350)", "");
		js.executeScript("window.scrollBy(0,1050)");
		
		
	}
	
	

	public void ScreenShotReport(String elementname) throws IOException 
	{
//		Object scroll = ((Object) driver).execute_script("window.scrollTo(0, document.body.scrollHeight);");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)", "");
		test.pass("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
				
	}
	public void ScreenShotReport1(String elementname) throws IOException 
	{
//		Object scroll = ((Object) driver).execute_script("window.scrollTo(0, document.body.scrollHeight);");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		test.pass("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
				
	}
	
	

	public void clickElementByJs(By by, String elementname) throws IOException {
		try {
			test.log(Status.INFO, "Click on " + elementname);
			JavascriptExecutor js = (JavascriptExecutor) driver;

			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				GenericLib.HighlightElement(driver, e1);

				//							Actions actions = new Actions(driver);
				//							actions .moveToElement(e1).click().build().perform();
				/////////////////////////////////////////////////////////////////// HIGHLIGHT
				/////////////////////////////////////////////////////////////////// USE///////////////////////////////////////////

				// e1.click();
				Actions actions = new Actions(driver);
				actions.moveToElement(e1);
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				// executor.executeScript("arguments[0].scrollIntoView();",e1);
				// Thread.sleep(500);
				executor.executeScript("arguments[0].click();", e1);
				Thread.sleep(500);
				GenericLib.UnhighlightElement(driver, e1, by);
				test.log(Status.PASS, "Clicked on  " + elementname + " Successfully.");
			} else {

				test.log(Status.FAIL, "Failed to Click on " + elementname + " As not visible.");

			}

		} catch (Exception e) {
			// TODO: handle exception
			// Assert.fail("Screenshot below: " +
			// test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			test.log(Status.FAIL, "Failed to Click on " + elementname + ".");
			e.printStackTrace();
		}
	}
	

	public boolean waitForJSandJQueryToLoad() {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		// wait for jQuery to load
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					return ((Long) (executor).executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					// no jQuery present
					return true;
				}
			}
		};

		// wait for Javascript to load
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				return (executor).executeScript("return document.readyState").toString().equals("complete");
			}
		};
		return false;

		//return //(jQueryLoad) && //(jsLoad);
	}

	
	public void inputText(By by, String elementName, String data) {

		if ((!data.isEmpty()) || (!data.equals(""))) {
			JSWaiter jsw = new JSWaiter();
//			jsw.waitAllRequest();btt

			try {
				if (!elementName.toLowerCase().contains("password")) {
					test.log(Status.INFO, "Enter " + data + " in" + elementName + "field");
				}
				JavascriptExecutor js = (JavascriptExecutor) driver;
//				WebDriverWait wait = new WebDriverWait(driver, 20);   >> btt
				////(ExpectedConditions.visibilityOfElementLocated(by));
				WebElement e1 = null;
				try {
					waitForElementToAppear(by, 10);
					e1 = driver.findElement(by);
				}catch (Exception e) {
					test.log(Status.FAIL, "Failed to enter " + data + " in" + elementName + " field.");
					e.printStackTrace();
					test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementName)));
				}
				if (e1.isDisplayed()) {
					Actions actions = new Actions(driver);
					actions.moveToElement(e1).click().build().perform();
					e1.clear();
					e1.sendKeys(data);
					e1.sendKeys(Keys.TAB);
//					Thread.sleep(500); btt
//					jsw.waitAllRequest();btt
//					Thread.sleep(1500);btt
					if (!elementName.toLowerCase().contains("password")) {

						test.log(Status.PASS, data + " entered in " + elementName + " field Successfully.");

					}
				}
				else
					test.log(Status.FAIL,"Not able to find "+elementName);
			} catch (Exception e) {
				// TODO: handle exception
				WebElement e1 = driver.findElement(by);
				if (e1.isDisplayed()) {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e1);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
				// Assert.fail("Screenshot below: " +
				// test.addScreenCaptureFromPath(takeScreenShot(elementname)));
				try {
					test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementName)));
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				// test.addLog("Screenshot below: " +
				// test.addScreenCaptureFromPath(takeScreenShot(elementname)));
				test.log(Status.FAIL, "Failed to enter " + data + " in" + elementName + " field.");
				e.printStackTrace();
				jsw.waitAllRequest();

			}
		}
		JSWaiter jsw = new JSWaiter();

//		jsw.waitAllRequest();btt

	}
	public void inputTextandEnter(By by, String elementname, String data) throws Exception {
		if ((!data.isEmpty()) || (!data.equals(""))) {
			JSWaiter jsw = new JSWaiter();
			jsw.waitAllRequest();

			try {
				if (!elementname.toLowerCase().contains("password")) {
					test.log(Status.INFO, "  Enter   " +   data  + "   in   " + elementname + "  field");
				}
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebDriverWait wait = new WebDriverWait(driver, 20);
				ExpectedConditions.visibilityOfElementLocated(by);
				WebElement e1 = driver.findElement(by);
				if (e1.isDisplayed()) {
					Actions actions = new Actions(driver);
					actions.moveToElement(e1).click().build().perform();
					e1.clear();
					e1.sendKeys(data);
					Thread.sleep(500);
					e1.sendKeys(Keys.ENTER);
					jsw.waitAllRequest();
					Thread.sleep(1500);
					if (!elementname.toLowerCase().contains("password")) {

						test.log(Status.PASS, data + " entered in " + elementname + " field Successfully.");

					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				WebElement e1 = driver.findElement(by);
				if (e1.isDisplayed()) {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e1);
					Thread.sleep(500);
				}
				// Assert.fail("Screenshot below: " +
				// test.addScreenCaptureFromPath(takeScreenShot(elementname)));
				test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
				// test.addLog("Screenshot below: " +
				// test.addScreenCaptureFromPath(takeScreenShot(elementname)));
				test.log(Status.FAIL, "Failed to enter " + data + " in" + elementname + " field.");
				e.printStackTrace();
				jsw.waitAllRequest();

			}
		}
		JSWaiter jsw = new JSWaiter();

		jsw.waitAllRequest();
	}

	public void inputTextandTab(By by, String elementname, String data) throws Exception {
		if ((!data.isEmpty()) || (!data.equals(""))) {
			JSWaiter jsw = new JSWaiter();
			jsw.waitAllRequest();

			try {
				if (!elementname.toLowerCase().contains("password")) {
					test.log(Status.INFO, "Enter " + data + " in" + elementname + "field");
				}
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebDriverWait wait = new WebDriverWait(driver, 20);
				//(ExpectedConditions.visibilityOfElementLocated(by));
				WebElement e1 = driver.findElement(by);
				if (e1.isDisplayed()) {
					Actions actions = new Actions(driver);
					actions.moveToElement(e1).click().build().perform();
//					e1.clear();
//					Thread.sleep(500);
					e1.sendKeys(data);
					Thread.sleep(500);
					e1.sendKeys(Keys.TAB);
					jsw.waitAllRequest();
					Thread.sleep(1500);
					if (!elementname.toLowerCase().contains("password")) {

						test.log(Status.PASS, data + " entered in " + elementname + " field Successfully.");

					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				WebElement e1 = driver.findElement(by);
				if (e1.isDisplayed()) {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e1);
					Thread.sleep(500);
				}
				// Assert.fail("Screenshot below: " +
				// test.addScreenCaptureFromPath(takeScreenShot(elementname)));
				test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
				// test.addLog("Screenshot below: " +
				// test.addScreenCaptureFromPath(takeScreenShot(elementname)));
				test.log(Status.FAIL, "Failed to enter " + data + " in" + elementname + " field.");
				e.printStackTrace();
				jsw.waitAllRequest();

			}
		}
		JSWaiter jsw = new JSWaiter();

		jsw.waitAllRequest();
	}

	public void clickElementbysimpleclick(By by, String elementname) throws IOException {
		try {
			JSWaiter jsw = new JSWaiter();

			test.log(Status.INFO, "Click on" + elementname);

			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {

				Thread.sleep(500);

				e1.click();
				jsw.waitAllRequest();
				Thread.sleep(500);

				test.log(Status.PASS, "Clicked on  " + elementname + " Successfully.");
			}

		} catch (Exception e) {
			// TODO: handle exception
			// Assert.fail("Screenshot below: " +
			// test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			test.log(Status.FAIL, "Failed to Click on " + elementname + ".");
			e.printStackTrace();
		}
	}

	public String split(String mydata, String delimeter, int index) {

		try {

			String[] arrSplit_3 = mydata.split(delimeter);

			return (arrSplit_3[index]);
		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}

	public void selectByIndex(By by, String elementname, String data) throws Exception {
		try {
			test.log(Status.INFO, "Select " + elementname + " from the dropdown");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 120);
			//(ExpectedConditions.visibilityOfElementLocated(by));
			// //(ExpectedConditions.elementToBeSelected(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				Select se = new Select(e1);
				int val = Integer.parseInt(data.trim());
				se.selectByIndex(val);
				test.log(Status.PASS, elementname + " is selected from dropdown Successfully.");
			}
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.PASS, "Failed to select " + elementname + " from the dropdown.");
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			e.printStackTrace();
		}
	}

	public void PPMSelect(By by, String elementname, String data) throws Exception {
		if (!(data == null)) {
			if (!data.trim().isEmpty()) {
				String[] neadString = by.toString().split(":");
				WebElement e1 = driver.findElement(By.xpath(neadString[1].trim() + "//following::img"));
				try {
					JSWaiter jsw = new JSWaiter();
					JavascriptExecutor js = (JavascriptExecutor) driver;
					WebDriverWait wait = new WebDriverWait(driver, 20);
					//(ExpectedConditions.visibilityOfElementLocated(by));
					//(ExpectedConditions.elementToBeClickable(by));
					if (e1.isDisplayed()) {
						jsw.waitAllRequest();
						// ((JavascriptExecutor)
						// driver).executeScript("arguments[0].scrollIntoView(true);", e1);
						Actions actions = new Actions(driver);
						actions.moveToElement(e1).perform();
						Thread.sleep(700);
						jsw.waitAllRequest();
						e1.click();
						jsw.waitAllRequest();
						Thread.sleep(500);
					}
				} catch (Exception ee) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", e1);
					System.out.println("I got this");
					ee.printStackTrace();
				} 
				JSWaiter jsw = new JSWaiter();
				jsw.waitAllRequest();
				Thread.sleep(1500);
				driver.switchTo().frame("autoCompleteDialogIF");

				inputTextandEnter(Elements.findtext, "Data", data);
				jsw.waitAllRequest();
				Thread.sleep(1500);
				if (driver.findElements(By.xpath("//a[@id='filterPanelFindButton']")).size() != 0) {
					System.out.println("Find is Present" + elementname);
					clickElementByJs(Elements.findbutton, "Find");
				}
				jsw.waitAllRequest();

				// driver.switchTo().defaultContent();
				driver.switchTo().frame("availFrame");
				jsw.waitAllRequest();
				// driver.switchTo().frame("availFrame");
				clickElement(Elements.select, "Select Choice");
				jsw.waitAllRequest();
				driver.switchTo().defaultContent();

				Thread.sleep(2500);
				try {
					driver.switchTo().frame("autoCompleteDialogIF");
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (driver.findElements(By.xpath("//div[@id='btnOK']")).size() != 0) {
					System.out.println("Ok is Present" + elementname);
					clickElement(Elements.OkButton, "Ok");
				}
				driver.switchTo().defaultContent();
			}
		}
	}

	public void waitForElementToAppear(By by, long timeOutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			//(ExpectedConditions.visibilityOfElementLocated(by));
			wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 1));
		} catch (TimeoutException ignored) {
		}
	}

	public void passtest(String elementname) throws IOException {
		test.log(Status.PASS, elementname + "  ");

	}

	public void passtest(String elementname, String message) throws IOException {
		test.log(Status.PASS, message);

	}

	public void failtest(String elementname) throws IOException {
		test.log(Status.FAIL, elementname + " is not verified");

	}

	public void verifyfieldnotautopopulate(By by, String elementname) throws IOException {
		try {
			test.log(Status.INFO, "Verify not autopopulating:" + elementname);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 120);
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e1);
				Thread.sleep(500);
				String actualString = e1.getAttribute("value");
				if (!(actualString == null)) {

					if (actualString.isEmpty()) {
						System.out.println("Input field is empty");
						test.log(Status.PASS, elementname + " not auto populating");
					}
				} else {
					test.log(Status.PASS, elementname + " not auto populating(null)");

				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, elementname + " is auto populating data");
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			// Assert.fail("Screenshot below: " +
			// test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			e.printStackTrace();
		}
	}

	public void verifyfieldautopopulate(By by, String elementname) throws IOException {
		try {
			test.log(Status.INFO, "Verify " + elementname);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 120);
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e1);
				Thread.sleep(500);
				String actualString = e1.getAttribute("value");
				if (!(actualString == null)) {
					if (!actualString.isEmpty()) {
						System.out.println("Input field is not empty for " + elementname);
						test.log(Status.PASS, elementname + "  auto populating");
					} else {
						test.log(Status.FAIL, elementname + "  not auto populating");

					}
				} else {
					actualString = e1.getText();
					if ((actualString == null)) {

						test.log(Status.FAIL, elementname + "  not auto populating(null)");
					} else if (!actualString.isEmpty()) {
						System.out.println("Input field is not empty for " + elementname);
						test.log(Status.PASS, elementname + "  auto populating");
					} else {
						test.log(Status.FAIL, elementname + "  not auto populating");

					}
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, elementname + " is not auto populating data");
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			// Assert.fail("Screenshot below: " +
			// test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			e.printStackTrace();
		}
	}

	public String getSelectionintostring(By by) throws Exception {

		String elementdata = "";

		String[] neadString = by.toString().split(":");
		WebElement e1 = driver.findElement(By.xpath(neadString[1].trim() + "//following::img"));
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 20);
			//(ExpectedConditions.visibilityOfElementLocated(by));
			//(ExpectedConditions.elementToBeClickable(by));
			if (e1.isDisplayed()) {

				js.executeScript("arguments[0].click();", e1);
				Thread.sleep(500);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		JSWaiter jsw = new JSWaiter();
		jsw.waitAllRequest();
		Thread.sleep(2500);
		driver.switchTo().frame("autoCompleteDialogIF");

		try {
			driver.switchTo().frame("availFrame");
			Thread.sleep(500);
			int size = driver.findElements(Elements.select).size();

			for (int i = 1; i <= size; i++) {
				String temp = driver.findElement(By.xpath(
						"(//table[@id='datatable']//tbody//tr[not(contains(@style,'display: none'))]//th)[" + i + "]"))
						.getText();

				elementdata += temp + ",";

			}
			elementdata += " ,";
		} catch (Exception e) {
			e.printStackTrace();
		}

		driver.switchTo().defaultContent();
		clickElementByJs(Elements.closeselect, "Close Select");
		Thread.sleep(500);
		checkautocomplete();
		return elementdata;
	}

	public void checkautocomplete() throws Exception {

		boolean checker = driver.findElement(Elements.closeselect).isDisplayed();
		if (checker) {

			clickElement(Elements.closeselect, "Close Box");
			System.out.println("Box Closed");
		}

	}

	public String getDropDownstring(By by) {

		WebElement dropdowns = driver.findElement(by);
		Select select = new Select(dropdowns);
		List<WebElement> allOptions = select.getOptions();
		String uiOptions = "";

		for (WebElement allOption : allOptions) {

			uiOptions += allOption.getText() + ",";
		}
		return uiOptions;
	}

	public void Verifydropdownvalues(String Data, String UIlist, String elementname) throws IOException {

		int countfordata = Data.length() - Data.replace(",", "").length();
		int countforui = UIlist.length() - UIlist.replace(",", "").length();
		Data = Data.toLowerCase();
		UIlist = UIlist.toLowerCase();
		System.out.println("Data=" + countfordata);
		System.out.println("UI=" + countforui);
		if (countfordata == (countforui - 2)) {

			for (int i = 0; i <= countfordata; i++) {
				String mydata = split(Data, ",", i);
				System.out.println("Mydata:" + mydata);
				if (!UIlist.contains(mydata)) {

					test.log(Status.FAIL, "Data not mached = " + mydata + " For" + elementname);
					test.log(Status.FAIL,
							"Data found in excel = " + countfordata + " And Data found in UI = " + countforui);
					test.log(Status.FAIL, "Data found in excel = " + Data + " And Data found in UI = " + UIlist);
					test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot("UI")));

				} else {

					test.log(Status.PASS, "Verified values for dropdown:" + elementname);
				}

			}
		} else {

			test.log(Status.FAIL, "Data found in excel = " + countfordata + " And Data found in UI = " + countforui
					+ " For" + elementname);
			test.log(Status.FAIL, "Data found in excel = " + Data + " And Data found in UI = " + UIlist);
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot("UI")));

		}

	}
	public String getFieldText(By by, String elementname) throws Exception {
		String text = null;
		try {
		test.log(Status.INFO, "Verify Link " + elementname);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		WebElement e1 = driver.findElement(by);
		if (e1.isDisplayed() && e1.isEnabled()) {
		text = e1.getText();
		test.log(Status.PASS, "Text for " + elementname   + " Fetched ");
		if (text == null) {
		text = "";
		}
		}
		} catch (Exception e) {
		// TODO: handle exception
		// Assert.fail("Screenshot below: " +
		// test.addScreenCaptureFromPath(takeScreenShot(elementname)));
		test.log(Status.FAIL, "Link " + elementname + " does not exists");
		e.printStackTrace();
		}
		return text;
	}

	public String getobjecttext(By by, String elementname) throws Exception {
		String text = null;
		try {
			test.log(Status.INFO, "Verify Link " + elementname);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 10);
			// //(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			e1.getText();
            test.log(Status.PASS, "Link   " + elementname + " exists");
			test.pass("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
//			e.printStackTrace();
			if (e1.isDisplayed() && e1.isEnabled()) {
				text = e1.getAttribute("Value");
				// test.log(Status.PASS, "Text for " + elementname + " Fetched");
				if (text == null) {
					text = "";
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			// Assert.fail("Screenshot below: " +
			// test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			test.log(Status.FAIL, "Link  " + elementname + " does not exists");
			e.printStackTrace();
		}
		return text;
	}
	public String getobjectStatus(By by, String elementname) throws Exception {
		String text = null;
		try {
			test.log(Status.INFO, "Verify Link " + elementname);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 10);
			// //(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			e1.getText();
            test.log(Status.PASS, "Status   " + elementname + " exists");
			test.pass("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
//			e.printStackTrace();
			if (e1.isDisplayed() && e1.isEnabled()) {
				text = e1.getAttribute("Value");
				// test.log(Status.PASS, "Text for " + elementname + " Fetched");
				if (text == null) {
					text = "";
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			// Assert.fail("Screenshot below: " +
			// test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			test.log(Status.FAIL, "Link  " + elementname + " does not exists");
			e.printStackTrace();
		}
		return text;
	}
		

	public String getobjecttextreport(By by, String elementname) throws Exception {
		String text = null;
		try {
			test.log(Status.INFO, "Verify Link " + elementname);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 10);
			// //(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			String e2 = driver.findElement(By.xpath("//div[@data-automation-id='fileAttachment']")).getText();
			test.log(Status.PASS, "Link  " + elementname + " the output file is Eists");
			test.pass("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			((Throwable) e1).printStackTrace();
			if (e1.isDisplayed() && e1.isEnabled()) {
				text = e1.getAttribute("Value");
				test.log(Status.PASS, "Text for " + elementname + " Fetched");
				if (text == null) {
					text = "";
				}
			}
	
	}
catch (Exception e) {
///TODO: handle exception
 Assert.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
test.log(Status.FAIL, "Link  " + elementname + " does not exists");
e.printStackTrace();
}
	return text;
}

	
	
	public void verifystrings(String elementnameone, String elementname) throws Exception {

		try {
			test.log(Status.INFO, "Verify Link " + elementname + "," + elementnameone);
			if (elementname.equalsIgnoreCase(elementnameone)) {
				test.log(Status.PASS, "String Matched");
			} else {
				test.log(Status.FAIL, "Strings cannot be matched: Expected String - " + elementname + ",Actual string" + elementnameone);
			}

		} catch (Exception e) {
			// TODO: handle exception
			// Assert.fail("Screenshot below: " +
			// test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			test.log(Status.FAIL, "Couldnt Verify Strings");
			e.printStackTrace();
		}

	}
	public void verifystrings(By by, String expectedvalue, String label) throws Exception {

		try {

			String e1 = driver.findElement(by).getText();
			if (e1.equals("") && expectedvalue.equals("0")) {
			test.log(Status.PASS, "Value for "+label+" is matched :- Expected String: " + expectedvalue + ", Actual string: " + "0");
			}
			else {
				if (expectedvalue.equalsIgnoreCase(e1)) {
				test.log(Status.PASS, "Value for "+label+" is matched :- Expected String: " + expectedvalue + ", Actual string: " + e1);
				} else {
					test.log(Status.FAIL, "Failed to match value for "+label+" :- Expected String: " + expectedvalue + ", Actual string: " + e1);
	//				Assert.assertTrue(false,"Failed to match value for "+label+" :- Expected String: " + expectedvalue + ", Actual string: " + e1);
				}
		}

		} catch (Exception e) {
			// TODO: handle exception
			// Assert.fail("Screenshot below: " +
			// test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			test.log(Status.FAIL, "Couldnt Verify Strings");
//			test.log(Status.FAIL, "Failed to match value for "+label+" :- Expected String: " + expectedvalue + ", Actual string: " + e);

			e.printStackTrace();
		}

	}
	public void verifyList(By by, String expectedvalue, String label) throws Exception {

		try {

			List<WebElement> list = driver.findElements(by);

			for (WebElement webElement : list) {
				String actualvalue =  webElement.getText();

				if (expectedvalue.contains(actualvalue))
					test.log(Status.PASS, "Value for "+label+" is matched :- Expected String: " + expectedvalue + ", Actual string: " + actualvalue);
				else {
					test.log(Status.FAIL, "Failed to match value for "+label+" :- Expected String: " + expectedvalue + ", Actual string: " + actualvalue);
				}

			} 

		} catch (Exception e) {
			// TODO: handle exception
			// Assert.fail("Screenshot below: " +
			// test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			test.log(Status.FAIL, "Couldnt Verify Strings");
			e.printStackTrace();
		}

	}
	public void clickOnElement(By by, String elementname) throws IOException {
		try {
			WebElement e1 = driver.findElement(by);
					
				e1.click();
				
				GenericLib.UnhighlightElement(driver, e1, by);
				test.log(Status.PASS, "Clicked on  " + elementname + " Successfully.");
		}
		catch (Exception e) {
			// TODO: handle exception
			// Assert.fail("Screenshot below: " +
			// test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			test.log(Status.FAIL, "Failed to Click on " + elementname + ".");
			e.printStackTrace();
		}

	}

	public void clickElement(By by, String elementname) throws IOException {
		try {
			JSWaiter jsw = new JSWaiter();

//			test.log(Status.INFO, "Click on: " + elementname);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 15);
			//(ExpectedConditions.alertIsPresent());
			//(ExpectedConditions.visibilityOfElementLocated(by));
			//(ExpectedConditions.elementToBeClickable(by));
			WebElement e1 = driver.findElement(by);
			
			if (e1.isDisplayed()) {
				// Thread.sleep(500);
				// GenericLib.HighlightElement(driver, e1);
				jsw.waitAllRequest();
				e1.click();
				jsw.waitAllRequest();
				Thread.sleep(500);
				GenericLib.UnhighlightElement(driver, e1, by);
				test.log(Status.PASS, "Clicked on  " + elementname + " Successfully.");
				
			} else {

				System.out.println("Element is not visible:" + elementname);
				test.log(Status.FAIL, "Failed to Click on " + elementname + ".");

			}

		} catch (Exception e) {
			// TODO: handle exception
			// Assert.fail("Screenshot below: " +
			// test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			test.log(Status.FAIL, "Failed to Click on " + elementname + ".");
			e.printStackTrace();
		}
	}
	public void clickElementReport(By by, String elementname) throws IOException {
		try {
			JSWaiter jsw = new JSWaiter();

			test.log(Status.INFO, "Click on: " + elementname);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 15);
			//(ExpectedConditions.alertIsPresent());
			//(ExpectedConditions.visibilityOfElementLocated(by));
			//(ExpectedConditions.elementToBeClickable(by));
			WebElement e1 = driver.findElement(by);
			
			if (e1.isDisplayed()) {
				// Thread.sleep(500);
				// GenericLib.HighlightElement(driver, e1);
				jsw.waitAllRequest();
				e1.click();
				jsw.waitAllRequest();
				Thread.sleep(500);
				GenericLib.UnhighlightElement(driver, e1, by);
				test.log(Status.PASS, "Clicked on  " + elementname + " Successfully.");
				test.pass("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
				
			} else {
				test.pass("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
				test.log(Status.PASS, "PASS to Click on " + elementname + ".");
							
//				System.out.println("Element is visible:" + elementname);
//				test.log(Status.PASS, "pass to Click on " + elementname + ".");

			}

		} catch (Exception e) {
			// TODO: handle exception
			// Assert.fail("Screenshot below: " +
			// test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			test.log(Status.FAIL, "Failed to Click on " + elementname + ".");
			e.printStackTrace();
		}
	}


	
	public void hoveronelement(By by, String elementname) throws IOException {
		try {
			JSWaiter jsw = new JSWaiter();
			test.log(Status.INFO, "Click on" + elementname);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 15);
			//(ExpectedConditions.visibilityOfElementLocated(by));
			//(ExpectedConditions.elementToBeClickable(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {

				GenericLib.HighlightElement(driver, e1);
				jsw.waitAllRequest();
				Actions action = new Actions(driver);
				action.moveToElement(e1).build().perform();
				jsw.waitAllRequest();

				GenericLib.UnhighlightElement(driver, e1, by);
				test.log(Status.PASS, "Clicked on  " + elementname + " Successfully.");
			} else {

				System.out.println("Element is not visible:" + elementname);
				test.log(Status.FAIL, "Failed to Click on " + elementname + ".");

			}

		} catch (Exception e) {
			// TODO: handle exception
			// Assert.fail("Screenshot below: " +
			// test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			test.log(Status.FAIL, "Failed to Click on " + elementname + ".");
			e.printStackTrace();
		}
	}

	public void VerifyElementNotVisible(By by, String elementname) throws Exception {
		try {
			test.log(Status.INFO, "Verify is Element is not Visible : " + elementname);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			// WebDriverWait wait = new WebDriverWait(driver, 20);
			// //(ExpectedConditions.visibilityOfElementLocated(by));
			if (driver.findElements(by).size() != 0) {

				WebElement e1 = driver.findElement(by);
				if (e1.isDisplayed()) {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e1);
					Thread.sleep(500);
					test.log(Status.FAIL, elementname + " is Visible ,Expected to be invisible");

				} else {

					test.log(Status.PASS, elementname + " is  not Visible");
				}
			} else {
				test.log(Status.PASS, elementname + " is  not Visible");

			}
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Failed as Element is visible :  " + elementname);
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			e.printStackTrace();
		}
	}

	public void VerifyElementVisible(By by, String elementname) throws Exception {
		try {
			test.log(Status.INFO, "Verify is Element Visible_  " + elementname);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 40);
			//(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e1);
				Thread.sleep(500);
				test.log(Status.PASS, elementname + " is Visible");
			} else {

				test.log(Status.FAIL, elementname + " is not Visible ");
			}

		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Failed as Element is  " + elementname);
			test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
			e.printStackTrace();
		}
	}

	public void selectByText(By by, String elementname, String data) throws Exception {
		if (!data.isEmpty()) {
			JSWaiter jsw = new JSWaiter();

			jsw.waitAllRequest();
			try {
				test.log(Status.INFO, "Select " + data + " from the dropdown " + elementname);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebDriverWait wait = new WebDriverWait(driver, 15);
				//(ExpectedConditions.visibilityOfElementLocated(by));
				// //(ExpectedConditions.elementToBeSelected(by));
				WebElement e1 = driver.findElement(by);
				if (e1.isDisplayed()) {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e1);
					Thread.sleep(500);
					Select se = new Select(e1);
					se.selectByVisibleText(data.trim());
					test.log(Status.PASS, data + " is selected from dropdown " + elementname + " Successfully.");

				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Failed To Select" + data);
				test.log(Status.FAIL, "Failed to select " + data + " from the dropdown" + elementname);
				test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(elementname)));
				// Assert.fail("Screenshot below: " +
				// test.addScreenCaptureFromPath(takeScreenShot(elementname)));
				e.printStackTrace();
			}
			jsw.waitAllRequest();
		}
	}
}
