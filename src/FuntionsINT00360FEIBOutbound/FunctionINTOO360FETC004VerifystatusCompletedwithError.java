package FuntionsINT00360FEIBOutbound;
import Utility.*;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.util.Properties;

public class FunctionINTOO360FETC004VerifystatusCompletedwithError extends BaseClass {
	GenericLib gl = new GenericLib(this.getClass().getSimpleName());

	public void Login() throws Exception {
		extent = ExtentManger.GetExtent();
		Properties config = new Properties();
		String path = System.getProperty("user.dir"); // return project folder
		String configpath = path + "\\src\\Config\\Config.properties";
		System.out.println("Searching config in :" + configpath);

		FileInputStream fis = new FileInputStream(configpath);
		config.load(fis);
		gl.launchApplication(config.getProperty("browser"), config.getProperty("URLWorkday"));
		JSWaiter.setDriver(driver);
		JSWaiter jsw = new JSWaiter();
		jsw.waitAllRequest();
	
//		gl.inputTextandEnter(Elements.workday_username, "workday_username",config.getProperty("UserName"));
		Thread.sleep(2000);
//		gl.inputText(Elements.workday_Password, "workday_Password",config.getProperty("Password"));
		Thread.sleep(2000);
//		gl.ClickButton(Elements.workday_SignInButton, "workday_SignInButton");
//		gl.clickElement(Elements.workday_SignInButton, "workday_SignInButton");
		gl.inputText(Elements.workday_username, "workday_username",config.getProperty("UserName"));
		gl.inputText(Elements.workday_Password, "workday_Password",config.getProperty("Password"));
		gl.clickElement(Elements.workday_SignInButton, "workday_SignInButton");
		Thread.sleep(10000);
			
	}

	public void VerifystatusCompletedwithError(String Intigration_ID,String Status,String Messages) throws Exception {

		JSWaiter.setDriver(driver);
		JSWaiter jsw = new JSWaiter();
		jsw.waitAllRequest();
		Thread.sleep(2000);
		
//		gl.ClickButton(Elements.workday_searchicon, "workday_searchicon");
		gl.clickElement(Elements.workday_searchicon, "workday_search icon");
		Thread.sleep(2000);
		gl.inputTextandTab(Elements.workday_globalSearchbox, "Intigration ID", Intigration_ID);
//		gl.inputText(Elements.workday_globalSearchbox, "PLM_ID",Intigration_ID);
		Thread.sleep(2000);
		gl.clickElement(Elements.workday_searchicon, "workday_searchicon");

//		gl.ClickButton(Elements.workday_searchicon, "workday_searchicon");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@data-automation-id='pex-related-actions']")).click();
//		driver.findElement(By.xpath("//div[@data-automation-id='pex-search-result-header']")).click();
		gl.clickElement(Elements.workday_IS, "IntigrationSystem");
//		gl.clickElement(Elements.workday_EventStatusFailed, "workday_EventStatusFailed");
//		gl.inputTextandEnter(Elements.workday_eventStatau, "status",IntegrationEventStatus);
//		gl.clickElement(Elements.workday_EventStatus, "Status");
	    Thread.sleep(5000);

		gl.clickElement(Elements.workday_IntigrationeventStatau, "Status");
		//div[.='Failed']/preceding-sibling::div[@data-automation-id='checkbox']
		driver.findElement(By.xpath("//div[.='Completed With Errors']/preceding-sibling::div[@data-automation-id='checkbox']")).click();
//		(//input[@dir='ltr'])[1]
//		driver.findElement(By.xpath("(//input[@dir='ltr'])[1]")).click();

//		gl.clickElement(Elements.workday_EventStatusCompletedwithError, "CompletedWithError");
//		workday_EventStatusCompletedwithError
//		gl.clickElement(Elements.workday_IntigrationeventStatau, "Status");
		
//		driver.findElement(By.xpath("//div[@id='promptOption-131e671d-13c4-4d05-8284-bdf4a1e305a8']")).click();
//		Thread.sleep(5000);
//		gl.clickElement(Elements.workday_IntigrationeventStatau, "Status");
//		gl.clickOnElement(Elements.workday_Ok1, "OK");
//		Thread.sleep(1000);
		gl.clickOnElement(Elements.workday_Ok1, "OK");
		gl.clickElement(Elements.workday_Ok1, "OK");
		Thread.sleep(5000);
//		gl.clickElement(Elements.workday_Ok1, "OK");
	//	gl.clickElement(Elements.workday_IEvents, "workday_IntigrationEvents");
		System.out.println("Click Sucessfully");
//      no need ----gl.clickElement(Elements.Integration_EventsFailed, "FailedStatus");
//		gl.verifystrings(Elements.workday_Statusfailed, Status,"Status");
        gl.clickElement(Elements.CompletedwithEIBErrorMessage, "CompletedWithError");
        Thread.sleep(2000);

		gl.verifystrings(Elements.EIBStatusCompletedwithError, Status,"Status");

        gl.clickElement(Elements.ClickMessage, "ClickMessage");
        Thread.sleep(2000);

		gl.verifystrings(Elements.EIBfullErrorMessage, Messages,"Messages");
		gl.ScrollPage();
//		CompletedWithError
		
		Thread.sleep(5000);
		
//		gl.ScrollPage();
//        gl.clickElementReport(Elements.OutputFiles, "OutputFiles");
		gl.getFieldText(Elements.EIBfullErrorMessage, "CompletedwithErrorMessage");
		
//		EIBfullErrorMessage
		
		
//		gl.clickElementReport(Elements.CompletedwithError, "CompletedwithError");
		//*[text()='Completed With Errors']
//		Thread.sleep(15000);
		
//		gl.ScreenShotReport("CompletedwithError");

//      gl.clickElementReport(Elements.ClickMessage, "FailedMessage");
//        
//        gl.takeScreenShot("ClickMessage");
//        gl.takeScreenShot("Done");
        gl.ScreenShotReport(Intigration_ID);

		
		
//		Thread.sleep(2000);
//		

		
		//gl.ClickButton(Elements.button_Close, "Close Button");
	}

	@BeforeMethod
	public void beforemethod() {
		extent = ExtentManger.GetExtent();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
		extent.flush();
	}
}
